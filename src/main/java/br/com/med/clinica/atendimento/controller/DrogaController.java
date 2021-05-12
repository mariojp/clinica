package br.com.med.clinica.atendimento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		List<Droga> drogas = drogaRepository.findAll();
		model.addAttribute("drogas", drogas);
		return "/atendimento/droga";
	}

	@GetMapping("/droga/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Droga droga = new Droga();
		if (id != null) {
			Optional<Droga> op = drogaRepository.findById(id);
			if (op.isPresent()) {
				droga = op.get();
			}
		}
		model.addAttribute("droga", droga);

		return "/atendimento/drogaform";
	}

	@PostMapping("/droga/salvar")
	public String salvar(Droga droga) {
		drogaRepository.save(droga);
		return "redirect:/droga";
	}

	@GetMapping("/droga/delete")
	public String delete(Long id) {
		drogaRepository.deleteById(id);
		return "redirect:/droga";
	}

}
