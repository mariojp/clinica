package br.com.med.clinica.administrativo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class Medico.
 */
@Entity
@Table(name = "tb_medico")
public class Medico {

	/** The oid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	/** The concelho. */
	@NotBlank(message = "NAO pode ser vazio")
	private String concelho;

	/** The funcionario. */
	@OneToOne
	@MapsId
	private Funcionario funcionario;

	/** The especialidade. */
	@ManyToOne
	@JoinColumn(name = "especialidade_oid")
	private Especialidade especialidade;

	/**
	 * Instantiates a new medico.
	 */
	public Medico() {
		super();
	}

	/**
	 * Instantiates a new medico.
	 *
	 * @param funcionario the funcionario
	 */
	public Medico(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Instantiates a new medico.
	 *
	 * @param concelho the concelho
	 * @param funcionario the funcionario
	 * @param especialidade the especialidade
	 */
	public Medico(String concelho, Funcionario funcionario, Especialidade especialidade) {
		this.concelho = concelho;
		this.funcionario = funcionario;
		this.especialidade = especialidade;
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
	 * Gets the concelho.
	 *
	 * @return the concelho
	 */
	public String getConcelho() {
		return concelho;
	}

	/**
	 * Sets the concelho.
	 *
	 * @param concelho the new concelho
	 */
	public void setConcelho(String concelho) {
		this.concelho = concelho;
	}

	/**
	 * Gets the funcionario.
	 *
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Sets the funcionario.
	 *
	 * @param funcionario the new funcionario
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Gets the especialidade.
	 *
	 * @return the especialidade
	 */
	public Especialidade getEspecialidade() {
		return especialidade;
	}

	/**
	 * Sets the especialidade.
	 *
	 * @param especialidade the new especialidade
	 */
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
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
		if (!(o instanceof Medico))
			return false;

		Medico medico = (Medico) o;

		return getOid().equals(medico.getOid());
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

