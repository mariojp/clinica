package br.com.med.clinica.atendimento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drogas")
public class Droga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
  
	@NotEmpty()  //pode combinar essas anotações, mas nesse caso, o size já resolve
	@Size(min = 3, max = 50)
	@Column(length = 250)
	private String nome;

	@OneToMany(mappedBy = "droga")
	private List<Item> itens;

	public Droga() {

	}

	public Droga(String nome) {
		super();
		this.nome = nome;
	}

	public Droga(Long oid, String nome, List<Item> itens) {
		this();
		this.oid = oid;
		this.nome = nome;
		this.itens = itens;
	}

	public Long getOid() {
		return oid;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Droga other = (Droga) obj;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Droga [oid=" + oid + ", nome=" + nome + ", itens=" + itens + "]";
	}

}
