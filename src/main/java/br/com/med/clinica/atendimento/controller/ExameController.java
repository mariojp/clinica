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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.med.clinica.atendimento.model.Atendimento;
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
	public String form(ExameDTO exameDTO, @Param(value = "id") Long id, Model model) {
		model.addAttribute("atendimentoOID", id);
		return "/atendimento/exameform";
	}
	
	@GetMapping("/exame/update")
	public String update(ExameDTO exameDTO, @Param(value = "id") Long id, Model model) {
		Exame exame = exameRepository.findById(id).get();
		exameDTO = ExameMapper.toDTO(exame);
		model.addAttribute("exameDTO", exameDTO);
		model.addAttribute("atendimentoOID", exame.getAtendimento().getOid());
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
	public String salvar(ExameDTO exameDTO, Model model, @RequestParam("atendimentoOID") Long atendimentoOID,
			RedirectAttributes redirectAttributes) {
		

		Exame exame = ExameMapper.toExame(exameDTO);
		
		//Atendimento atendimento = atendimentoRepository.findById(oid).get();
		exame.setAtendimento(new Atendimento(atendimentoOID));
		exameRepository.save(exame);
		redirectAttributes.addAttribute("id", atendimentoOID);
		return "redirect:/atendimento/form"; // funciona
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
