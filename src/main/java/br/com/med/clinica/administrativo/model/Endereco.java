package br.com.med.clinica.administrativo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@Size(min = 2,max = 50,message = "Logradouro: Este campo não pode ser vazio")
	private String logradouro;

	@Size(min = 1,max = 8,message = "Número: Este campo não pode ser vazio")
	private String numero;

	@Size(min = 2,max = 50,message = "Complemento: Se não possuir complemento, escreva  ''NÃO POSSUI COMPLEMENTO''  ")
	private String complemento;

	@Size(min = 2,max = 50, message = "Bairro: Este campo não pode ser vazio")
	private String bairro;

	@Size(min = 2,max = 50,message = "Cidade: Este campo não pode ser vazio")
	private String cidade;

	@Size(max = 8, min = 8, message = "CEP: Este campo DEVE possuir  8 números!")
	private String cep;
	
	public Endereco() {
		
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		return true;
	}
	
	

	
}
