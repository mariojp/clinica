package br.com.med.clinica.administrativo.controller;
import br.com.med.clinica.administrativo.model.Usuario;
import br.com.med.clinica.administrativo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public String listUsuario(Model model) {
        List<Usuario> usuarios =  usuarioRepository.findAll();
        model.addAttribute("usuarios",usuarios);
        return "/administrativo/usuariolist";

    }

    @GetMapping("/usuario/form")
    public String form(Model model,@Param(value = "id") Long id) {
        Usuario usuario = new Usuario();
        if(id != null) {
            Optional<Usuario> op = usuarioRepository.findById(id);
            if(op.isPresent()) {
                usuario = op.get();
            }
        }
        model.addAttribute("Usuario",usuarioRepository);

        return "/administrativo/usuarioform";

    }

    @PostMapping("/usuario/salvar")
    public String salvar(@Valid Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/administrativo/usuarioform";
        }
        usuarioRepository.save(usuario);
        return "redirect:/usuario";
    }


    @GetMapping("/usuario/delete")
    public String delete(Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuario";
    }


}
