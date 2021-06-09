package br.com.med.clinica.agendamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private String nome;
	private String senha;
	private String email;
	
	public Usuario() {
		
	}
	public Usuario(String nome, String senha, String email) {
		
		this.nome = nome;
		this.senha = senha;
		this.email = email;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Object getLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
