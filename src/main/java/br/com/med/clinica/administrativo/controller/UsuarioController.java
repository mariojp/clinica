package br.com.med.clinica.administrativo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.Usuario;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;
import br.com.med.clinica.administrativo.repository.UsuarioRepository;

@Controller()
public class UsuarioController {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("/usuario")
	public String listEspecialidade(Model model) {
		List<Usuario> usuarios =  usuarioRepository.findAll();
		model.addAttribute("usuarios",usuarios);
		return "/administrativo/usuario";
	}
	
	@GetMapping("/usuario/form")
	public String form(Model model,@Param(value = "username") String username) {
		Usuario usuario = new Usuario();
		if(username != null) {
			Optional<Usuario> op = usuarioRepository.findById(username);
			if(op.isPresent()) {
				usuario = op.get();
			}
		}
		model.addAttribute("usuario",usuario);
		
		// TODO forma provisória (tirar dúvida com mario)
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		
		return "/administrativo/usuarioform";
	}
	
	@PostMapping("/usuario/salvar")
	public String salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuario";
	}
	

	@GetMapping("/usuario/delete")
	public String delete(String username) {
		usuarioRepository.deleteById(username);
		return "redirect:/usuario";
	}
}