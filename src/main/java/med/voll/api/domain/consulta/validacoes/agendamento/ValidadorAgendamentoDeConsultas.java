package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.dto.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsultas {
    void validar(DadosAgendamentoConsulta dados);
}
