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

@Entity
@Table(name = "drogas")
public class Droga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
  
	@NotEmpty()
	@Column(length = 250)
	private String nome;

	@OneToMany(mappedBy = "droga")
	private List<Item> itens;



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

}
