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
		List<Receita> receitas = receitaRepository.findAll();
				if (!receitas.isEmpty()) {
			model.addAttribute("receitas", receitas);
			return "/atendimento/receita";

		} else {
			return "/atendimento/receita/form";
		}
	}

	@GetMapping("/atendimento/receita/form")
	public String form(Model model, @Param(value = "id") Long id) {
		ReceitaDTO receitaDTO = new ReceitaDTO();
		Atendimento atendimento = new Atendimento();
		Receita receita = new Receita();
		List<Receita> receitas = new ArrayList<>();

		if (id != null) {
			Optional<Receita> op = receitaRepository.findById(id);
			if (op.isPresent()) {
				
				receita = op.get();
				
				receitas = receitaRepository.findByAtendimento(atendimento);
				
			}
		}
		model.addAttribute("atendimentos", atendimento);
		
		model.addAttribute("receitas", receitas);
		
		receitaDTO.setOidAtendimento(id);
													
		model.addAttribute("receitaDTO", receitaDTO);
		
		model.addAttribute("drogas", drogaRepository.findAll());

		return "atendimento/receitaform";
	}

	@PostMapping("/atendimento/receita/salvar")
	public String salvar(ReceitaDTO receitaDTO, Model model) {

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
