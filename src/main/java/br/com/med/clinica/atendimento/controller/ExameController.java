package br.com.med.clinica.atendimento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.atendimento.model.Exame;
import br.com.med.clinica.atendimento.repository.ExameRepository;


@Controller
public class ExameController {

	@Autowired
	private ExameRepository exameRepository;
	//Criação da lista e linkando com o repositório
	@GetMapping("/exame")
	public String listDroga(Model model) {
		List<Exame> exames =  exameRepository.findAll();
		model.addAttribute("exames",exames);
		return "/atendimento/exame";
	}
	
	// Pegando um dado do repositório
	@GetMapping("/exame/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Exame exame = new Exame();
		if(id != null) {
			Optional<Exame> op = exameRepository.findById(id);
			if(op.isPresent()) {
				exame = op.get();
			}
		}
		model.addAttribute("exame",exame);
		
		return "atendimento/exameform";
	}
	
	// Salvando algo na lista (Pegando os dados do .html)
	
	@PostMapping("/exame/salvar")
	public String salvar(@Validated Exame exame, BindingResult bindingResult) {
		exameRepository.save(exame);
		return "redirect:/exame";
	}
	

	@GetMapping("/exame/delete")
	public String delete(Long id) {
		exameRepository.deleteById(id);
		return "redirect:/exame";
	}
	
}
