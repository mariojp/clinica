package br.com.med.clinica.administrativo.model;

public class FuncionarioMapper {

	public static FuncionarioDTO toDTO(Funcionario funcionario ) {
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setNome(funcionario.getNome());
		dto.setCelular(funcionario.getCelular());
		dto.setCpf(funcionario.getCpf());
		dto.setRg(funcionario.getRg());
		dto.setOrgaoEmissor(funcionario.getOrgaoEmissor());
		dto.setOid(funcionario.getOid());
		dto.setTelefone(funcionario.getTelefone());
		if(funcionario.getEndereco() != null) {
			dto.setEndereco(toEnderecoDTO(funcionario.getEndereco()));
		}else {
			dto.setEndereco(new EnderecoDTO());
		}
		return dto;
	}
	
	public static Funcionario toEntity(FuncionarioDTO dto) {
		Funcionario entity = new Funcionario();
		entity.setNome(dto.getNome());
		entity.setCelular(dto.getCelular());
		entity.setCpf(dto.getCpf());
		entity.setRg(dto.getRg());
		entity.setOrgaoEmissor(dto.getOrgaoEmissor());
		entity.setOid(dto.getOid());
		entity.setTelefone(dto.getTelefone());
		if(dto.getEndereco() != null) {
			entity.setEndereco(toEnderecoEntity(dto.getEndereco()));
		}
		return entity;
	}
	
	public static EnderecoDTO toEnderecoDTO(Endereco endereco) {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setCep(endereco.getCep());
		dto.setLogradouro(endereco.getLogradouro());
		dto.setBairro(endereco.getBairro());
		dto.setCidade(endereco.getCidade());
		dto.setComplemento(endereco.getComplemento());
		dto.setEstado(endereco.getEstado());
		dto.setNumero(endereco.getNumero());
		dto.setOid(endereco.getOid());
		return dto;
	}
	
	public static Endereco toEnderecoEntity(EnderecoDTO dto) {
		Endereco entity = new Endereco();
		entity.setCep(dto.getCep());
		entity.setLogradouro(dto.getLogradouro());
		entity.setBairro(dto.getBairro());
		entity.setCidade(dto.getCidade());
		entity.setComplemento(dto.getComplemento());
		entity.setEstado(dto.getEstado());
		entity.setNumero(dto.getNumero());
		entity.setOid(dto.getOid());
		return entity;
	}
}
