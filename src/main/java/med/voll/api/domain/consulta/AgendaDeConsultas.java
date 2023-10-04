package med.voll.api.domain.consulta;


import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsultas;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;

import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.dto.consulta.DadosAgendamentoConsulta;
import med.voll.api.dto.consulta.DadosDetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Service execulta as regras de negocios e validações da aplicação
@Service
public class AgendaDeConsultas {
  @Autowired
  private ConsultaRepository consultaRepository;
  @Autowired
  private MedicoRepository medicoRepository;

  @Autowired
  private PacienteRepository pacienteRepository;

  //validação de agendamento
    @Autowired
    private List<ValidadorAgendamentoDeConsultas> validadores;

    // validação de cancelamento
    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){
// checar se tem paciente cadastrado
    if(!pacienteRepository.existsById(dados.idPaciente())){
    throw new ValidacaoException("Id do paciente informado não existe");
    }

    // medico pode ser nulo a escolha do medico é opcional
    if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
        throw new ValidacaoException("Id do medico informado não existe");
    }
    // pecorre a lista e chama os validadr
    validadores.forEach(v -> v.validar(dados));
    // regra de negocios

    var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
    var medico = escolherMedico(dados);
    // se tem medico disponivel na data
    if(medico == null){
        throw new ValidacaoException("Não existe médico disponivel nessa data");
    }

    var consulta = new Consulta(null, medico, paciente, dados.data(),null);
    consultaRepository.save(consulta);

    return new DadosDetalhamentoConsulta(consulta);
}

public void cancelar(DadosCancelamentoConsulta dados){
if(!consultaRepository.existsById(dados.idConsulta())){
    throw new ValidacaoException("Id da consulta informado não existe!");
}
    validadoresCancelamento.forEach(v -> v.validar(dados));
    var consulta = consultaRepository.getReferenceById(dados.idConsulta());
    consulta.cancelar(dados.motivo());
}



//chamar medico aleatorio
    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
// chegando id do medico no banco de dados
        if(dados.idMedico() != null){
           return medicoRepository.getReferenceById(dados.idMedico());
        }
//escolher medico no banco de dados

// verificando se a especialidade foi preenchida
if(dados.especialidade() == null){
    throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido");

}
return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(),dados.data());
    }

}
