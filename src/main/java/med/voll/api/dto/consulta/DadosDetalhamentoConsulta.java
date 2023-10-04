package med.voll.api.dto.consulta;

import med.voll.api.domain.consulta.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
        Long id,

        Long idMedico,
        Long idPaciente,
        LocalDateTime data
) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(),consulta.getPaciente().getId(),consulta.getData());
    }
}
