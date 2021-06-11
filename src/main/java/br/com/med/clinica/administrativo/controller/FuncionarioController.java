package br.com.med.clinica.administrativo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.FuncionarioDTO;
import br.com.med.clinica.administrativo.model.FuncionarioMapper;
import br.com.med.clinica.administrativo.repository.EnderecoRepository;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping("/funcionario")
	public String listFuncionario(Model model, HttpServletRequest req) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		req.getSession().setAttribute("funcionarios", funcionarios);
		return "/administrativo/funcionariolist";

	}

	@GetMapping("/funcionario/form")
	public String form(Model model, Long id) {
//		FuncionarioDTO entity = new FuncionarioDTO(null, "", "", "", "", "", "", null, "", "", "", "", "", "",
//				"");
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		
		if(id != null) {
			Optional<Funcionario> op = funcionarioRepository.findById(id);
			if(op.isPresent()) {
				Funcionario funcionario = op.get();
				funcionarioDTO = FuncionarioMapper.toDTO(funcionario);
			}
		}		
		model.addAttribute("funcionarioDTO", funcionarioDTO);
		return "/administrativo/funcionarioform";
	}
//
//	@GetMapping("/funcionario/form/update")
//	public String formUpdate(Model model, Long id) {
//		//FIX: é bom testar se existe
//		Funcionario funcionario = funcionarioRepository.findById(id).get();
//		
//		FuncionarioDTO dto =  FuncionarioMapper.toDTO(funcionario);
//		
////		Endereco endereco = enderecoRepository.findById(funcionarioRepository.findById(id).get().getEndereco().getOid())
////				.get();
//		
////		FuncionarioDTO entity = new FuncionarioDTO(funcionario.getOid(), funcionario.getNome(),
////				funcionario.getRg(), funcionario.getOrgao(), funcionario.getCpf(), funcionario.getTelefone(),
////				funcionario.getCelular(), endereco.getOid(), endereco.getLogradouro(), endereco.getNumero(),
////				endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getCep(),
////				endereco.getEstado());
//		
//		
//		model.addAttribute("funcionarioDTO", dto);
//		return "/administrativo/funcionarioupdate";
//	}


	@PostMapping("/funcionario/salvar")
	public String salvar(@Valid FuncionarioDTO funcionarioDTO, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/administrativo/funcionarioform";
		}
		
		Funcionario funcionario = FuncionarioMapper.toEntity(funcionarioDTO);

//		Endereco endereco = new Endereco();
//		Funcionario funcionario = new Funcionario();
//
//		endereco.setOid(funcionarioDTO.getEndereco_oid());
//		endereco.setLogradouro(funcionarioDTO.getEndereco_logradouro());
//		endereco.setBairro(funcionarioDTO.getEndereco_bairro());
//		endereco.setCep(funcionarioDTO.getEndereco_cep());
//		endereco.setCidade(funcionarioDTO.getEndereco_cidade());
//		endereco.setComplemento(funcionarioDTO.getEndereco_complemento());
//		endereco.setNumero(funcionarioDTO.getEndereco_numero());
//		endereco.setOid(funcionarioDTO.getEndereco_oid());
//		endereco.setEstado(funcionarioDTO.getEndereco_estado());
//
//		endereco = enderecoRepository.save(endereco);
//
//		funcionario.setOid(funcionarioDTO.getEndereco_oid());
//		funcionario.setCelular(funcionarioDTO.getFuncionario_celular());
//		funcionario.setCpf(funcionarioDTO.getFuncionario_cpf());
//		funcionario.setNome(funcionarioDTO.getFuncionario_nome());
//		funcionario.setOid(funcionarioDTO.getFuncionario_oid());
//		funcionario.setOrgao(funcionarioDTO.getFuncionario_orgao());
//		funcionario.setRg(funcionarioDTO.getFuncionario_rg());
//		funcionario.setTelefone(funcionarioDTO.getFuncionario_telefone());
//		funcionario.setEndereco(endereco);

		funcionario = funcionarioRepository.save(funcionario);

		return "redirect:/funcionario";

	}

	@GetMapping("/funcionario/delete")
	public String delete(Long id) {
		funcionarioRepository.deleteById(id);
		return "redirect:/funcionario";
	}

}
