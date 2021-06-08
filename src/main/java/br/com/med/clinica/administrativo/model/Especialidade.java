package br.com.med.clinica.administrativo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Especialidade.
 */
@Entity
@Table(name = "especialidade")
public class Especialidade {

	/** The oid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	/** The nome. */
	@NotBlank(message = "CAMPO OBRIGATÓRIO - NAO PODE ESTAR VAZIO")
	@Column(length = 250)
	@Size(max = 30, min = 2, message = "Este campo NAO pode ser vazio! Informe a especialidade!")
	private String nome;

	/**
	 * Instantiates a new especialidade.
	 *
	 * @param oid the oid
	 * @param nome the nome
	 */
	public Especialidade(Long oid,
			@Size(max = 30, min = 2, message = "Este campo NAO pode ser vazio! Informe a especialidade!") String nome) {
		super();
		this.oid = oid;
		this.nome = nome;
	}

	/**
	 * Instantiates a new especialidade.
	 */
	public Especialidade() {
	}

	/**
	 * Gets the oid.
	 *
	 * @return the oid
	 */
	public Long getOid() {
		return oid;
	}

	/**
	 * Sets the oid.
	 *
	 * @param oid the new oid
	 */
	public void setOid(Long oid) {
		this.oid = oid;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID: ");
		builder.append(oid);
		builder.append(" | Nome: ");
		builder.append(nome);
		return builder.toString();
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Especialidade))
			return false;

		Especialidade that = (Especialidade) o;

		return getOid().equals(that.getOid());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return getOid().hashCode();
	}
}

