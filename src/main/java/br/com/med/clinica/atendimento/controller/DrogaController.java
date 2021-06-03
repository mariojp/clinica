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

import br.com.med.clinica.atendimento.model.Droga;
import br.com.med.clinica.atendimento.repository.DrogaRepository;

/** - Classe responsavel por gerenciar os atributos do "Model" (Droga) que serão encaminhados 
 *    para o "Repository" (DrogaRepository) que implementam o CRUD.
 */	

@Controller
public class DrogaController {

	@Autowired
	private DrogaRepository drogaRepository;
	
	/**
	 * Carrega a lista de Drogas ->
	 * localhost/droga
	 * @param model
	 * @return Lista de drogas.
	 */	
	
	@GetMapping("/droga")
	public String listDroga(Model model) {
		List<Droga> drogas = drogaRepository.findAll();
		model.addAttribute("drogas", drogas);
		return "/atendimento/droga";
	}
	
	/**
	 * Carrega o formulario para adicionar uma nova droga->
	 * localhost/droga/form com id formulario para edição da droga ->
	 * localhost/droga/form?id=N
	 * @param model
	 * @param id
	 * @return Formulario de droga.
	 */	

	@GetMapping("/droga/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Droga droga = new Droga();
		if (id != null) {
			Optional<Droga> op = drogaRepository.findById(id);
			if (op.isPresent()) {
				droga = op.get();
			}
		}
		model.addAttribute("droga", droga);

		return "/atendimento/drogaform";
	}
	
	/**
	 * Método responsavel por salvar e validar uma droga. ->
	 * redirect: 302 redirecione para /droga
	 * 
	 * @param droga
	 * @param bindingResult
	 * @return retorna para o formulario (caso encontre erro).
	 * @return retorna para o metodo que carrega a lista de drogas.
	 */
	
	@PostMapping("/droga/salvar")
	public String salvar(@Valid Droga droga, BindingResult bindingResult) { // resultado das validações
		if (bindingResult.hasErrors()) {
//			System.out.println("Erros");
//			bindingResult.getAllErrors()
//			.forEach(e -> System.out.println(e));

			return "/atendimento/drogaform";// em caso de erro, volte para o form

		}

		drogaRepository.save(droga);
		return "redirect:/droga";
	}
	
	/**
	 * Método responsavel por deletar uma droga. ->
	 * @param id (Id da droga)
	 * @return retorna para a lista de drogas , já atualizada. (/droga)
	 */
	
	@GetMapping("/droga/delete")
	public String delete(Long id) {
		drogaRepository.deleteById(id);
		return "redirect:/droga";
	}

}
