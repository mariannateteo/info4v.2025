package br.edu.ifrn.info4v;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaSpringBoot {

      @GetMapping("/")
      public String index(){
        return "Olá Spring Boot ";
        

      }
}
