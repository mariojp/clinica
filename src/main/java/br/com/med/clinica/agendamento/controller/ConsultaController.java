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
import br.com.med.clinica.agendamento.repository.ConsultaRepository;

@Controller
public class ConsultaController {

	@Autowired
	private ConsultaRepository consultaRepository;

	@GetMapping("/consulta")
	public String listConvenio(Model model) {
		List<Consulta> consultas =  consultaRepository.findAll();
		model.addAttribute("consultas",consultas);
		return "/agendamento/consulta";
	}
	
	@GetMapping("/consulta/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Consulta consulta = new Consulta();
		if(id != null) {
			Optional<Consulta> op = consultaRepository.findById(id);
			if(op.isPresent()) {
				consulta = op.get();
			}
		}
		model.addAttribute("consulta",consulta);
		
		return "/agendamento/consultaform";
	}
	
	@PostMapping("/consulta/salvar")
	public String salvar(Consulta consulta) {
		consultaRepository.save(consulta);
		return "redirect:/consulta";
	}
	

	@GetMapping("/consulta/delete")
	public String delete(Long id) {
		consultaRepository.deleteById(id);
		return "redirect:/consulta";
	}
}
