package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.medico.DaddosDetalhamentoMedico;
import med.voll.api.dto.medico.DadosAtualizacoaMedico;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.DadosListagemMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



// carrega no inicio do projeto no sping
@RestController
//passar o url
@RequestMapping("medicos")
public class MedicoController {

    // para instanciar a classe
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    // transação ativa com o banco de dados para cadastrar e editar
    @Transactional
//    RequestBody corpo da requisição string traz o corpo  interiro

    public ResponseEntity  cadastrar(@RequestBody  @Valid  DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
       var medico=new Medico(dados);
        //para salvar
        // trasformar  o medico em construtor


        repository.save(medico);
        //uri é o endereço da api
        // UriComponentsBuilder gere o endereço
        var uri= uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        // mensagem
        return  ResponseEntity.created(uri).body(new DaddosDetalhamentoMedico(medico));
    }
    // metodo de leitura
    @GetMapping
    //paginaçao determina a quantidade que vai aparecer na tela
// size quantidade de registro na pagina
    // sort = ordenado pelo nome
        public ResponseEntity <Page<DadosListagemMedico>> listar (@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        // repository acessa o banco de dados
        //findAll lista
        // toList converte para uma lista
        //findAllByAtivoTrue traz so os ativos
        var page =  repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    // atualizar
    @PutMapping
    @Transactional
public  ResponseEntity  atualizar (@RequestBody @Valid DadosAtualizacoaMedico dados){
// acessando o banco de dados so precisa atualizar o item que quer
        var medico =repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return  ResponseEntity.ok(new DaddosDetalhamentoMedico(medico));
    }


    // inativar
//    ResponseEntity messnagem do codigo
    @DeleteMapping("/{id}")
    @Transactional

    public ResponseEntity excluir(@PathVariable Long id){
        // recupera o banco de dados
    var medico =repository.getReferenceById(id);
    medico.excluir();
    return ResponseEntity.noContent().build();
}

    // detalhar
//    ResponseEntity messnagem do codigo
    @GetMapping("/{id}")


    public ResponseEntity detalhar(@PathVariable Long id){
        // recupera o banco de dados
        var medico =repository.getReferenceById(id);

        return ResponseEntity.ok(new DaddosDetalhamentoMedico(medico));
    }
}
