package br.com.med.clinica.administrativo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.med.clinica.administrativo.model.Usuarios;

@Controller
public class UsuariosController {
	@Autowired
	private Usuarios usuarios;
}
