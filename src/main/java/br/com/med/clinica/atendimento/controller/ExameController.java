package br.com.med.clinica.atendimento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.atendimento.model.Exame;
import br.com.med.clinica.atendimento.repository.ExameRepository;

public class ExameController {

	private ExameRepository exameRepository;
	
	@GetMapping("/exame")
	public String listExame(Model model) {
		List<Exame> exames = exameRepository.findAll();
		model.addAttribute("exame", exames);
		return "/atendimento/exame";
	}

	@GetMapping("/exame/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Exame exame = new Exame();
		if (id != null) {
			Optional<Exame> op = exameRepository.findById(id);
			if (op.isPresent()) {
				exame = op.get();
			}
		}
		model.addAttribute("Exame", exame);
		
		return "/atendimento/exameform";
	}

	@PostMapping("/exame/salvar")
	public String salvar(Exame exame) {
		exameRepository.save(exame);
		return "redirect:/exame";
	}

	@GetMapping("/exame/delete")
	public String delete(Long id) {
		exameRepository.deleteById(id);
		return "redirect:/exame";
	}
}
