package med.voll.api.dto.medico;


import med.voll.api.domain.medico.Medico;

// campos que serao devolvidos no front
public record DadosListagemMedico(
Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade){

        // cria o construtor
        public DadosListagemMedico(Medico medico){
            this(medico.getId(),
                    medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getEspecialidade());
}

}
