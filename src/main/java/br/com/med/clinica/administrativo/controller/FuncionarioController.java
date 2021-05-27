package br.com.med.clinica.administrativo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Endereco;
import br.com.med.clinica.administrativo.model.Especialidade;
import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.FuncionarioEndereco;
import br.com.med.clinica.administrativo.model.Medico;
import br.com.med.clinica.administrativo.repository.EnderecoRepository;
import br.com.med.clinica.administrativo.repository.EspecialidadeRepository;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;
import br.com.med.clinica.administrativo.repository.MedicoRepository;

@Controller()
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@GetMapping("/funcionario")
	public String listFuncionario(Model model) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		return "/administrativo/funcionario";
	}

	@GetMapping("/funcionario/form")
	public String form(Model model, @Param(value = "oid") Long oid) {
		// TODO resolver problema ao editar um funcionário
//		Funcionario funcionario = new Funcionario();
//		if(oid != null) {
//			Optional<Funcionario> op = funcionarioRepository.findById(oid);
//			if(op.isPresent()) {
//				funcionario = op.get();
//			}
//		}

		FuncionarioEndereco funcionario = new FuncionarioEndereco();

		model.addAttribute("funcionario", funcionario);

		return "/administrativo/funcionarioform";
	}

	@PostMapping("/funcionario/salvar")
	public String salvar(FuncionarioEndereco obj) {

		Funcionario funcionario = new Funcionario();
		Medico medico = new Medico();
		Endereco endereco = new Endereco();
		Especialidade especialidade = new Especialidade();

		// setando dados no endereço
		endereco.setBairro(obj.getEndereco_bairro());
		endereco.setCep(obj.getEndereco_cep());
		endereco.setCidade(obj.getEndereco_cidade());
		endereco.setComplemento(obj.getEndereco_complemento());
		endereco.setEstado(obj.getEndereco_estado());
		endereco.setNomeEndereco(obj.getEndereco_nome());
		endereco.setNumero(obj.getEndereco_numero());
		endereco.setOid(obj.getEndereco_oid());

		endereco = enderecoRepository.save(endereco);

		// Setando dados na especialidade
		especialidade.setOid(obj.getEspecialidade_oid());
		especialidade.setNome(obj.getEspecialidade_nome());

		especialidade = especialidadeRepository.save(especialidade);

		// setando dados no funcionário
		funcionario.setNome(obj.getFuncionario_nome());
		funcionario.setCelular(obj.getFuncionario_celular());
		funcionario.setCpf(obj.getFuncionario_cpf());
		funcionario.setRg(obj.getFuncionario_rg());
		funcionario.setCelular(obj.getFuncionario_celular());
		funcionario.setOid(obj.getFuncionario_oid());
		funcionario.setTelefone(obj.getFuncionario_telefone());
		funcionario.setOrgaoEmissor(obj.getFuncionario_orgaoEmissor());
		funcionario.setEndereco(endereco);

		funcionario = funcionarioRepository.save(funcionario);

		// setando dados no Médico
		medico.setOid(obj.getMedico_oid());
		medico.setConcelho(obj.getMedico_concelho());
		medico.setEspecialidade(especialidade);
		medico.setFuncionario(funcionario);

		medico = medicoRepository.save(medico);

		return "redirect:/funcionario";
	}

	@GetMapping("/funcionario/delete")
	public String delete(Long oid) {
		funcionarioRepository.deleteById(oid);
		return "redirect:/funcionario";
	}
}