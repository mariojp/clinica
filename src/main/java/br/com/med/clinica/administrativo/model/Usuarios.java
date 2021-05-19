package br.com.med.clinica.administrativo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	private String Nome;
	private String RG;
	private String CPF;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getNome() {
		return this.Nome;
	}

	public void setRG(String RG) {
		this.RG = RG;
	}

	public String getRG() {
		return this.RG;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getCPF() {
		return this.CPF;
	}
}
