package br.com.med.clinica.administrativo.model;

public class FuncionarioEndereco {

	// Funcionário
	private Long funcionario_oid;
	private String funcionario_nome;
	private String funcionario_rg;
	private String funcionario_orgaoEmissor;
	private String funcionario_cpf;
	private String funcionario_telefone;
	private String funcionario_celular;

	// Se o funcionário for médico
	private boolean funcionario_medico;
	private Long medico_oid;
	private String medico_concelho;
	private Especialidade medico_especialidade;

	// Endereço do funcionário
	private Long endereco_oid;
	private String endereco_nome;
	private Integer endereco_numero;
	private String endereco_complemento;
	private String endereco_bairro;
	private String endereco_cidade;
	private String endereco_estado;
	private String endereco_cep;

	public Long getFuncionario_oid() {
		return funcionario_oid;
	}

	public void setFuncionario_oid(Long funcionario_oid) {
		this.funcionario_oid = funcionario_oid;
	}

	public String getFuncionario_nome() {
		return funcionario_nome;
	}

	public void setFuncionario_nome(String funcionario_nome) {
		this.funcionario_nome = funcionario_nome;
	}

	public String getFuncionario_rg() {
		return funcionario_rg;
	}

	public void setFuncionario_rg(String funcionario_rg) {
		this.funcionario_rg = funcionario_rg;
	}

	public String getFuncionario_orgaoEmissor() {
		return funcionario_orgaoEmissor;
	}

	public void setFuncionario_orgaoEmissor(String funcionario_orgaoEmissor) {
		this.funcionario_orgaoEmissor = funcionario_orgaoEmissor;
	}

	public String getFuncionario_cpf() {
		return funcionario_cpf;
	}

	public void setFuncionario_cpf(String funcionario_cpf) {
		this.funcionario_cpf = funcionario_cpf;
	}

	public String getFuncionario_telefone() {
		return funcionario_telefone;
	}

	public void setFuncionario_telefone(String funcionario_telefone) {
		this.funcionario_telefone = funcionario_telefone;
	}

	public String getFuncionario_celular() {
		return funcionario_celular;
	}

	public void setFuncionario_celular(String funcionario_celular) {
		this.funcionario_celular = funcionario_celular;
	}
	
	public boolean isFuncionario_medico() {
		return funcionario_medico;
	}

	public void setFuncionario_medico(boolean funcionario_medico) {
		this.funcionario_medico = funcionario_medico;
	}

	public Long getMedico_oid() {
		return medico_oid;
	}

	public void setMedico_oid(Long medico_oid) {
		this.medico_oid = medico_oid;
	}

	public String getMedico_concelho() {
		return medico_concelho;
	}

	public void setMedico_concelho(String medico_concelho) {
		this.medico_concelho = medico_concelho;
	}

	public Especialidade getMedico_especialidade() {
		return medico_especialidade;
	}

	public void setMedico_especialidade(Especialidade medico_especialidade) {
		this.medico_especialidade = medico_especialidade;
	}

	public Long getEndereco_oid() {
		return endereco_oid;
	}

	public void setEndereco_oid(Long endereco_oid) {
		this.endereco_oid = endereco_oid;
	}

	public String getEndereco_nome() {
		return endereco_nome;
	}

	public void setEndereco_nome(String endereco_nome) {
		this.endereco_nome = endereco_nome;
	}

	public Integer getEndereco_numero() {
		return endereco_numero;
	}

	public void setEndereco_numero(Integer endereco_numero) {
		this.endereco_numero = endereco_numero;
	}

	public String getEndereco_complemento() {
		return endereco_complemento;
	}

	public void setEndereco_complemento(String endereco_complemento) {
		this.endereco_complemento = endereco_complemento;
	}

	public String getEndereco_bairro() {
		return endereco_bairro;
	}

	public void setEndereco_bairro(String endereco_bairro) {
		this.endereco_bairro = endereco_bairro;
	}

	public String getEndereco_cidade() {
		return endereco_cidade;
	}

	public void setEndereco_cidade(String endereco_cidade) {
		this.endereco_cidade = endereco_cidade;
	}

	public String getEndereco_estado() {
		return endereco_estado;
	}

	public void setEndereco_estado(String endereco_estado) {
		this.endereco_estado = endereco_estado;
	}

	public String getEndereco_cep() {
		return endereco_cep;
	}

	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}
}