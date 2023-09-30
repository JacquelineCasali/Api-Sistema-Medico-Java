package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.medico.DadosAtualizacoaMedico;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.Especialidade;
import med.voll.api.domain.endereco.Endereco;


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
   private  boolean ativo;

    public Medico(DadosCadastroMedico dados) {
this.ativo=true;
        this.nome=dados.nome();
        this.email= dados.email();
        this.telefone=dados.telefone();
        this.especialidade=dados.especialidade();
        this.crm= dados.crm();
        this.endereco=new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacoaMedico dados) {
// se for diferente de nulo atualiza os dados
       if(dados.nome() !=null){
           this.nome= dados.nome();
        }

        if(dados.telefone() !=null){
            this.telefone= dados.telefone();
        }
        if(dados.endereco() !=null){
            this.endereco.atualizaInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo=false;
    }
}
