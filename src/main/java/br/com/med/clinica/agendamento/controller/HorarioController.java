package br.com.med.clinica.agendamento.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.agendamento.model.Agenda;
import br.com.med.clinica.agendamento.model.Horario;
import br.com.med.clinica.agendamento.repository.AgendaRepository;
import br.com.med.clinica.agendamento.repository.HorarioRepository;
@Controller
public class HorarioController {

	@Autowired
	private static HorarioRepository horarioRepository;
	@Autowired
	private static AgendaRepository agendaRepository;
	
	
	@GetMapping("/horario")
	public String listConvenio(Model model) {
		List<Horario> horarios =  horarioRepository.findAll();
		model.addAttribute("horarios",horarios);
		return "/agendamento/horario";
	}
	
	@GetMapping("/horario/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Horario horario = new Horario();
		List<Agenda> agendas = agendaRepository.findAll();
		if(id != null) {
			Optional<Horario> op = horarioRepository.findById(id);
			if(op.isPresent()) {
				horario = op.get();
			}
		}
		model.addAttribute("horario",horario);
		model.addAttribute("agendas",agendas);
		
		return "/agendamento/horarioform";
	}
	@PostMapping("/horario/salvar")
	public String salvar(Horario horario) throws Exception {
		if(horario.getAgendaoid() != null) {
			if(horario.getAgendaoid().equals(horarioRepository.findAll())) {
				throw new Exception("Horario indisponivel! ");
			} else {
				Optional<Agenda> agenda = agendaRepository.findById(horario.getAgendaoid());
				validaHorario(horario);
				if(agenda.isPresent()) {
					horario.setAgenda(agenda.get());
				}
			}
		}
		horarioRepository.save(horario);
		return "redirect:/agenda";
	}
	

	@GetMapping("/horario/delete")
	public String delete(Long id) {
		horarioRepository.deleteById(id);
		return "redirect:/agenda";
	}
	private static void validaHorario(Horario horario) throws Exception {
		List<Horario> horarios =  horarioRepository.findAll();
		for(Horario horario2 : horarios) {
			if(horario == horario2) {
				throw new Exception("Horario indisponivel ! ");
			}
		}
	}
}
	