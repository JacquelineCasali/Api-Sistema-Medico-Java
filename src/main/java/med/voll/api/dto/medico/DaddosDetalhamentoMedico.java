package med.voll.api.dto.medico;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.Medico;

public record DaddosDetalhamentoMedico(

        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        Especialidade especialidade,
Endereco enddereco)
 {
  public DaddosDetalhamentoMedico(Medico medico){
   this(medico.getId(),
           medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getTelefone(),
           medico.getEspecialidade(), medico.getEndereco());
  }
}
