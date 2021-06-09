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

		List<Consulta> consultas = consultaRepository.findAll();
		List<Consulta> consultasFiltradas = new ArrayList<>();
		for (Consulta consulta : consultas) {
			if(!consulta.getCancelada())
				consulta.setCanceladaSTR(consulta.getCancelada()? "SIM":"NÃO");
				consulta.setRetornoSTR(consulta.getRetorno()? "SIM":"NÃO");
				consultasFiltradas.add(consulta);
		}
		model.addAttribute("consultas", consultas);
		return "/agendamento/consulta";
	}

	@GetMapping("/consulta/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Consulta consulta = new Consulta();
		List<Paciente> pacientes = pacienteRepository.findAll();
		if (id != null) {
			Optional<Consulta> op = consultaRepository.findById(id);
			if (op.isPresent()) {
				consulta = op.get();
			}
		}
		model.addAttribute("consulta", consulta);
		model.addAttribute("pacientes", pacientes);

		return "/agendamento/consultaform";
	}

	@PostMapping("/consulta/salvar")
	public String salvar(Consulta consulta) {
		Optional<Paciente> paciente = pacienteRepository.findById(consulta.getPaciente_id());
		if (paciente.isPresent()) {
			try {
				validaConsulta(consulta);
				consulta.setPaciente(paciente.get());
				consultaRepository.save(consulta);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return "redirect:/consulta";
	}

	private void validaConsulta(Consulta consulta) throws Exception {
		validaIdPaciente(consulta.getPaciente_id());
		verificaConflitos(consulta);
	}

	private void verificaConflitos(Consulta consulta) throws Exception {
		List<Consulta> consultas = consultaRepository.findAll();
		for (Consulta con : consultas) {
			if (con.getData().equals(consulta.getData()) && con.getHora().equals(consulta.getHora())) {
				throw new Exception("Data indisponivel !");
			}
		}

	}

	private void validaIdPaciente(Long paciente_id) throws Exception {
		if (paciente_id == null) {
			throw new Exception(" Paciente Inválido !");
		}

	}

	@GetMapping("/consulta/delete")
	public String delete(Long id) {
		consultaRepository.deleteById(id);
		return "redirect:/consulta";
	}
}
