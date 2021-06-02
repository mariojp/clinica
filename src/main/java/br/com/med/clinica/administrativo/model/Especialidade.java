package br.com.med.clinica.administrativo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "especialidade")
public class Especialidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
	@Column(length = 250)
	@Size(max = 30,min = 2, message = "Este campo não pode ser vazio! Informe a especialidade!")
	private String nome;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Especialidade [oid=");
		builder.append(oid);
		builder.append(", nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Especialidade)) return false;

		Especialidade that = (Especialidade) o;

		return getOid().equals(that.getOid());
	}

	@Override
	public int hashCode() {
		return getOid().hashCode();
	}
}
