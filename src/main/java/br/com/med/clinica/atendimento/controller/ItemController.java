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

import br.com.med.clinica.atendimento.model.Item;
import br.com.med.clinica.atendimento.repository.DrogaRepository;
import br.com.med.clinica.atendimento.repository.ItemRepository;
import br.com.med.clinica.atendimento.repository.ReceitaRepository;

@Controller
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private DrogaRepository drogaRepository;
	
	@Autowired
	private ReceitaRepository receitaRepository;

	@GetMapping("/item")
	public String listItem(Model model) {
		List<Item> item = itemRepository.findAll();
		model.addAttribute("itens", item);
		return "atendimento/item";
	}

	@GetMapping("/item/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Item item = new Item();
		if (id != null) {
			Optional<Item> op = itemRepository.findById(id);
			if (op.isPresent()) {
				item = op.get();
			}
		}
		model.addAttribute("drogas", drogaRepository.findAll());
		model.addAttribute("receitas", receitaRepository.findAll());
		model.addAttribute("item", item);

		return "atendimento/itemform";
	}

	@PostMapping("/item/salvar")
	public String salvar(@Valid Item item, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			//bindingResult.getAllErrors().forEach(a -> System.out.print(a));
			model.addAttribute("drogas", drogaRepository.findAll()); //recupera a lista
			model.addAttribute("receitas", receitaRepository.findAll());
			
			return "atendimento/itemform";
		}
		itemRepository.save(item);
		return "redirect:/item";
	}

	@GetMapping("/item/delete")
	public String delete(Long id) {
		itemRepository.deleteById(id);
		return "redirect:/item";
	}

}
