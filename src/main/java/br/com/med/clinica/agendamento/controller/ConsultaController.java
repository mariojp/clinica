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

import br.com.med.clinica.agendamento.model.Consulta;
import br.com.med.clinica.agendamento.model.Horario;
import br.com.med.clinica.agendamento.model.Paciente;
import br.com.med.clinica.agendamento.repository.ConsultaRepository;
import br.com.med.clinica.agendamento.repository.HorarioRepository;
import br.com.med.clinica.agendamento.repository.PacienteRepository;

@Controller
public class ConsultaController {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;

	@GetMapping("/consulta")
	public String listconsultas(Model model) {
		List<Consulta> Consultas = consultaRepository.findAll();
		model.addAttribute("consultas", Consultas);
		return "/agendamento/consulta";
	}

	@GetMapping("/consulta/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Consulta Consulta = new Consulta();
		if (id != null) {
			Optional<Consulta> op = consultaRepository.findById(id);
			if (op.isPresent()) {
				Consulta = op.get();
			}

		}
		model.addAttribute("consulta", Consulta);
		List<Paciente> pacientes = pacienteRepository.findAll();
		model.addAttribute("pacientes", pacientes);
		List<Horario> horarios = horarioRepository.findAll();
		model.addAttribute("horarios", horarios);
		return "/agendamento/consultaform";
	}

	@PostMapping("/consulta/salvar")
	public String salvar(@Valid Consulta Consulta, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(a -> System.out.print(a));
			model.addAttribute("consultas", consultaRepository.findAll());
			return "agendamento/consultaform";
		}
		List<Consulta> consultas = consultaRepository.findAll();
		for (Consulta consulta : consultas){
			if(consulta.getHorarios().getHorarioOid() == Consulta.getHorarios().getHorarioOid() && consulta.getHorarios().getHoraInicio() == Consulta.getData()){
				return "redirect:/consulta/form/?error=Horario indisponivel";
			}
		}
		Horario horario = horarioRepository.findByHorarioOid(Consulta.getHorarios().getHorarioOid());
		System.out.println(Consulta.getPacienteOid());
		Consulta.setHora(horario.getHoraInicio());
		Consulta.setNome(horario.getAgenda().getMedico());
		consultaRepository.save(Consulta);
		return "redirect:/consulta";
	}

	@GetMapping("/consulta/delete")
	public String delete(Long id) {
		consultaRepository.deleteById(id);
		return "redirect:/consulta";
	}
}