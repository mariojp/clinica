package br.com.med.clinica.atendimento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.atendimento.model.Receita;
import br.com.med.clinica.atendimento.repository.ReceitaRepository;

@Controller
public class ReceitaController {
	@Autowired
	private ReceitaRepository receitaRepository;
	//Criação da lista e linkando com o repositório
	@GetMapping("/receita")
	public String listDroga(Model model) {
		List<Receita> receitas =  receitaRepository.findAll();
		model.addAttribute("receitas",receitas);
		return "/atendimento/receita";
	}
	// Pegando um dado do repositório
	@GetMapping("/receita/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Receita receita = new Receita();
		if(id != null) {
			Optional<Receita> op = receitaRepository.findById(id);
			if(op.isPresent()) {
				receita = op.get();
			}
		}
		model.addAttribute("receita",receita);
		
		return "atendimento/receitaform";
	}
	// Salvando algo na lista (Pegando os dados do .html)
	@PostMapping("/receita/salvar")
	public String salvar(Receita receita) {
		receitaRepository.save(receita);
		return "redirect:/receita";
	}
	

	@GetMapping("/receita/delete")
	public String delete(Long id) {
		receitaRepository.deleteById(id);
		return "redirect:/receita";
	}
}
