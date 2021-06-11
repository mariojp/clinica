package br.com.med.clinica.agendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.agendamento.model.Horario;
import br.com.med.clinica.agendamento.repository.AgendaRepository;
import br.com.med.clinica.agendamento.repository.HorarioRepository;

@Controller
public class HorariosController {

	@Autowired
	private HorarioRepository horariosRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;

	@GetMapping("/horarios")
	public String listHorarios(Model model, Long id) {
		List<Horario> horarios = horariosRepository.findByAgendaAgendaOid(id);
		model.addAttribute("horarios", horarios);
		model.addAttribute("agendaOid", id);
		return "/agendamento/horarios";
	}
	

	@GetMapping("/horarios/form")
	public String form(Model model, Long id) {
		Horario horario = new Horario();
		model.addAttribute("AgendaOid", id);
		model.addAttribute("horario", horario);

		return "/agendamento/horariosform";
	}

	@PostMapping("/horarios/salvar")
	public String salvar(Horario horario, Long id) {
		horario.setAgenda(agendaRepository.findByAgendaOid(id).get(0));
		horariosRepository.save(horario);
		return "redirect:/horarios?id="+id;
	}

	@GetMapping("/horarios/delete")
	public String delete(Long id) {
		horariosRepository.deleteById(id);
		return "redirect:/horarios";
	}

}
