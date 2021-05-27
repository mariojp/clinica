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

import br.com.med.clinica.agendamento.model.Horario;
import br.com.med.clinica.agendamento.repository.HorarioRepository;

@Controller
public class AgendaController {

	@Autowired
	private HorarioRepository horariosRepository;

	@GetMapping("/agenda")
	public String listagendas(Model model) {
		List<Horario> Horarios = horariosRepository.findAll();
		model.addAttribute("horarios", Horarios);
		return "/agendamento/agenda";
	}

	@GetMapping("/agenda/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Horario horario = new Horario();
		if (id != null) {
			Optional<Horario> op = horariosRepository.findById(id);
			if (op.isPresent()) {
				horario = op.get();
			}
			
		}
		model.addAttribute("horario", horario);

		return "/agendamento/agendaform";
	}

	@PostMapping("/agenda/salvar")
	public String salvar(@Valid Horario horario, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(a -> System.out.print(a));
            model.addAttribute("horarios", horariosRepository.findAll());
            return "agendamento/agendaform";
        }
		horariosRepository.save(horario); 
		return "redirect:/agenda";
	}
	
	

	@GetMapping("/agenda/delete")
	public String delete(Long id) {
		horariosRepository.deleteById(id);
		return "redirect:/agenda";
	}

}