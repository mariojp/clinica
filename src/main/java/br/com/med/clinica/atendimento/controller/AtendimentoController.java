package br.com.med.clinica.atendimento.controller;

import java.util.ArrayList;
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

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Exame;
import br.com.med.clinica.atendimento.model.Receita;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;
import br.com.med.clinica.atendimento.repository.ExameRepository;
import br.com.med.clinica.atendimento.repository.ReceitaRepository;


@Controller
public class AtendimentoController {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private ReceitaRepository receitaRepository;
	
	//Criação da lista e linkando com o repositório
	
	@GetMapping("/atendimento")
	public String listDroga(Model model) {
		List<Atendimento> atendimentos =  atendimentoRepository.findAll();
		model.addAttribute("atendimentos",atendimentos);
		return "/atendimento/atendimento";
	}
	
	// Pegando um dado do repositório e verificando se ja existe algo naquele id passado
	
	@GetMapping("/atendimento/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Atendimento atendimento = new Atendimento();
		List<Exame> exames = new ArrayList<>();
		List<Receita> receitas = new ArrayList<>();
		List<Atendimento> historico = new ArrayList<>();
		
		if (id != null) {
			Optional<Atendimento> op = atendimentoRepository.findById(id);
			//Se ja existe um id ele pega e atribui
			if (op.isPresent()) {
				
				atendimento = op.get();
				
				exames = exameRepository.findByAtendimento(atendimento);
				
				receitas = receitaRepository.findByAtendimento(atendimento);
				
				// Historico = Tentativa de manipular pelo objeto Paciente
				historico = atendimentoRepository.findAllByPaciente(atendimento.getPaciente());

			}
		}
		//Aqui ele atribui às variaveis ao que foi passado
		model.addAttribute("historico", historico); 
		model.addAttribute("receitas", receitas);
		model.addAttribute("exames", exames);
		model.addAttribute("atendimento", atendimento);

		return "/atendimento/atendimentoform";
	}

	
	// Salvando algo na lista (Pegando os dados do .html)
	
	@PostMapping("/atendimento/salvar")
	public String salvar(@Valid Atendimento atendimento, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("Erros");
			bindingResult.getAllErrors().forEach(e -> System.out.println(e));

			return "/atendimento/atendimentoform";

		}

		atendimento.setConsultas_oid((long) (Math.random() * 10000));
		atendimentoRepository.save(atendimento);
		return "redirect:/atendimento"; 

	}
	

	@GetMapping("/atendimento/delete")
	public String delete(Long id) {
		atendimentoRepository.deleteById(id);
		return "redirect:/atendimento";
	}
}
