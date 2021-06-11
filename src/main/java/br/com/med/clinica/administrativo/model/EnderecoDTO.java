package br.com.med.clinica.administrativo.model;

public class EnderecoDTO {

	
	/** The endereco oid. */
	private Long oid;
	
	/** The endereco logradouro. */
	private String logradouro;
	
	/** The endereco numero. */
	private String numero;
	
	/** The endereco complemento. */
	private String complemento;
	
	/** The endereco bairro. */
	private String bairro;
	
	/** The endereco cidade. */
	private String cidade;
	
	/** The endereco cep. */
	private String cep;
	
	/** The endereco estado. */
	private String estado;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
}
