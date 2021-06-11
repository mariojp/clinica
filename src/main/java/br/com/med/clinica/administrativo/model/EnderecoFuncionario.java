package br.com.med.clinica.administrativo.model;

// TODO: Auto-generated Javadoc
/**
 * The Class EnderecoFuncionario.
 */
public class EnderecoFuncionario {

	/** The funcionario oid. */
	private Long funcionario_oid;
	
	/** The funcionario nome. */
	private String funcionario_nome;
	
	/** The funcionario rg. */
	private String funcionario_rg;
	
	/** The funcionario orgao. */
	private String funcionario_orgao;
	
	/** The funcionario cpf. */
	private String funcionario_cpf;
	
	/** The funcionario telefone. */
	private String funcionario_telefone;
	
	/** The funcionario celular. */
	private String funcionario_celular;

	/** The endereco oid. */
	private Long endereco_oid;
	
	/** The endereco logradouro. */
	private String endereco_logradouro;
	
	/** The endereco numero. */
	private String endereco_numero;
	
	/** The endereco complemento. */
	private String endereco_complemento;
	
	/** The endereco bairro. */
	private String endereco_bairro;
	
	/** The endereco cidade. */
	private String endereco_cidade;
	
	/** The endereco cep. */
	private String endereco_cep;
	
	/** The endereco estado. */
	private String endereco_estado;

	/**
	 * Instantiates a new endereco funcionario.
	 */
	public EnderecoFuncionario() {

	}

	/**
	 * Instantiates a new endereco funcionario.
	 *
	 * @param funcionario_oid the funcionario oid
	 * @param funcionario_nome the funcionario nome
	 * @param funcionario_rg the funcionario rg
	 * @param funcionario_orgao the funcionario orgao
	 * @param funcionario_cpf the funcionario cpf
	 * @param funcionario_telefone the funcionario telefone
	 * @param funcionario_celular the funcionario celular
	 * @param endereco_oid the endereco oid
	 * @param endereco_logradouro the endereco logradouro
	 * @param endereco_numero the endereco numero
	 * @param endereco_complemento the endereco complemento
	 * @param endereco_bairro the endereco bairro
	 * @param endereco_cidade the endereco cidade
	 * @param endereco_cep the endereco cep
	 * @param endereco_estado the endereco estado
	 */
	public EnderecoFuncionario(Long funcionario_oid, String funcionario_nome, String funcionario_rg,
			String funcionario_orgao, String funcionario_cpf, String funcionario_telefone, String funcionario_celular,
			Long endereco_oid, String endereco_logradouro, String endereco_numero, String endereco_complemento,
			String endereco_bairro, String endereco_cidade, String endereco_cep, String endereco_estado) {
		super();
		this.funcionario_oid = funcionario_oid;
		this.funcionario_nome = funcionario_nome;
		this.funcionario_rg = funcionario_rg;
		this.funcionario_orgao = funcionario_orgao;
		this.funcionario_cpf = funcionario_cpf;
		this.funcionario_telefone = funcionario_telefone;
		this.funcionario_celular = funcionario_celular;
		this.endereco_oid = endereco_oid;
		this.endereco_logradouro = endereco_logradouro;
		this.endereco_numero = endereco_numero;
		this.endereco_complemento = endereco_complemento;
		this.endereco_bairro = endereco_bairro;
		this.endereco_cidade = endereco_cidade;
		this.endereco_cep = endereco_cep;
		this.endereco_estado = endereco_estado;
	}

	/**
	 * Gets the endereco estado.
	 *
	 * @return the endereco estado
	 */
	public String getEndereco_estado() {
		return endereco_estado;
	}

	/**
	 * Sets the endereco estado.
	 *
	 * @param endereco_estado the new endereco estado
	 */
	public void setEndereco_estado(String endereco_estado) {
		this.endereco_estado = endereco_estado;
	}

	/**
	 * Gets the funcionario oid.
	 *
	 * @return the funcionario oid
	 */
	public Long getFuncionario_oid() {
		return funcionario_oid;
	}

	/**
	 * Sets the funcionario oid.
	 *
	 * @param funcionario_oid the new funcionario oid
	 */
	public void setFuncionario_oid(Long funcionario_oid) {
		this.funcionario_oid = funcionario_oid;
	}

	/**
	 * Gets the funcionario nome.
	 *
	 * @return the funcionario nome
	 */
	public String getFuncionario_nome() {
		return funcionario_nome;
	}

	/**
	 * Sets the funcionario nome.
	 *
	 * @param funcionario_nome the new funcionario nome
	 */
	public void setFuncionario_nome(String funcionario_nome) {
		this.funcionario_nome = funcionario_nome;
	}

	/**
	 * Gets the funcionario rg.
	 *
	 * @return the funcionario rg
	 */
	public String getFuncionario_rg() {
		return funcionario_rg;
	}

	/**
	 * Sets the funcionario rg.
	 *
	 * @param funcionario_rg the new funcionario rg
	 */
	public void setFuncionario_rg(String funcionario_rg) {
		this.funcionario_rg = funcionario_rg;
	}

	/**
	 * Gets the funcionario orgao.
	 *
	 * @return the funcionario orgao
	 */
	public String getFuncionario_orgao() {
		return funcionario_orgao;
	}

	/**
	 * Sets the funcionario orgao.
	 *
	 * @param funcionario_orgao the new funcionario orgao
	 */
	public void setFuncionario_orgao(String funcionario_orgao) {
		this.funcionario_orgao = funcionario_orgao;
	}

	/**
	 * Gets the funcionario cpf.
	 *
	 * @return the funcionario cpf
	 */
	public String getFuncionario_cpf() {
		return funcionario_cpf;
	}

	/**
	 * Sets the funcionario cpf.
	 *
	 * @param funcionario_cpf the new funcionario cpf
	 */
	public void setFuncionario_cpf(String funcionario_cpf) {
		this.funcionario_cpf = funcionario_cpf;
	}

	/**
	 * Gets the funcionario telefone.
	 *
	 * @return the funcionario telefone
	 */
	public String getFuncionario_telefone() {
		return funcionario_telefone;
	}

	/**
	 * Sets the funcionario telefone.
	 *
	 * @param funcionario_telefone the new funcionario telefone
	 */
	public void setFuncionario_telefone(String funcionario_telefone) {
		this.funcionario_telefone = funcionario_telefone;
	}

	/**
	 * Gets the funcionario celular.
	 *
	 * @return the funcionario celular
	 */
	public String getFuncionario_celular() {
		return funcionario_celular;
	}

	/**
	 * Sets the funcionario celular.
	 *
	 * @param funcionario_celular the new funcionario celular
	 */
	public void setFuncionario_celular(String funcionario_celular) {
		this.funcionario_celular = funcionario_celular;
	}

	/**
	 * Gets the endereco oid.
	 *
	 * @return the endereco oid
	 */
	public Long getEndereco_oid() {
		return endereco_oid;
	}

	/**
	 * Sets the endereco oid.
	 *
	 * @param endereco_oid the new endereco oid
	 */
	public void setEndereco_oid(Long endereco_oid) {
		this.endereco_oid = endereco_oid;
	}

	/**
	 * Gets the endereco logradouro.
	 *
	 * @return the endereco logradouro
	 */
	public String getEndereco_logradouro() {
		return endereco_logradouro;
	}

	/**
	 * Sets the endereco logradouro.
	 *
	 * @param endereco_logradouro the new endereco logradouro
	 */
	public void setEndereco_logradouro(String endereco_logradouro) {
		this.endereco_logradouro = endereco_logradouro;
	}

	/**
	 * Gets the endereco numero.
	 *
	 * @return the endereco numero
	 */
	public String getEndereco_numero() {
		return endereco_numero;
	}

	/**
	 * Sets the endereco numero.
	 *
	 * @param endereco_numero the new endereco numero
	 */
	public void setEndereco_numero(String endereco_numero) {
		this.endereco_numero = endereco_numero;
	}

	/**
	 * Gets the endereco complemento.
	 *
	 * @return the endereco complemento
	 */
	public String getEndereco_complemento() {
		return endereco_complemento;
	}

	/**
	 * Sets the endereco complemento.
	 *
	 * @param endereco_complemento the new endereco complemento
	 */
	public void setEndereco_complemento(String endereco_complemento) {
		this.endereco_complemento = endereco_complemento;
	}

	/**
	 * Gets the endereco bairro.
	 *
	 * @return the endereco bairro
	 */
	public String getEndereco_bairro() {
		return endereco_bairro;
	}

	/**
	 * Sets the endereco bairro.
	 *
	 * @param endereco_bairro the new endereco bairro
	 */
	public void setEndereco_bairro(String endereco_bairro) {
		this.endereco_bairro = endereco_bairro;
	}

	/**
	 * Gets the endereco cidade.
	 *
	 * @return the endereco cidade
	 */
	public String getEndereco_cidade() {
		return endereco_cidade;
	}

	/**
	 * Sets the endereco cidade.
	 *
	 * @param endereco_cidade the new endereco cidade
	 */
	public void setEndereco_cidade(String endereco_cidade) {
		this.endereco_cidade = endereco_cidade;
	}

	/**
	 * Gets the endereco cep.
	 *
	 * @return the endereco cep
	 */
	public String getEndereco_cep() {
		return endereco_cep;
	}

	/**
	 * Sets the endereco cep.
	 *
	 * @param endereco_cep the new endereco cep
	 */
	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}

}
