package br.com.med.clinica.agendamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paciente_oid;

	@Column
	private String nome;

	@Column
	private String rg;

	@Column
	private String orgao;

	@Column
	private String cpf;

	@Column
	private String telefone;

	@Column
	private String celular;

	@Column
	private String email;

	@Column
	private long convenio_oid;

	public long getPaciente_oid() {
		return paciente_oid;
	}

	public void setPaciente_oid(long paciente_oid) {
		this.paciente_oid = paciente_oid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getConvenio_oid() {
		return convenio_oid;
	}

	public void setConvenio_oid(long convenio_oid) {
		this.convenio_oid = convenio_oid;
	}

}