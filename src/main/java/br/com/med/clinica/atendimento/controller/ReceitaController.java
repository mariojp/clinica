package br.com.med.clinica.atendimento.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Droga;
import br.com.med.clinica.atendimento.model.Exame;
import br.com.med.clinica.atendimento.model.Item;
import br.com.med.clinica.atendimento.model.Receita;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;
import br.com.med.clinica.atendimento.repository.DrogaRepository;
import br.com.med.clinica.atendimento.repository.ItemRepository;
import br.com.med.clinica.atendimento.repository.ReceitaRepository;

@Controller
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private DrogaRepository drogaRepository;

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/atendimento/receita")
	public String listReceita(Model model) {
		List<Receita> receita = receitaRepository.findAll();
		model.addAttribute("receita", receita);
			return "/atendimento/receita";

	}
	
	
	@GetMapping("/receita/form")
	public String form(ReceitaDTO receitaDTO, @Param(value = "id") Long id,Model model) {
		Receita receita = new  Receita();
		receita.setAtendimento(new Atendimento(id));
		receitaRepository.save(receita);
		receitaDTO = ReceitaMapper.toDTO(receita);
		model.addAttribute("receitaDTO", receitaDTO);
		model.addAttribute("atendimentoOID", id);
		model.addAttribute("drogas", drogaRepository.findAll());
		return "atendimento/receitaform";
	}
	
	@GetMapping("/receita/update")
	public String update(ReceitaDTO receitaDTO, @Param(value = "id") Long id,Model model) {
		Receita receita = receitaRepository.findById(id).get();
		receitaDTO = ReceitaMapper.toDTO(receita);
		model.addAttribute("receitaDTO", receitaDTO);
		model.addAttribute("atendimentoOID", receita.getAtendimento().getOid());
		model.addAttribute("drogas", drogaRepository.findAll());
		return "atendimento/receitaform";
	}
	
	@PostMapping("/atendimento/receita/salvar")
	public String salvar(ReceitaDTO receitaDTO, Model model, @RequestParam("atendimentoOID") Long atendimentoOID,
			RedirectAttributes redirectAttributes) {
	
		
		Receita receita = ReceitaMapper.toReceita(receitaDTO);
		receita.setAtendimento(new Atendimento(atendimentoOID));
		receitaRepository.save(receita);
		redirectAttributes.addAttribute("id", atendimentoOID);		
		return "redirect:/atendimento/form"; // funciona

		
//		model.addAttribute("receitaDTO", receitaDTO);
//		model.addAttribute("drogas", drogaRepository.findAll());
//		return "atendimento/receitaform";

	}

	
	@PostMapping("/atendimento/receita/adicionar")
	public String adicionar(ReceitaDTO receitaDTO, Model model,
			@RequestParam("atendimentoOID") Long atendimentoOID,
			@RequestParam("drogaOID") Long drogaOID,
			@RequestParam("drogaTexto") String drogaTexto,
			RedirectAttributes redirectAttributes ) {
	
		Receita receita = ReceitaMapper.toReceita(receitaDTO);
		receita.setAtendimento(new Atendimento(atendimentoOID));

		Item item = new Item();
		item.setDroga(new Droga(drogaOID));
		item.setReceita(new Receita(receitaDTO.getOid()));
		item.setTexto(drogaTexto);
		itemRepository.save(item);
		
		
		redirectAttributes.addAttribute("id", receita.getOid());	
		return "redirect:/receita/update"; // funciona

		
//		model.addAttribute("receitaDTO", receitaDTO);
//		model.addAttribute("drogas", drogaRepository.findAll());
//		return "atendimento/receitaform";

	}
	
	
	@GetMapping("/atendimento/receita/delete")
	public String delete(Long id) {
		receitaRepository.deleteById(id);
		return "redirect:/receita";
	}

}
