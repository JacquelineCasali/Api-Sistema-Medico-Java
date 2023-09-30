package med.voll.api.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dto.endereco.DadosEndereco;

// faz a validação @notblack não é nulo nem vazio
public record DadosCadastroMedico(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido")
        String email ,
        @NotBlank(message = "Telefone é obrigatório")
       String telefone,

        @NotBlank(message = "CRM é obrigatório")
        // de 4 a 6 digitos
        @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido")

        String crm,
        @NotNull(message = "Especialidade é obrigatória")
        Especialidade especialidade,
        @NotNull(message = "Dados do endereço são obrigatórios")
// para validar outra anotação coloca o valid
        @Valid
        DadosEndereco endereco) {
}
