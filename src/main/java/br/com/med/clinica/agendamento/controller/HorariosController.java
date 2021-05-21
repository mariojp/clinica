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
public class HorariosController {

	@Autowired
	private HorarioRepository horariosRepository;

	@GetMapping("/horarios")
	public String listHorarios(Model model) {
		List<Horario> horarios = horariosRepository.findAll();
		model.addAttribute("horarios", horarios);
		return "/agendamento/horarios";
	}

	@GetMapping("/horarios/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Horario horario = new Horario();
		if (id != null) {
			Optional<Horario> op = horariosRepository.findById(id);
			if (op.isPresent()) {
				horario = op.get();
			}
		}
		model.addAttribute("horario", horario);

		return "/agendamento/horariosform";
	}

	@PostMapping("/horarios/salvar")
	public String salvar(Horario horarios) {
		horariosRepository.save(horarios);
		return "redirect:/horarios";
	}

	@GetMapping("/horarios/delete")
	public String delete(Long id) {
		horariosRepository.deleteById(id);
		return "redirect:/horarios";
	}

}
