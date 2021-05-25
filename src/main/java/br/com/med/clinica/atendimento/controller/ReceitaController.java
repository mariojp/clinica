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

import br.com.med.clinica.atendimento.model.Receita;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;
import br.com.med.clinica.atendimento.repository.ReceitaRepository;

@Controller
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@GetMapping("/receita")
	public String listItem(Model model) {
		List<Receita> receitas = receitaRepository.findAll();
		model.addAttribute("receitas", receitas);
		return "atendimento/receita";
	}

	@GetMapping("/receita/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Receita receita = new Receita();
		if (id != null) {
			Optional<Receita> op = receitaRepository.findById(id);
			if (op.isPresent()) {
				receita = op.get();
			}
		}
		model.addAttribute("atendimentos", atendimentoRepository.findAll());
		model.addAttribute("receita", receita);

		return "atendimento/receitaform";
	}

	@PostMapping("/receita/salvar")
	public String salvar(@Valid Receita receita, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			// bindingResult.getAllErrors().forEach(a -> System.out.print(a));
			model.addAttribute("atendimentos", atendimentoRepository.findAll()); // recupera a lista

			return "atendimento/receitaform";
		}
		receitaRepository.save(receita);
		return "redirect:/receita";
	}

	@GetMapping("/receita/delete")
	public String delete(Long id) {
		receitaRepository.deleteById(id);
		return "redirect:/receita";
	}

}
