package med.voll.api.dto.paciente;

import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.paciente.Paciente;


public record DadosDetalhadoPaciente(

        Long Id,

        String nome,

        String email ,

        String telefone,
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        Endereco enddereco

) {
    public DadosDetalhadoPaciente(Paciente paciente){
        this(paciente.getId(),
                paciente.getNome(), paciente.getEmail(), paciente.getTelefone(),
                paciente.getCpf(), paciente.getEndereco());
    }

}
