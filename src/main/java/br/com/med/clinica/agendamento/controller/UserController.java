package br.com.med.clinica.agendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.agendamento.model.Usuario;
import br.com.med.clinica.agendamento.repository.UsuarioRepository;

@Controller
public class UserController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("usuario")
	public String getUsuarioForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "agendamento/usuarioform";
	}
	@PostMapping("/usuario/salvar")
	public String salvar(Usuario usuario) {
		
		try {
			validaUsuario(usuario);
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		
		return "redirect:/index";
	}

	private void validaUsuario(Usuario usuario) throws Exception {
		validaLogin(usuario.getSenha());
		validaEmail(usuario.getEmail());
		
	}



	private void validaEmail(String email) throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		for(Usuario usuario: usuarios) {
			if(usuario.getEmail().equals(email)) {
				throw new Exception("Email já cadastrado");
			}
		}
	}

	private void validaLogin(String login) throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();
		for(Usuario usuario: usuarios) {
			if(usuario.getNome().equals(login)) {
				throw new Exception("Login já em uso");
			}
		}
	}
	@PostMapping("/login")
	public String login(Usuario usuario) {
		
		try {
			verificaUsuario(usuario);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "redirect:/index";
		}
			
		
		return "redirect:/";
	}

	private void verificaUsuario(Usuario usuario) throws Exception {
		verificaExistencia(usuario);
		verificaSenha(usuario);
	}

	private void verificaSenha(Usuario usuario) throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();
		for(Usuario user : usuarios) {
			if(user.getLogin().equals(user.getLogin())) {
				if(!usuario.getSenha().equals(user.getSenha())) {
					throw new Exception("Senha Inválida !");
				}
			}
		}
	}

	private void verificaExistencia(Usuario usuario) throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
			if(!usuarios.contains(usuario)) {
				throw new Exception("Usuario nao existe! ");
					
			}
		}
	}

