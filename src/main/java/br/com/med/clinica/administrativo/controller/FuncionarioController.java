package br.com.med.clinica.administrativo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.administrativo.model.Endereco;
import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.FuncionarioMapper;
import br.com.med.clinica.administrativo.model.FormularioDTO;
import br.com.med.clinica.administrativo.model.Medico;
import br.com.med.clinica.administrativo.model.MedicoDTO;
import br.com.med.clinica.administrativo.model.MedicoMapper;
import br.com.med.clinica.administrativo.model.Usuario;
import br.com.med.clinica.administrativo.repository.EnderecoRepository;
import br.com.med.clinica.administrativo.repository.EspecialidadeRepository;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;
import br.com.med.clinica.administrativo.repository.MedicoRepository;
import br.com.med.clinica.administrativo.repository.UsuarioRepository;

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
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/funcionario")
	public String listFuncionario(Model model) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		return "/administrativo/funcionario";
	}

	@GetMapping("/funcionario/form")
	public String form(Model model, @Param(value = "oid") Long oid) {
		FormularioDTO dto = new FormularioDTO();
		if (oid != null) {
			Optional<Funcionario> op = funcionarioRepository.findById(oid);
			if (op.isPresent()) {
				Funcionario funcionario = op.get();
				dto.setFuncionario(FuncionarioMapper.toDTO(funcionario));
				Medico medico = medicoRepository.findMedicoByFuncionarioId(funcionario.getOid());
				if (medico != null ) {
					dto.setIsMedico(true);
					dto.setMedico(MedicoMapper.toDTO(medico));
				}else {
					dto.setIsMedico(false);
					dto.setMedico(new MedicoDTO());
				}
				
			}
		}

		model.addAttribute("formularioDTO", dto);

		model.addAttribute("especialidades", especialidadeRepository.findAll());

		return "/administrativo/funcionarioform";
	}

	@PostMapping("/funcionario/salvar")
	public String salvar(FormularioDTO formularioDTO) {

		
		Funcionario funcionario =  FuncionarioMapper.toEntity(formularioDTO.getFuncionario());
		
		funcionario = funcionarioRepository.save(funcionario);

		Medico medico = medicoRepository.findMedicoByFuncionarioId(funcionario.getOid());

		//Novo ou Atualizar
		if(formularioDTO.getIsMedico()) {
			medico = MedicoMapper.toEntity(formularioDTO.getMedico());
			medico.setFuncionario(funcionario);
			medico = medicoRepository.save(medico);
		}else if(medico != null){
			medicoRepository.delete(medico);
		}
		




		return "redirect:/funcionario";
	}

	@GetMapping("/funcionario/delete")
	public String delete(Long oid) {
		Funcionario funcionario = funcionarioRepository.getOne(oid);
		Medico medico = medicoRepository.getMedicoByFuncionario(funcionario);
		
		if (medico!=null) {
			medicoRepository.delete(medico);
		}
		funcionarioRepository.deleteById(oid);
		
		
		return "redirect:/funcionario";
	}

}