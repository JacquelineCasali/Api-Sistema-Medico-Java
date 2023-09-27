package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// carrega no inicio do projeto no sping
@RestController
//passar o url
@RequestMapping("medicos")
public class MedicoController {

    // para instanciar a classe
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    // transação ativa com o banco de dados
    @Transactional
//    RequestBody corpo da requisição string traz o corpo  interiro
    // para traze dados espesificos atribui a uma classe
    public void  cadastrar(@RequestBody  @Valid  DadosCadastroMedico dados){
       //para salvar
        // trasformar  o medico em construtor
        repository.save(new Medico(dados));

    }

}
