package br.edu.ifrn.info4v.web.controladores;

import br.edu.ifrn.info4v.persistencia.modelo.Academia;
import br.edu.ifrn.info4v.persistencia.repositorio.AcademiaRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime; // Importe LocalDateTime

@Controller
@RequestMapping("/academias")
public class AcademiaControle {

    @Autowired
    private AcademiaRepo academiaRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("academias", academiaRepo.findAll());
        return "Academia/lista-academia"; // Criaremos este template
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("academia", new Academia());
        return "Academia/formulario-academia"; // Criaremos este template
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute("academia") Academia academia, BindingResult result) {
        if (academiaRepo.findByCnpj(academia.getCnpj()).isPresent()) {
            result.rejectValue("cnpj", "erro.duplicado", "Já existe uma academia com este CNPJ");
        }

        if (result.hasErrors()) {
            return "Academia/formulario-academia";
        }
        academia.setDataCadastro(LocalDateTime.now()); // Define a data de cadastro automaticamente
        academiaRepo.save(academia);
        return "redirect:/academias";
    }
}