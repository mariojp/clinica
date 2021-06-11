package br.com.med.clinica.administrativo.controller;

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

import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.Usuario;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;
import br.com.med.clinica.administrativo.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("/usuario")
	public String listUsuario(Model model) {
		List<Usuario> usuarios = usuarioRepository.findAll();
		model.addAttribute("usuarios", usuarios);
		return "/administrativo/usuario";

	}

	@GetMapping("/usuario/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Usuario usuario = new Usuario();
		if (id != null) {
			Optional<Usuario> op = usuarioRepository.findById(id);
			if (op.isPresent()) {
				usuario = op.get();
			}
		}
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("usuario", usuario);

		return "/administrativo/usuarioform";
	}

	@PostMapping("/usuario/salvar")
	public String salvar(@Valid Usuario entity, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/administrativo/usuarioform";
		}
		Usuario usuario = new Usuario();
		usuario.setUsername(entity.getUsername());
		usuario.setPassword(entity.getPassword());
		usuario.setEmail(entity.getEmail());
		usuario.setOid(entity.getOid());
		usuario.setFuncionario(funcionarioRepository.findById(entity.getFuncionario().getOid()).get());
		usuarioRepository.save(usuario);
		return "redirect:/usuario";
	}

	@GetMapping("/usuario/delete")
	public String delete(Long id) {
		usuarioRepository.deleteById(id);
		return "redirect:/usuario";
	}

}
