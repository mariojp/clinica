package br.com.med.clinica.atendimento.controller;

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

import br.com.med.clinica.atendimento.model.Droga;
import br.com.med.clinica.atendimento.repository.DrogaRepository;


@Controller
public class DrogaController {

	
	@Autowired
	private DrogaRepository drogaRepository;

	@GetMapping("/droga")
	public String listDroga(Model model) {
		// Cria a lista e ja passa os atributos do repositorio
		List<Droga> drogas =  drogaRepository.findAll();
		model.addAttribute("drogas",drogas);
		return "/atendimento/droga";
	}
	
	// Pegando um dado do repositório e verificando se ja existe algo naquele id passado
	@GetMapping("/droga/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Droga droga = new Droga();
		if(id != null) {
			//Se ja existe um id ele pega e atribui
			Optional<Droga> op = drogaRepository.findById(id);
			if(op.isPresent()) {
				droga = op.get();
			}
		}
		//Aqui ele atribui às variaveis ao que foi passado
		model.addAttribute("droga",droga);
		
		return "/atendimento/drogaform";
	}
	

	@PostMapping("/droga/salvar")
	public String salvar(@Valid Droga droga, BindingResult bindingResult) {
		//Biding Result é uma estrutura para ajudar captar resultados, nesse caso está captando erros
		if (bindingResult.hasErrors()) {
			System.out.println("Erros");
			bindingResult.getAllErrors().forEach(e -> System.out.println(e));

			return "/atendimento/drogaform";
		}

		drogaRepository.save(droga);
		return "redirect:/droga";
		}
	
	@GetMapping("/droga/delete")
	public String delete(Long id) {
		drogaRepository.deleteById(id);
		return "redirect:/droga";
	}

	
}
