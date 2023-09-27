package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.Especialidade;
import med.voll.api.endereco.Endereco;


// usando a jpa
@Table(name="medicos")
@Entity(name = "Medico")
// chamando o loombok compila e gera os codigos automaticos
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String nome;
    private String email;
    private  String telefone;
    private  String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

   @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome=dados.nome();
        this.email= dados.email();
        this.telefone=dados.telefone();
        this.especialidade=dados.especialidade();
        this.crm= dados.crm();
        this.endereco=new Endereco(dados.endereco());
    }
}
