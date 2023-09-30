package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return  ResponseEntity.notFound().build();
    }
// tratar error 400
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
   // campo que deu error
    var erros =ex.getFieldErrors();

    return  ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacao::new).toList());
}

private  record  DadosErrosValidacao(String campo, String mensagem){

        public  DadosErrosValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
}
}
