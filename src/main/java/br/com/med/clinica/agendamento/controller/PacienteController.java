package br.com.med.clinica.agendamento.controller;

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

import br.com.med.clinica.agendamento.model.Convenio;
import br.com.med.clinica.agendamento.model.Paciente;
import br.com.med.clinica.agendamento.repository.ConvenioRepository;
import br.com.med.clinica.agendamento.repository.PacienteRepository;

@Controller
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private ConvenioRepository convenioRepository;

	@GetMapping("/paciente")
	public String listagendas(Model model) {
		List<Paciente> Pacientes = pacienteRepository.findAll();
		model.addAttribute("pacientes", Pacientes);
		return "/agendamento/paciente";
	}

	@GetMapping("/paciente/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Paciente Paciente = new Paciente();
		if (id != null) {
			Optional<Paciente> op = pacienteRepository.findById(id);
			if (op.isPresent()) {
				Paciente = op.get();
			}

		}
		List<Convenio> convenios = convenioRepository.findAll();
		model.addAttribute("convenios", convenios);
		model.addAttribute("paciente", Paciente);

		return "/agendamento/pacienteform";
	}

	@PostMapping("/paciente/salvar")
	public String salvar(@Valid Paciente Paciente, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(a -> System.out.println(a));
			model.addAttribute("pacientes", pacienteRepository.findAll());
			return "agendamento/pacienteform";
		}
		pacienteRepository.save(Paciente);
		return "redirect:/paciente";
	}

	@GetMapping("/paciente/delete")
	public String delete(Long id) {
		pacienteRepository.deleteById(id);
		return "redirect:/paciente";
	}

}