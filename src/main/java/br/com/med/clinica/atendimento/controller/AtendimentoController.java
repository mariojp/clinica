package br.com.med.clinica.atendimento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Droga;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;
import br.com.med.clinica.atendimento.repository.DrogaRepository;



@Controller
public class AtendimentoController {

	
	@Autowired
	private DrogaRepository drogaRepository;
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	
	
	@GetMapping("/atendimento")
	public String listAtendimento(Model model) {
		List<Atendimento> atendimentos =  atendimentoRepository.findAll();
		model.addAttribute("atendimentos",atendimentos);
		return "atendimento/atendimento";
	}
	
	/**
	 * Carrega o formulario 
	 * sem id fomulario para novo atendimento -> localhost/atendimento/form
	 * com id fomulario para edição atendimento -> localhost/atendimento/form?id=N
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/atendimento/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Atendimento atendimento = new Atendimento();
		List<String> exames =  new ArrayList<>();
		List<Atendimento> historico = new ArrayList<>();
		if(id != null) {
			Optional<Atendimento> op = atendimentoRepository.findById(id);
			if(op.isPresent()) {
				atendimento = op.get();
				//Lazy
				//exames = examesRepository.findByAtendimento(atendimento)
				//Eagle
				//atendimento.getExames();
				historico =  atendimentoRepository.findAllByPaciente(atendimento.getPaciente());
			}
		}
		model.addAttribute("historico",historico);

		
		model.addAttribute("exames",exames);

		model.addAttribute("atendimento",atendimento);
		
		return "atendimento/atendimentoform";
	}
	
	
	/**
	 * redirect: 302 redirecione para /atendimento
	 * 
	 * @param atendimento
	 * @return
	 */
	@PostMapping("/atendimento/salvar")
	public String salvar(Atendimento atendimento) {
		atendimentoRepository.save(atendimento);
		return "redirect:/atendimento";
	}
	

	@GetMapping("/atendimento/delete")
	public String delete(Long id) {
		atendimentoRepository.deleteById(id);
		return "redirect:/atendimento";
	}

	
}
