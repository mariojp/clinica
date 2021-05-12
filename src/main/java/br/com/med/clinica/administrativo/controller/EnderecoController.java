package br.com.med.clinica.administrativo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Endereco;
import br.com.med.clinica.administrativo.repository.EnderecoRepository;

@Controller
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping("/endereco")
	public String listEndereco(Model model) {
		Iterable<Endereco> enderecos =  enderecoRepository.findAll();
		model.addAttribute("enderecos",enderecos);
		return "/administrativo/endereco";
	}
	
	@GetMapping("/endereco/form")
	public String form(Model model,@Param(value = "codigo") Long codigo) {
		Endereco endereco = new Endereco();
		if(codigo != null) {
			Optional<Endereco> op = enderecoRepository.findById(codigo);
			if(op.isPresent()) {
				endereco = op.get();
			}
		}
		model.addAttribute("enderecos",endereco);
		
		return "/administrativo/enderecoform.html";
	}
	
	@PostMapping("/endereco/salvar")
	public String salvar(Endereco endereco) {
		enderecoRepository.save(endereco);
		return "redirect:/endereco";
	}
	

	@GetMapping("/endereco/delete")
	public String delete(Long codigo) {
		enderecoRepository.deleteById(codigo);
		return "redirect:/endereco";
	}
	
}
