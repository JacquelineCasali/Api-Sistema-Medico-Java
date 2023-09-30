package med.voll.api.dto.paciente;

import med.voll.api.domain.paciente.Paciente;

public record DadosListagemPaciente(
        Long id,
        String nome,
        String email,
        String telefone

) {
    public  DadosListagemPaciente (Paciente paciente){
        this(paciente.getId(),
                paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }

}
