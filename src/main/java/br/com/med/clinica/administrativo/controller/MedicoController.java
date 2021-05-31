package br.com.med.clinica.administrativo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Especialidade;
import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.Medico;
import br.com.med.clinica.administrativo.repository.EspecialidadeRepository;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;
import br.com.med.clinica.administrativo.repository.MedicoRepository;

@Controller
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@GetMapping("/medico")
	public String listEndereco(Model model) {
		Iterable<Medico> medicos =  medicoRepository.findAll();
		model.addAttribute("medicos",medicos);
		
		return "/administrativo/medico";
	}
	
	@GetMapping("/medico/form")
	public String form(Model model,@Param(value = "oid") Long oid) {
		Medico medico = new Medico();
		if(oid != null) {
			Optional<Medico> op = medicoRepository.findById(oid);
			if(op.isPresent()) {
				medico = op.get();
			}
		}
		model.addAttribute("medico",medico);
		
		// TODO forma provisória (tirar dúvida com mário)
		List<Especialidade> especialidades = especialidadeRepository.findAll();
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("funcionarios", funcionarios);
		
		return "/administrativo/medicoform.html";
	}
	
	@PostMapping("/medico/salvar")
	public String salvar(Medico medico) {
		medicoRepository.save(medico);
		return "redirect:/medico";
	}
	

	@GetMapping("/medico/delete")
	public String delete(Long oid) {
		medicoRepository.deleteById(oid);
		return "redirect:/medico";
	}
	
}
