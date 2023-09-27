package med.voll.api.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dto.endereco.DadosEndereco;

// faz a validação @notblack não é nulo nem vazio
public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email ,
       @NotBlank
       String telefone,

       @NotBlank
               // de 4 a 6 digitos
        @Pattern(regexp = "\\d{4,6}")
        String crm,
      @NotNull
        Especialidade especialidade,
        @NotNull
// para validar outra anotação coloca o valid
        @Valid
        DadosEndereco endereco) {
}
