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

import br.com.med.clinica.atendimento.model.Exame;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;
import br.com.med.clinica.atendimento.repository.ExameRepository;

/** - Classe responsavel por gerenciar os atributos do "Model" (Exame) que serão encaminhados 
 *    para o "Repository" (ExameRepository) que implementam o CRUD.
 */	
@Controller
public class ExameController {

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	/**
	 * Carrega a lista de Exames ->
	 * localhost/exame
	 * @param model
	 * @return Lista de exame.
	 */	
	
	@GetMapping("/exame")
	public String listExame(Model model) {
		List<Exame> exames = exameRepository.findAll();
		model.addAttribute("exame", exames);
		return "/atendimento/exame";
	}
	
	/**
	 * Carrega o formulario para adicionar um novo exame->
	 * localhost/exame/form com id formulario para edição do exame ->
	 * localhost/exame/form?id=N
	 * @param model
	 * @param id
	 * @return Formulario de exames.
	 */	
	
	@GetMapping("/exame/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Exame exame = new Exame();
		if (id != null) {
			Optional<Exame> op = exameRepository.findById(id);
			if (op.isPresent()) {
				exame = op.get();
			}
		}

		model.addAttribute("atendimentos", atendimentoRepository.findAll());
		model.addAttribute("exame", exame);

		return "/atendimento/exameform";
	}
	
	/**
	 * Método responsavel por salvar e validar um exame. ->
	 * redirect: 302 redirecione para /exame
	 * 
	 * @param exame
	 * @param bindingResult
	 * @param model
	 * @return retorna para o formulario (caso encontre erro).
	 * @return retorna para o metodo que carrega a lista de exames.
	 */
	
	@PostMapping("/exame/salvar")
	public String salvar(@Valid Exame exame, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			// bindingResult.getAllErrors().forEach(e -> System.out.println(e));
			model.addAttribute("atendimentos", atendimentoRepository.findAll());
			return "/atendimento/exameform";
		}

		exameRepository.save(exame);
		return "redirect:/exame";
	}
	
	/**
	 * Método responsavel por deletar um exame. ->
	 * @param id (Id do exame)
	 * @return retorna para a lista de exames , já atualizada. (/exame)
	 */
	
	@GetMapping("/exame/delete")
	public String delete(Long id) {
		exameRepository.deleteById(id);
		return "redirect:/exame";
	}
}
