package br.com.med.clinica.agendamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("")
	public String Get() {
		return "/agendamento/index";
	}
}
