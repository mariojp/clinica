package br.com.med.clinica.agendamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.med.clinica.agendamento.model.Usuario;

@Controller
public class IndexController {

	@GetMapping("")
	public String Get(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "/agendamento/index";
	}
	
	@GetMapping("/home")
	public String getHome() {
		
		return "/agendamento/home";
	}
}
