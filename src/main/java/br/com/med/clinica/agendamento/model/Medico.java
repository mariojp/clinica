package br.com.med.clinica.agendamento.model;

import java.util.ArrayList;
import java.util.List;


public class Medico {

	private Long oid;
	private String nome;
	private String cpf;
	private String especialidade;
	
	public Medico() {
		
	}
	
	public Medico(Long oid, String nome, String cpf, String especialidade) {
		super();
		this.oid = oid;
		this.nome = nome;
		this.cpf = cpf;
		this.especialidade = especialidade;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
