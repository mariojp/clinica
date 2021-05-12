package br.com.med.clinica.atendimento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receitas")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	private String texto;
	private Atendimento atendimento;

	public Receita() {

	}

	public Receita(String texto, Atendimento atendimento) {
		super();
		this.texto = texto;
		this.atendimento = atendimento;
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

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	@Override
	public String toString() {
		return "Receita [oid=" + oid + ", texto=" + texto + ", atendimento=" + atendimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atendimento == null) ? 0 : atendimento.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
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
		Receita other = (Receita) obj;
		if (atendimento == null) {
			if (other.atendimento != null)
				return false;
		} else if (!atendimento.equals(other.atendimento))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

}
