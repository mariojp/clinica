package br.com.med.clinica.atendimento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.atendimento.model.Item;
import br.com.med.clinica.atendimento.repository.DrogaRepository;
import br.com.med.clinica.atendimento.repository.ItemRepository;


@Controller
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private DrogaRepository drogaRepository;
	
	//Criação da lista e linkando com o repositório
	
	
	@GetMapping("/item")
	public String listDroga(Model model) {
		List<Item> itens =  itemRepository.findAll();
		model.addAttribute("itens",itens);
		return "/atendimento/item";
	}
	
	// Pegando um dado do repositório
	@GetMapping("/item/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Item item = new Item();
		if(id != null) {
			Optional<Item> op = itemRepository.findById(id);
			if(op.isPresent()) {
				item = op.get();
			}
		}
		model.addAttribute("droga",drogaRepository);
		model.addAttribute("item",item);
		
		return "atendimento/itemform";
	}
	// Salvando algo na lista (Pegando os dados do .html)
	@PostMapping("/item/salvar")
	public String salvar(@Validated Item item, BindingResult bindingResult) {
		itemRepository.save(item);
		return "redirect:/item";
	}
	

	@GetMapping("/item/delete")
	public String delete(Long id) {
		itemRepository.deleteById(id);
		return "redirect:/item";
	}
}
