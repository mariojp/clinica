package br.com.med.clinica.administrativo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Convenio;
import br.com.med.clinica.administrativo.repository.ConvenioRepository;

@Controller
public class ConvenioController {

	@Autowired
	private ConvenioRepository convenioRepository;

	@GetMapping("/convenio")
	public String listConvenio(Model model) {
		List<Convenio> convenios =  convenioRepository.findAll();
		
		model.addAttribute("convenios",convenios);
		return "/administrativo/convenio";
	}
	
	@GetMapping("/convenio/form")
	public String form(Model model,@Param(value = "codigo") Long codigo) {
		Convenio convenio = new Convenio();
		if(codigo != null) {
			Optional<Convenio> op = convenioRepository.findById(codigo);
			if(op.isPresent()) {
				convenio = op.get();
			}
		}
		model.addAttribute("convenio",convenio);
		
		return "/administrativo/convenioform.html";
	}
	
	@PostMapping("/convenio/salvar")
	public String salvar(Convenio convenio) {
		convenioRepository.save(convenio);
		return "redirect:/convenio";
	}
	
	@GetMapping("/convenio/delete")
	public String delete(Long codigo) {
		convenioRepository.deleteById(codigo);
		return "redirect:/convenio";
	}
}