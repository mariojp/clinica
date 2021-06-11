package br.com.med.clinica.administrativo.model;

import javax.validation.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class EnderecoFuncionario.
 * 
 *
 * 
 */
public class FuncionarioDTO {
	
	

	/** The funcionario oid. */
	private Long oid;
	
	/** The funcionario nome. */
	//private String funcionario_nome;
	@NotBlank
	private String nome;

	
	/** The funcionario rg. */
	private String rg;
	
	/** The funcionario orgao. */
	private String orgao;
	
	/** The funcionario cpf. */
	private String cpf;
	
	/** The funcionario telefone. */
	private String telefone;
	
	/** The funcionario celular. */
	private String celular;


	private EnderecoDTO endereco = new EnderecoDTO();
	
	/**
	 * Instantiates a new endereco funcionario.
	 */
	public FuncionarioDTO() {

	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgao() {
		return orgao;
	}

	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
	


}
