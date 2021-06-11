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
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public String Get(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "/agendamento/index";
	}

	@GetMapping("/usuario/form")
	public String getUsuarioForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "agendamento/usuarioform";
	}

	@GetMapping("/home")
	public String getHome() {

		return "/agendamento/home";
	}

	@PostMapping("/login")
	public String login(Usuario usuario) {

		try {
			verificaUsuario(usuario);

		} catch (Exception e) {

			e.printStackTrace();
			return "redirect:/usuario";
		}

		return "redirect:/home";
	}

	@PostMapping("/usuario/salvar")
	public String salvar(Usuario usuario) {

		try {
			validaUsuario(usuario);
			usuarioRepository.save(usuario);
		} catch (Exception e) {

			e.printStackTrace();
			return "redirect:/usuario/form";
		}

		return "redirect:/usuario";
	}

	private void validaUsuario(Usuario usuario) throws Exception {
		validaLogin(usuario.getSenha());
		validaEmail(usuario.getEmail());

	}

	private void validaEmail(String email) throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();

		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email)) {
				throw new Exception("Email já cadastrado");
			}
		}
	}

	private void validaLogin(String login) throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(login)) {
				throw new Exception("Login já em uso");
			}
		}
	}

	private void verificaUsuario(Usuario usuario) throws Exception {
		verificaSenha(usuario);
	}

	private void verificaSenha(Usuario usuario) throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario user : usuarios) {
			if (user.getNome().equals(user.getNome())) {
				if (!usuario.getSenha().equals(user.getSenha())) {
					throw new Exception("Usuario ou senha Inválidos !");
				}
			}
		}
	}

	
	
}
