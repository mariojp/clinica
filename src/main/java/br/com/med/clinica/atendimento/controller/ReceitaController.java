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

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Droga;
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
	public String list(Model model, @Param(value = "atendimento") Long oidAtendimento) {
		Atendimento atendimento = new Atendimento();
		atendimento.setOid(oidAtendimento);
		List<Receita> receitas = receitaRepository.findByAtendimento(atendimento);
		if (!receitas.isEmpty()) {
			model.addAttribute("receitas", receitas);
			return "/atendimento/receita";

		} else {
			return "/atendimento/receita/form";
		}
	}

	@GetMapping("/atendimento/receita/form")
	public String listReceita(Model model) {
		List<Receita> receita = receitaRepository.findAll();
		model.addAttribute("receita", receita);
			return "/atendimento/receita";

	}
	
	@GetMapping("/atendimento/receita/form")
	public String form(Model model, @Param(value = "id") Long id) {
		ReceitaDTO receitaDTO = new ReceitaDTO();
		Atendimento atendimento = new Atendimento();

		if (id != null) {
			Optional<Atendimento> op = atendimentoRepository.findById(id);
			if (op.isPresent()) {
				atendimento = op.get();
			}
		}
		receitaDTO.setOidAtendimento(id);

		model.addAttribute("receitaDTO", receitaDTO);
		model.addAttribute("drogas", drogaRepository.findAll());

		return "atendimento/receitaform";
	}
	
	@PostMapping("/atendimento/receita/salvar")
	public String salvar(@Valid ReceitaDTO receitaDTO, Model model , BindingResult bindingresult) {
		//Validação
		if(bindingresult.hasErrors()) {
			model.addAttribute("receitaDTO", receitaDTO);
			model.addAttribute("drogas", drogaRepository.findAll());
			return "atedimento/receitaform";
		}

		Receita receita = new Receita();
		receita.setOid(receitaDTO.getOidReceita());
		receita.setTexto(receitaDTO.getTextoReceita());
		Atendimento atendimento = new Atendimento();
		atendimento.setOid(receitaDTO.getOidAtendimento());
		receita.setAtendimento(atendimento);
		receitaRepository.save(receita);

		if (receitaDTO.getOidReceita() == null) {
			receitaDTO.setOidReceita(receita.getOid());
		}
		Item item = new Item();
		receitaDTO.getOidDroga();
		Optional<Droga> droga = drogaRepository.findById(receitaDTO.getOidDroga());
		item.setDroga(droga.get());
		item.setTexto(receitaDTO.getDrogaTexto());
		item.setReceita(receita);
		itemRepository.save(item);

		model.addAttribute("receitaDTO", receitaDTO);
		model.addAttribute("itens", itemRepository.findByReceita(receita));
		model.addAttribute("drogas", drogaRepository.findAll());

		return "atendimento/receitaform";

	}

	@GetMapping("/atendimento/receita/delete")
	public String delete(Long id) {
		receitaRepository.deleteById(id);
		return "redirect:/receita";
	}

}
