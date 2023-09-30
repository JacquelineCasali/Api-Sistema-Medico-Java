package med.voll.api.domain.paciente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.dto.paciente.DadosAtualizarPaciente;
import med.voll.api.dto.paciente.DadosCadastroPaciente;

@Table(name="pacientes")
@Entity(name="Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String nome;
    private String email;

    private  String telefone;

    private  String cpf;

    // chamando de outra tabela
    @Embedded
    private Endereco endereco;
    private  boolean ativo;
    public Paciente(DadosCadastroPaciente dados) {
        this.ativo=true;
        this.nome=dados.nome();
        this.email= dados.email();
        this.telefone=dados.telefone();
        this.cpf=dados.cpf();
        this.endereco=new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarPaciente dados) {

        if(dados.nome() !=null){
            this.nome= dados.nome();
        }

        if(dados.email() !=null){
            this.email= dados.email();
        }

        if(dados.telefone() !=null){
            this.telefone= dados.telefone();
        }
        if(dados.endereco() !=null){
            this.endereco.atualizaInformacoes(dados.endereco());
        }

    }

    public void inativar() {
        this.ativo=false;
    }
}

