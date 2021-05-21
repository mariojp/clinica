package br.com.med.clinica.atendimento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@Column(length = 250)
	private String texto;

	@ManyToOne
	@JoinColumn(name = "droga_oid")
	private Droga droga;

	@ManyToOne
	@JoinColumn(name = "receita_oid")
	private Receita receita;

	public Item() {

	}

	public Item(String texto) {
		super();
		this.texto = texto;
	}

	public Item(Long oid, String texto, Droga droga, Receita receita) {
		this();
		this.oid = oid;
		this.texto = texto;
		this.droga = droga;
		this.receita = receita;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Droga getDroga() {
		return droga;
	}

	public void setDroga(Droga droga) {
		this.droga = droga;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((droga == null) ? 0 : droga.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((receita == null) ? 0 : receita.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Item other = (Item) obj;
		if (droga == null) {
			if (other.droga != null)
				return false;
		} else if (!droga.equals(other.droga))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (receita == null) {
			if (other.receita != null)
				return false;
		} else if (!receita.equals(other.receita))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [oid=" + oid + ", texto=" + texto + ", droga=" + droga + ", receita=" + receita + "]";
	}

}
