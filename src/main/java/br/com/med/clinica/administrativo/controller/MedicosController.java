package br.com.med.clinica.administrativo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.med.clinica.administrativo.repository.MedicoRepository;

@Controller
public class MedicosController {
	
	@Autowired
	private MedicoRepository medicoRepository;
}