package br.com.med.clinica.atendimento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Exame;
import br.com.med.clinica.atendimento.model.Receita;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;
import br.com.med.clinica.atendimento.repository.ExameRepository;
import br.com.med.clinica.atendimento.repository.ReceitaRepository;

/** - Classe responsavel por gerenciar os atributos do "Model" (Atendimento) que serão encaminhados 
 *    para o "Repository" (AtendimentoRepository) que implementam o CRUD.
 */	

@Controller
public class AtendimentoController {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private ReceitaRepository receitaRepository;
	
	/**
	 * Carrega a lista de atendimentos ->
	 * localhost/atendimento
	 * @param model
	 * @return Lista de atendimentos.
	 */	
	
	@GetMapping("/atendimento")
	public String listAtendimento(Model model) {
		List<Atendimento> atendimentos = atendimentoRepository.findAll();
		model.addAttribute("atendimentos", atendimentos);
		return "/atendimento/atendimento";
	}

	/**
	 * Carrega o formulario sem id formulario para novo atendimento ->
	 * localhost/atendimento/form com id formulario para edição atendimento ->
	 * localhost/atendimento/form?id=N
	 * 
	 * @param model
	 * @param id
	 * @return Formulario de atendimento
	 */
	
	@GetMapping("/atendimento/form")
	public String form(Model model, @Param(value = "id") Long id, HttpServletRequest request) {
		
//	    Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
//	    if (inputFlashMap != null) {
//	    	System.out.println("inputFlashMap: "+ inputFlashMap.get("teste"));
//	    }
//		redirectAttributes.addFlashAttribute("teste", "teste");

		AtendimentoDTO atendimentoDTO = new AtendimentoDTO();
		if (id != null) {
			Optional<Atendimento> op = atendimentoRepository.findById(id);
			if (op.isPresent()) {
				Atendimento atendimento = op.get();
				atendimentoDTO = AtendimentoMapper.toDTO(atendimento);
			}
		}
		model.addAttribute("atendimentoDTO", atendimentoDTO);

		return "/atendimento/atendimentoform";
	}

	/**
	 * Método responsavel por salvar e validar um atendimento. ->
	 * redirect: 302 redirecione para /atendimento
	 * 
	 * @param atendimento
	 * @param bindingResult
	 * @return retorna para o formulario (caso encontre erro).
	 * @return retorna para o metodo que carrega a lista de atendimento.
	 */
	
	@PostMapping("/atendimento/salvar")
	public String salvar(@Valid AtendimentoDTO atendimentoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
//			System.out.println("Erros");
//		bindingResult.getAllErrors()
//		.forEach(e -> System.out.println(e));
			return "/atendimento/atendimentoform";// em caso de erro, volte para o form

		}

		
		Atendimento atendimento = AtendimentoMapper.toAtendimento(atendimentoDTO);
		atendimentoRepository.save(atendimento); // esse save tem papel de update tbm
		
		redirectAttributes.addAttribute("id", atendimento.getOid());
		return "redirect:/atendimento/form"; 

	}
	
	/**
	 * Método responsavel por deletar um atendimento. ->
	 * @param id (Id do atendimento)
	 * @return retorna para a lista de atendimento , já atualizada. (/atendimento)
	 */
	
	@GetMapping("/atendimento/delete")
	public String delete(Long id) {
		atendimentoRepository.deleteById(id);
		return "redirect:/atendimento";
	}

}
