package br.com.med.clinica.administrativo.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;


@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionario")
    public String listFuncionario(Model model) {
        List<Funcionario> funcionarios =  funcionarioRepository.findAll();
        model.addAttribute("funcionarios",funcionarios);
        return "/administrativo/funcionariolist";
        		
    }
   

    @GetMapping("/funcionario/form")
    public String form(Model model,@Param(value = "id") Long id) {
        Funcionario funcionario = new Funcionario();
        if(id != null) {
            Optional<Funcionario> op = funcionarioRepository.findById(id);
            if(op.isPresent()) {
                funcionario = op.get();
            }
        }
        model.addAttribute("funcionario",funcionario);

        return "/administrativo/funcionarioform";

    }
    

    @PostMapping("/funcionario/salvar")
    public String salvar(@Valid Funcionario funcionario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/administrativo/funcionarioform";
        }
        funcionarioRepository.save(funcionario);
        return "redirect:/funcionario";
    }


    @GetMapping("/funcionario/delete")
    public String delete(Long id) {
        funcionarioRepository.deleteById(id);
        return "redirect:/funcionario";
    }


}
