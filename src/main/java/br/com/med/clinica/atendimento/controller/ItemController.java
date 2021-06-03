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

/** - Classe responsavel por gerenciar os atributos do "Model" (Item) que serão encaminhados 
 *    para o "Repository" (ItemRepository) que implementam o CRUD.
 */

@Controller
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private DrogaRepository drogaRepository;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	/**
	 * Carrega a lista de itens ->
	 * localhost/item
	 * @param model
	 * @return Lista de itens.
	 */	
	
	@GetMapping("/item")
	public String listItem(Model model) {
		List<Item> item = itemRepository.findAll();
		model.addAttribute("itens", item);
		return "atendimento/item";
	}

	/**
	 * Carrega o formulario para adicionar um novo item->
	 * localhost/item/form com id formulario para edição do item ->
	 * localhost/item/form?id=N
	 * @param model
	 * @param id
	 * @return Formulario de item.
	 */	

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
	
	/**
	 * Método responsavel por salvar e validar um item. ->
	 * redirect: 302 redirecione para /item
	 * 
	 * @param item
	 * @param bindingResult
	 * @param model
	 * @return retorna para o formulario (caso encontre erro).
	 * @return retorna para o metodo que carrega a lista de itens.
	 */
	
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
	
	/**
	 * Método responsavel por deletar um item. ->
	 * @param id (Id do item)
	 * @return retorna para a lista de itens , já atualizada. (/exame)
	 */

	@GetMapping("/item/delete")
	public String delete(Long id) {
		itemRepository.deleteById(id);
		return "redirect:/item";
	}

}
