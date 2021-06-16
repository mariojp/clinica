package br.com.med.clinica.agendamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "convenio")
public class Convenio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long convenioOid;

	@Column(length = 250)
	private String nome;

	@Column
	private String cnpj;

	@Column
	private String telefone;

	public Long getConvenioOid() {
		return convenioOid;
	}

	public void setConvenioOid(Long convenioOid) {
		this.convenioOid = convenioOid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
