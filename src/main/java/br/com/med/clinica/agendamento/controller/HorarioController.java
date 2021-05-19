package br.com.med.clinica.agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.agendamento.model.Horario;
import br.com.med.clinica.agendamento.repository.HorarioRepository;

public class HorarioController {

	@Autowired
	private HorarioRepository horarioRepository;
	
	@PostMapping("/horario/salvar")
	public String salvar(Horario horario) {
		horarioRepository.save(horario);
		return "redirect:/agenda";
	}
	

	@GetMapping("/horario/delete")
	public String delete(Long id) {
		horarioRepository.deleteById(id);
		return "redirect:/agenda";
	}
}
