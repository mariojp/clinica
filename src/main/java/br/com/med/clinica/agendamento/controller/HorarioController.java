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
import br.com.med.clinica.agendamento.model.AgendaDto;
import br.com.med.clinica.agendamento.model.Horario;
import br.com.med.clinica.agendamento.model.HorarioDto;
import br.com.med.clinica.agendamento.model.Medico;
import br.com.med.clinica.agendamento.repository.AgendaRepository;
import br.com.med.clinica.agendamento.repository.HorarioRepository;
@Controller
public class HorarioController {

	@Autowired
	private HorarioRepository horarioRepository;
	@Autowired
	private AgendaRepository agendaRepository;
	private static List<Medico> medicos = new ArrayList<>();
	
	public HorarioController() {

		Medico medico1 = new Medico(1L, "ANTÔNIO PADILHA", "32572553813", "CLINICO GERAL");
		medicos.add(medico1);
		Medico medico2 = new Medico(2L, "MARIA VIEIRA", "51216361134", "CLINICO GERAL");
		medicos.add(medico2);
		Medico medico3 = new Medico(3L, "JORGE SILVA", "81033258644", "FISIOTERAPEUTA");
		medicos.add(medico3);
		Medico medico4 = new Medico(4L, "GABRIELA DUARTE", "62654547655", "FONOAUDIOLOGO");
		medicos.add(medico4);
	}
	
	@GetMapping("/horario")
	public String listConvenio(Model model) {
		List<HorarioDto> horarios = new ArrayList<>();
		List<Horario> horariosRespo =  horarioRepository.findAll();
		List<Agenda> agendasRespo = agendaRepository.findAll();
		for (Horario h : horariosRespo) {
			for (Agenda agenda : agendasRespo) {
				if(h.getAgendaoid() == agenda.getOid()) {
					for (Medico medico : medicos) {
						if(agenda.getMedicooid() == medico.getOid()) {
							
							horarios.add(new HorarioDto(h.getCategoriaId(), h.getDiaSemana(), 
									h.getHora(), new AgendaDto(agenda.getOid(), medico)));
						}
						
					}
				}
			}
		}
		model.addAttribute("horarios",horarios);
		return "/agendamento/horario";
	}
	
	@GetMapping("/horario/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Horario horario = new Horario();
		List<AgendaDto> agendas = new ArrayList<>();
		List<Agenda> agendasRespo = agendaRepository.findAll();
		if(id != null) {
			Optional<Horario> op = horarioRepository.findById(id);
			if(op.isPresent()) {
				horario = op.get();
			}
		}
		
		for (Agenda agenda : agendasRespo) {
			for (Medico medico : medicos) {
				if(agenda.getMedicooid() == medico.getOid()) {
					AgendaDto ag = new AgendaDto(agenda.getOid(), medico);
					agendas.add(ag);
				}
				
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
		return "redirect:/horario";
	}
	

	@GetMapping("/horario/delete")
	public String delete(Long id) {
		horarioRepository.deleteById(id);
		return "redirect:/horario";
	}
	private void validaHorario(Horario horario) throws Exception {
		List<Horario> horarios = horarioRepository.findAll();
		for(Horario horario2 : horarios) {
			if(horario == horario2) {
				throw new Exception("Horario indisponivel ! ");
			}
		}
	}
}
	