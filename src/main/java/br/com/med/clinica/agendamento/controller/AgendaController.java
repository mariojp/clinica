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
import br.com.med.clinica.agendamento.model.Medico;
import br.com.med.clinica.agendamento.repository.AgendaRepository;

@Controller
public class AgendaController {

	@Autowired
	private AgendaRepository agendaRepository;
	private List<Medico> medicos = new ArrayList<>();
	
	public AgendaController() {
		
		Medico medico1 = new Medico(1L, "ANTÔNIO PADILHA", "32572553813", "CLINICO GERAL");
		medicos.add(medico1);
		Medico medico2 = new Medico(2L, "MARIA VIEIRA", "51216361134", "CLINICO GERAL");
		medicos.add(medico2);
		Medico medico3 = new Medico(3L, "JORGE SILVA", "81033258644", "FISIOTERAPEUTA");
		medicos.add(medico3);
		Medico medico4 = new Medico(4L, "GABRIELA DUARTE", "62654547655", "FONOAUDIOLOGO");
		medicos.add(medico4);
		
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
		Medico medico = new Medico();;
		
		if(id != null) {
			Optional<Agenda> op = agendaRepository.findById(id);
			if(op.isPresent()) {
				agenda = op.get();
			}
			for(Medico medicoItem: medicos) {
				if(agenda.getMedicooid() == medicoItem.getOid()) {
					medico = medicoItem;
				}
			}
			model.addAttribute("medicos", medico);
		}else {
			
			model.addAttribute("medicos", medicos);
		}
		model.addAttribute("agenda",agenda);
		
		return "/agendamento/agendaform";
	}
	
	@PostMapping("/agenda/salvar")
	public String salvar(Agenda agenda) {
		agendaRepository.save(agenda);
		return "redirect:/agenda";
	}
	

	@GetMapping("/agenda/delete")
	public String delete(Long id) {
		agendaRepository.deleteById(id);
		return "redirect:/agenda";
	}
}
