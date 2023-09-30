package med.voll.api.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="usuarios")
@Entity(name="Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String login;
    private String senha;

//    public Usuario(DadosCadastroUsuario dados) {
//        this.ativo=true;
//        this.nome=dados.nome();
//        this.email= dados.email();
//        this.senha=dados.senha();
//
//    }
//
//    public void atualizarInformacoes(DadosAtualizarUsuario dados) {
//        // se for diferente de nulo atualiza os dados
//        if(dados.email() !=null){
//            this.email= dados.email();
//        }
//
//        if(dados.senha() !=null){
//            this.senha= dados.senha();
//        }
    }

//    public void excluir() {
//        this.ativo=false;
//    }
//}

