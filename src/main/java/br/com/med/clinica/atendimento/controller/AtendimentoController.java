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

import br.com.med.clinica.administrativo.model.Especialidade;
import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;

@Controller
public class AtendimentoController {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	private static Long sequence = 1l;

	@GetMapping("/atendimento")
	public String listAtendimento(Model model) {
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
		model.addAttribute("atendimento", atendimento);

		return "/atendimento/atendimentoform";
	}

	@PostMapping("/atendimento/salvar")
	public String salvar(Atendimento atendimento) {
		atendimento.setConsultas_oid(sequence++);
		atendimentoRepository.save(atendimento); // esse save tem papel de update tbm
		return "redirect:/atendimento"; // funciona de acordo ao que ele recebe
										// para atendimento novo ou editado.
		// se o id vir vazio, ele cria um novo id e salva o novo dado.
		// se vier com id preenchido, o save vai trabalhar como update.

	}

	@GetMapping("/atendimento/delete")
	public String delete(Long id) {
		atendimentoRepository.deleteById(id);
		return "redirect:/atendimento";
	}

}
