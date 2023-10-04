package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


//import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.dto.consulta.DadosAgendamentoConsulta;
import med.voll.api.dto.consulta.DadosDetalhamentoConsulta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// carrega no inicio do projeto no sping
@RestController
//passar o url
@RequestMapping("consultas")
//todos os dados precisa de autenticação
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    // transação ativa com o banco de dados para cadastrar e editar

//    RequestBody corpo da requisição string traz o corpo  interiro

    @PostMapping
    @Transactional

    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
    var agendamento = agenda.agendar(dados);

        return ResponseEntity.ok(agendamento);
    }
    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
