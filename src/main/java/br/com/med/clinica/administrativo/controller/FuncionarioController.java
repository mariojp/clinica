package br.com.med.clinica.administrativo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Endereco;
import br.com.med.clinica.administrativo.model.EnderecoFuncionario;
import br.com.med.clinica.administrativo.model.Funcionario;
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
	public String form(Model model) {
		EnderecoFuncionario entity = new EnderecoFuncionario(null, "", "", "", "", "", "", null, "", "", "", "", "", "",
				"");
		model.addAttribute("entity", entity);
		return "/administrativo/funcionarioform";
	}

	@GetMapping("/funcionario/form/update")
	public String formUpdate(Model model, Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		Endereco endereco = enderecoRepository.findById(funcionarioRepository.findById(id).get().getEndereco().getOid())
				.get();
		EnderecoFuncionario entity = new EnderecoFuncionario(funcionario.getOid(), funcionario.getNome(),
				funcionario.getRg(), funcionario.getOrgao(), funcionario.getCpf(), funcionario.getTelefone(),
				funcionario.getCelular(), endereco.getOid(), endereco.getLogradouro(), endereco.getNumero(),
				endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getCep(),
				endereco.getEstado());

		model.addAttribute("entity", entity);
		return "/administrativo/funcionarioupdate";
	}

	@PostMapping("/funcionario/update")
	public String update(@Valid EnderecoFuncionario entity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/administrativo/funcionarioupdate";
		}

		Funcionario funcionario = funcionarioRepository.getOne(entity.getFuncionario_oid());

		Endereco endereco = enderecoRepository.getOne(funcionario.getEndereco().getOid());

		endereco.setOid(endereco.getOid());
		endereco.setLogradouro(entity.getEndereco_logradouro());
		endereco.setBairro(entity.getEndereco_bairro());
		endereco.setCep(entity.getEndereco_cep());
		endereco.setCidade(entity.getEndereco_cidade());
		endereco.setComplemento(entity.getEndereco_complemento());
		endereco.setNumero(entity.getEndereco_numero());
		endereco.setEstado(entity.getEndereco_estado());

		enderecoRepository.save(endereco);

		funcionario.setOid(funcionario.getOid());
		funcionario.setCelular(entity.getFuncionario_celular());
		funcionario.setCpf(entity.getFuncionario_cpf());
		funcionario.setNome(entity.getFuncionario_nome());
		funcionario.setOrgao(entity.getFuncionario_orgao());
		funcionario.setRg(entity.getFuncionario_rg());
		funcionario.setTelefone(entity.getFuncionario_telefone());
		funcionario.setEndereco(endereco);

		funcionarioRepository.save(funcionario);

		return "redirect:/funcionario";
	}

	@PostMapping("/funcionario/salvar")
	public String salvar(@Valid EnderecoFuncionario entity, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/administrativo/funcionarioform";
		}

		Endereco endereco = new Endereco();
		Funcionario funcionario = new Funcionario();

		endereco.setOid(entity.getEndereco_oid());
		endereco.setLogradouro(entity.getEndereco_logradouro());
		endereco.setBairro(entity.getEndereco_bairro());
		endereco.setCep(entity.getEndereco_cep());
		endereco.setCidade(entity.getEndereco_cidade());
		endereco.setComplemento(entity.getEndereco_complemento());
		endereco.setNumero(entity.getEndereco_numero());
		endereco.setOid(entity.getEndereco_oid());
		endereco.setEstado(entity.getEndereco_estado());

		endereco = enderecoRepository.save(endereco);

		funcionario.setOid(entity.getEndereco_oid());
		funcionario.setCelular(entity.getFuncionario_celular());
		funcionario.setCpf(entity.getFuncionario_cpf());
		funcionario.setNome(entity.getFuncionario_nome());
		funcionario.setOid(entity.getFuncionario_oid());
		funcionario.setOrgao(entity.getFuncionario_orgao());
		funcionario.setRg(entity.getFuncionario_rg());
		funcionario.setTelefone(entity.getFuncionario_telefone());
		funcionario.setEndereco(endereco);

		funcionario = funcionarioRepository.save(funcionario);

		return "redirect:/funcionario";

	}

	@GetMapping("/funcionario/delete")
	public String delete(Long id) {
		funcionarioRepository.deleteById(id);
		return "redirect:/funcionario";
	}

}
