package br.com.med.clinica.administrativo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;

@Controller()
public class FuncionarioController {
	
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("/funcionario")
	public String listFuncionario(Model model) {
		List<Funcionario> funcionarios =  funcionarioRepository.findAll();
		model.addAttribute("funcionarios",funcionarios);
		return "/administrativo/funcionario";
	}
	
	@GetMapping("/funcionario/form")
	public String form(Model model,@Param(value = "oid") Long oid) {
		Funcionario funcionario = new Funcionario();
		if(oid != null) {
			Optional<Funcionario> op = funcionarioRepository.findById(oid);
			if(op.isPresent()) {
				funcionario = op.get();
			}
		}
		model.addAttribute("funcionario",funcionario);
		
		return "/administrativo/funcionarioform";
	}
	
	@PostMapping("/funcionario/salvar")
	public String salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return "redirect:/funcionario";
	}
	
	@GetMapping("/funcionario/delete")
	public String delete(Long oid) {
		funcionarioRepository.deleteById(oid);
		return "redirect:/funcionario";
	}
}