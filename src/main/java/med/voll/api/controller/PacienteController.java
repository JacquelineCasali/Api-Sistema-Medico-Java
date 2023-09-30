package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import med.voll.api.dto.paciente.DadosAtualizarPaciente;
import med.voll.api.dto.paciente.DadosCadastroPaciente;
import med.voll.api.dto.paciente.DadosDetalhadoPaciente;
import med.voll.api.dto.paciente.DadosListagemPaciente;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("pacientes")
public class PacienteController  {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    //ResponseEntity resposta
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder ){
       var paciente =new Paciente(dados);
        repository.save(paciente);
        var uri= uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhadoPaciente(paciente));

    }

    // listar
// size quantidade de registro na pagina
    // sort = ordenado pelo nome
//findAllByAtivoTrue traz so os ativos
    @GetMapping
    public ResponseEntity <Page<DadosListagemPaciente>> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){

        var page= repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
        return  ResponseEntity.ok(page);

}
@PutMapping
    @Transactional
    public  ResponseEntity atualizar (@RequestBody @Valid DadosAtualizarPaciente dados){
var paciente =repository.getReferenceById(dados.id());
paciente.atualizarInformacoes(dados);
return  ResponseEntity.ok(new DadosDetalhadoPaciente(paciente));
    }

// inativar pacientes
    @DeleteMapping("/{id}")
    @Transactional
public  ResponseEntity  deletar (@PathVariable Long id){
        var paciente=repository.getReferenceById(id);
        paciente.inativar();
        return ResponseEntity.noContent().build();
    }


    // detalhar
//    ResponseEntity messnagem do codigo
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        // recupera o banco de dados
        var paciente =repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhadoPaciente(paciente));
    }
}
