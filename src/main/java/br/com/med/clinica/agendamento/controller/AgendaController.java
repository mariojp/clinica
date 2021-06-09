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

import br.com.med.clinica.agendamento.model.Agenda;
import br.com.med.clinica.agendamento.repository.AgendaRepository;

@Controller
public class AgendaController {

	@Autowired
	private AgendaRepository agendaRepository;

	@GetMapping("/agenda")
	public String listagendas(Model model) {
		List<Agenda> agendas = agendaRepository.findAll();
		model.addAttribute("agendas", agendas);
		return "/agendamento/agenda";
	}

	@GetMapping("/agenda/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Agenda agenda = new Agenda();
		if (id != null) {
			Optional<Agenda> op = agendaRepository.findById(id);
			if (op.isPresent()) {
				agenda = op.get();
			}
			
		}
		model.addAttribute("agenda", agenda);

		return "/agendamento/agendaform";
	}

	@PostMapping("/agenda/salvar")
	public String salvar(@Valid Agenda agenda, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(a -> System.out.print(a));
            model.addAttribute("agendas", agendaRepository.findAll());
            return "agendamento/agendaform";
        }
		agendaRepository.save(agenda); 
		return "redirect:/agenda";
	}
	
	

	@GetMapping("/agenda/delete")
	public String delete(Long id) {
		agendaRepository.deleteById(id);
		return "redirect:/agenda";
	}

}