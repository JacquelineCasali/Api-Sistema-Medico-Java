package med.voll.api.dto.paciente;

import jakarta.validation.Valid;
import med.voll.api.dto.endereco.DadosEndereco;

public record DadosAtualizarPaciente(
        Long id,
        String nome,
        String email,
        String telefone,
       @Valid DadosEndereco endereco
) {
}
