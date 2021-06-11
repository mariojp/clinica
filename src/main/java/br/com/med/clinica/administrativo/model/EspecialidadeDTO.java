package br.com.med.clinica.administrativo.model;

import javax.persistence.Column;

public class EspecialidadeDTO {

	
	private Long oid;

	private String nome;
	
	
	public EspecialidadeDTO() {
		// TODO Auto-generated constructor stub
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
	
	
}
