package br.com.med.clinica.agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.agendamento.model.Consulta;
import br.com.med.clinica.agendamento.model.Paciente;
import br.com.med.clinica.agendamento.repository.ConsultaRepository;
import br.com.med.clinica.agendamento.repository.PacienteRepository;

@Controller
public class ConsultaController {

	@Autowired
	private ConsultaRepository consultaRepository;
	@Autowired
	private PacienteRepository pacienteRepository;

	@GetMapping("/consulta")
	public String listConvenio(Model model) {
		List<Consulta> consultas =  consultaRepository.findAll();
		List<Consulta> consultasFiltradas;
		for (Consulta consulta : consultas) {
			if(!consulta.getCancelada())
				consultasFiltradas.add(consulta);
		}
		model.addAttribute("consultas",consultasFiltradas);
		return "/agendamento/consulta";
	}
	
	@GetMapping("/consulta/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Consulta consulta = new Consulta();
		List<Paciente> pacientes = pacienteRepository.findAll();
		if(id != null) {
			Optional<Consulta> op = consultaRepository.findById(id);
			if(op.isPresent()) {
				consulta = op.get();
			}
		}
		model.addAttribute("consulta",consulta);
		model.addAttribute("pacientes",pacientes);
		
		return "/agendamento/consultaform";
	}
	
	@PostMapping("/consulta/salvar")
	public String salvar(Consulta consulta) {
		if(consulta.getPaciente_id() != null) {
			Optional<Paciente> paciente = pacienteRepository.findById(consulta.getPaciente_id());
			if(paciente.isPresent()) {
				consulta.setPaciente(paciente.get());
			}
			consultaRepository.save(consulta);
		}
		return "redirect:/consulta";
	}
	

	@GetMapping("/consulta/delete")
	public String delete(Long id) {
		consultaRepository.deleteById(id);
		return "redirect:/consulta";
	}
}
