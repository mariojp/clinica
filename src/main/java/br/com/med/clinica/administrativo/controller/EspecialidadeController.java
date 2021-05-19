package br.com.med.clinica.administrativo.controller;

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

import br.com.med.clinica.administrativo.model.Especialidade;
import br.com.med.clinica.administrativo.repository.EspecialidadeRepository;

@Controller()
public class EspecialidadeController {
	
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@GetMapping("/especialidade")
	public String listEspecialidade(Model model) {
		List<Especialidade> especialidades =  especialidadeRepository.findAll();
		model.addAttribute("especialidades",especialidades);
		return "administrativo/especialidade";
	}
	
	@GetMapping("/especialidade/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Especialidade especialidade = new Especialidade();
		if(id != null) {
			Optional<Especialidade> op = especialidadeRepository.findById(id);
			if(op.isPresent()) {
				especialidade = op.get();
			}
		}
		model.addAttribute("especialidade",especialidade);
		
		return "administrativo/especialidadeform";
	}
	
	@PostMapping("/especialidade/salvar")
	public String salvar(@Valid Especialidade especialidade, BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			
			return "administrativo/especialidadeform";
		}
		
		especialidadeRepository.save(especialidade);
		return "redirect:/especialidade";
	}
	

	@GetMapping("/especialidade/delete")
	public String delete(Long id) {
		especialidadeRepository.deleteById(id);
		return "redirect:/especialidade";
	}

	
	
	
}
