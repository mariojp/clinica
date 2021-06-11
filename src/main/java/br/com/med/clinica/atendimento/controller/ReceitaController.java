package br.com.med.clinica.atendimento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private DrogaRepository drogaRepository;
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	@GetMapping("/atendimento/receita")
	public String listReceitas(Model model,@Param(value = "atendimento" ) Long oidAtendimento) {
		Atendimento atendimento = new Atendimento();
		atendimento.setOid(oidAtendimento);
		List<Receita> receitas =  receitaRepository.findByAtendimento(atendimento);
		
		if(!receitas.isEmpty()) {
			model.addAttribute("receitas",receitas);
			return "atendimento/receitas";
		}else {
			return "atendimento/receitaform";
		}

	}
	
	/**
	 * Carrega o formulario 
	 * sem id fomulario para novo atendimento -> localhost/atendimento/form
	 * com id fomulario para edição atendimento -> localhost/atendimento/form?id=N
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/atendimento/receita/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Atendimento atendimento = new Atendimento();
		
		if(id != null) {
			Optional<Atendimento> op = atendimentoRepository.findById(id);
			if(op.isPresent()) {
				atendimento = op.get();
			}
		}
		ReceitaDTO receitaDTO = new ReceitaDTO();
 
		receitaDTO.setOidAtendimento(id);
		
		//receitaDTO.setOidReceita(id);
		
		
		model.addAttribute("receitaDTO",receitaDTO);
		
		model.addAttribute("drogas",drogaRepository.findAll());
		
		return "atendimento/receitaform";
	}
	
	
	/**
	 * redirect: 302 redirecione para /atendimento
	 * 
	 * @param atendimento
	 * @return
	 */
	@PostMapping("/atendimento/receita/salvar")
	public String salvar(ReceitaDTO receitaDTO, Model model) {

		Receita receita = new Receita();
		receita.setOid(receitaDTO.getOidReceita());
		receita.setTexto(receitaDTO.getTextoReceita());
		Atendimento atendimento = new Atendimento();
		atendimento.setOid(receitaDTO.getOidAtendimento());
		receita.setAtendimento(atendimento);
		receitaRepository.save(receita);
		
		System.out.println(receita.getOid());
		if(receitaDTO.getOidReceita() == null)
			receitaDTO.setOidReceita(receita.getOid());
		
		
		Item item = new Item();
		System.out.println(receitaDTO.getDrogaOid());
		Optional<Droga> droga = drogaRepository.findById(receitaDTO.getDrogaOid());
		item.setDroga(droga.get());
		item.setTexto(receitaDTO.getDrogaTexto());
		item.setReceita(receita);
		itemRepository.save(item);
		 
		
		
		
		model.addAttribute("receitaDTO",receitaDTO);
		
		model.addAttribute("itens",itemRepository.findByReceita(receita));

		model.addAttribute("drogas",drogaRepository.findAll());
		
		//atendimentoRepository.save(atendimento);
		return "atendimento/receitaform";
	}
	

	@GetMapping("/atendimento/receita/delete")
	public String delete(Long id) {
		atendimentoRepository.deleteById(id);
		return "redirect:/atendimento";
	}

	
}
