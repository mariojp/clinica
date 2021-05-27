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
import br.com.med.clinica.agendamento.repository.ConvenioRepository;

@Controller
public class ConvenioController {

	@Autowired
	private ConvenioRepository convenioRepository;

	@GetMapping("/convenio")
	public String listconvenio(Model model) {
		List<Convenio> Convenios =  convenioRepository.findAll();
		model.addAttribute("convenios",Convenios);
		return "/agendamento/convenio";
	}
	
	@GetMapping("/convenio/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Convenio convenio = new Convenio();
		if(id != null) {
			Optional<Convenio> op = convenioRepository.findById(id);
			if(op.isPresent()) {
				convenio = op.get();
			}
		}
		model.addAttribute("convenio",convenio);
		
		return "/agendamento/convenioform";
	}
	
	@PostMapping("/convenio/salvar")
	public String salvar(@Valid Convenio convenio, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(a -> System.out.print(a));
            model.addAttribute("convenio", convenioRepository.findAll());
            return "agendamento/convenioform";
        }
		convenioRepository.save(convenio);
		return "redirect:/convenio";
	}
	

	@GetMapping("/convenio/delete")
	public String delete(Long id) {
		convenioRepository.deleteById(id);
		return "redirect:/convenio";
	}

}
