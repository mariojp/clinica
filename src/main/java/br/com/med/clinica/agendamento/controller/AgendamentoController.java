package br.com.med.clinica.agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.agendamento.model.Horario;
import br.com.med.clinica.agendamento.repository.HorarioRepository;

@Controller
public class AgendamentoController {

	@Autowired
	private HorarioRepository horariosRepository;

	@GetMapping("/agendamento")
	public String listAgendamentos(Model model) {
		List<Horario> Horarios = horariosRepository.findAll();
		model.addAttribute("horarios", Horarios);
		return "/agendamento/agendamento";
	}

	@GetMapping("/agendamento/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Horario horario = new Horario();
		if (id != null) {
			Optional<Horario> op = horariosRepository.findById(id);
			if (op.isPresent()) {
				horario = op.get();
			}
			
		}
		model.addAttribute("horario", horario);

		return "/agendamento/agendamentoform";
	}

	@PostMapping("/agendamento/salvar")
	public String salvar(Horario horario) {
		horariosRepository.save(horario);
		return "redirect:/agendamento";
	}

	@GetMapping("/agendamento/delete")
	public String delete(Long id) {
		horariosRepository.deleteById(id);
		return "redirect:/agendamento";
	}

}