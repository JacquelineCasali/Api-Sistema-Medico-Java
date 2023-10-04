package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

// endereço
@RequestMapping("/")
public class HelloController {
   // chama o metodo
    @GetMapping
    public  String olamundo(){
        return  "Hello ";
    }
}
