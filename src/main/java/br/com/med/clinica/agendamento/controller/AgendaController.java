package br.com.med.clinica.agendamento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.agendamento.model.Agenda;
import br.com.med.clinica.agendamento.model.Consulta;
import br.com.med.clinica.agendamento.model.Horario;
import br.com.med.clinica.agendamento.model.Medico;
import br.com.med.clinica.agendamento.repository.AgendaRepository;
import br.com.med.clinica.agendamento.repository.ConsultaRepository;
import br.com.med.clinica.agendamento.repository.HorarioRepository;
import br.com.med.clinica.agendamento.repository.MedicoRepository;
@Controller
public class AgendaController {

	@Autowired
	private AgendaRepository agendaRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	
	public AgendaController() {
		List<Medico> lista = new ArrayList<>();
		Medico medico1 = new Medico(1L, "ANTÔNIO PADILHA", "32572553813", "CLINICO GERAL");
		lista.add(medico1);
		Medico medico2 = new Medico(2L, "MARIA VIEIRA", "51216361134", "CLINICO GERAL");
		lista.add(medico2);
		Medico medico3 = new Medico(3L, "JORGE SILVA", "81033258644", "FISIOTERAPEUTA");
		lista.add(medico3);
		Medico medico4 = new Medico(4L, "GABRIELA DUARTE", "62654547655", "FONOAUDIOLOGO");
		lista.add(medico4);
		
		for (Medico medico : lista) {
			medicoRepository.save(medico);
		}
		
	}

	@GetMapping("/agenda")
	public String listCompromissos(Model model) {
		List<Agenda> agendas =  agendaRepository.findAll();
		model.addAttribute("agendas",agendas);
		return "/agendamento/agenda";
	}
	
	@GetMapping("/agenda/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Agenda agenda = new Agenda();
		List<Medico> medicos = medicoRepository.findAll();
		if(id != null) {
			Optional<Agenda> op = agendaRepository.findById(id);
			if(op.isPresent()) {
				agenda = op.get();
			}
		}
		model.addAttribute("agenda",agenda);
		model.addAttribute("medicos", medicos);
		
		return "/agendamento/agendaform";
	}
	
	@PostMapping("/agenda/salvar")
	public String salvar(Agenda agenda) {
		if(agenda.getMedicooid() != null) {
			Optional<Medico> medico = medicoRepository.findById(agenda.getMedicooid());
			agenda.setMedico(medico.get());
		}
		agendaRepository.save(agenda);
		return "redirect:/agenda";
	}
	

	@GetMapping("/agenda/delete")
	public String delete(Long id) {
		agendaRepository.deleteById(id);
		return "redirect:/agenda";
	}
}
