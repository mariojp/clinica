package br.com.med.clinica.atendimento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;

@Controller
public class AtendimentoController {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@GetMapping("/atendimento")
	public String listDroga(Model model) {
		List<Atendimento> atendimentos = atendimentoRepository.findAll();
		model.addAttribute("atendimentos", atendimentos);
		return "/atendimento/atendimento";
	}

	@GetMapping("/atendimento/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Atendimento atendimento = new Atendimento();
		if (id != null) {
			Optional<Atendimento> op = atendimentoRepository.findById(id);
			if (op.isPresent()) {
				atendimento = op.get();
			}
		}
		model.addAttribute("droga", atendimento);

		return "/atendimento/atendimentoform";
	}

	@PostMapping("/atendimento/salvar")
	public String salvar(Atendimento atendimento) {
		atendimentoRepository.save(atendimento);
		return "redirect:/atendimento";
	}

	@GetMapping("/atendimento/delete")
	public String delete(Long id) {
		atendimentoRepository.deleteById(id);
		return "redirect:/atendimento";
	}

	@PutMapping("/atendimento/alterar")
	public String alterar(Long id, String conduta) {
		Atendimento atendimento = new Atendimento();
		Optional<Atendimento> ok = atendimentoRepository.findById(id);

		if (ok.isPresent()) {
			atendimento = ok.get();
			atendimento.setConduta(conduta);
		}

		salvar(atendimento);

		return "redirect:/atendimento";
	}
}
