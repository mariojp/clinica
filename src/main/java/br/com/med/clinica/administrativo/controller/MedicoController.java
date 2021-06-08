package br.com.med.clinica.administrativo.controller;

import java.util.ArrayList;
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

import br.com.med.clinica.administrativo.model.Endereco;
import br.com.med.clinica.administrativo.model.EnderecoFuncionarioMedicoEspecialidade;
import br.com.med.clinica.administrativo.model.Especialidade;
import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.Medico;
import br.com.med.clinica.administrativo.repository.EnderecoRepository;
import br.com.med.clinica.administrativo.repository.EspecialidadeRepository;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;
import br.com.med.clinica.administrativo.repository.MedicoRepository;

@Controller
public class MedicoController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@GetMapping("/medico")
	public String listMedico(Model model) {
		List<Medico> medicos = medicoRepository.findAll();
		model.addAttribute("medicos", medicos);
		return "/administrativo/medico";
	}

	@GetMapping("/medico/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Medico medico = new Medico();
		if (id != null) {
			Optional<Medico> op = medicoRepository.findById(id);
			if (op.isPresent()) {
				medico = op.get();
			}
		}
		EnderecoFuncionarioMedicoEspecialidade obj = new EnderecoFuncionarioMedicoEspecialidade(null, "", "", "", "",
				"", "", null, "", "", "", "", "", "", "", "", null);
		List<Especialidade> especialidades = new ArrayList<Especialidade>();

		especialidades.add(especialidadeRepository.findById(1l).get());
		especialidades.add(especialidadeRepository.findById(2l).get());
		especialidades.add(especialidadeRepository.findById(3l).get());

		model.addAttribute("especialidades", especialidades);
		model.addAttribute("medico", medico);
		model.addAttribute("obj", obj);

		return "/administrativo/medicoform";

	}

	@GetMapping("/medico/form/update")
	public String formUpdate(Model model, Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		Endereco endereco = enderecoRepository.findById(funcionarioRepository.findById(id).get().getEndereco().getOid())
				.get();
		Medico medico = medicoRepository.findById(id).get();
		EnderecoFuncionarioMedicoEspecialidade entity = new EnderecoFuncionarioMedicoEspecialidade(funcionario.getOid(),
				funcionario.getNome(), funcionario.getRg(), funcionario.getOrgao(), funcionario.getCpf(),
				funcionario.getTelefone(), funcionario.getCelular(), endereco.getOid(), endereco.getLogradouro(),
				endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(),
				endereco.getCep(), endereco.getEstado(), medico.getConcelho(), medico.getEspecialidade());

		model.addAttribute("entity", entity);
		return "/administrativo/medicoupdate";
	}

	@PostMapping("/funcionario/medico/update")
	public String update(@Valid EnderecoFuncionarioMedicoEspecialidade entity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/administrativo/medicoupdate";
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

		return "redirect:/medico";
	}

	@PostMapping("/medico/salvar")
	public String salvar(@Valid EnderecoFuncionarioMedicoEspecialidade obj, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/administrativo/medicoform";
		}
		Endereco endereco = new Endereco();
		Funcionario funcionario = new Funcionario();
		Medico medico = new Medico();

		endereco.setLogradouro(obj.getEndereco_logradouro());
		endereco.setBairro(obj.getEndereco_bairro());
		endereco.setCep(obj.getEndereco_cep());
		endereco.setCidade(obj.getEndereco_cidade());
		endereco.setComplemento(obj.getEndereco_complemento());
		endereco.setNumero(obj.getEndereco_numero());
		endereco.setOid(obj.getEndereco_oid());
		endereco.setEstado(obj.getEndereco_estado());

		endereco = enderecoRepository.save(endereco);

		funcionario.setCelular(obj.getFuncionario_celular());
		funcionario.setCpf(obj.getFuncionario_cpf());
		funcionario.setNome(obj.getFuncionario_nome());
		funcionario.setOid(obj.getFuncionario_oid());
		funcionario.setOrgao(obj.getFuncionario_orgao());
		funcionario.setRg(obj.getFuncionario_rg());
		funcionario.setTelefone(obj.getFuncionario_telefone());
		funcionario.setEndereco(endereco);

		funcionario = funcionarioRepository.save(funcionario);

		medico.setFuncionario(funcionario);
		medico.setConcelho(obj.getMedico_concelho());
		medico.setEspecialidade(obj.getEspecialidade());

		medicoRepository.save(medico);
		return "redirect:/medico";
	}

	@GetMapping("/medico/delete")
	public String delete(Long id) {
		medicoRepository.deleteById(id);
		return "redirect:/medico";
	}

}
