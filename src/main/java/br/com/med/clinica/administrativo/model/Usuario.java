package br.com.med.clinica.administrativo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table(name = "tb_usuario")
public class Usuario {

	/** The oid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	/** The username. */
	//@Size(max = 15, min = 2, message = "O usuário deve ter de 2 a 15 Caracteres")
	private String username;

	/** The email. */
	@Email
	private String email;

	/** The password. */
	@Size(max = 8, min = 4, message = "A senha deve ser de 4 a 8 digitos")
	private String password;

	/** The funcionario. */
	@OneToOne
	@MapsId
	private Funcionario funcionario;

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
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
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
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param senha the new password
	 */
	public void setPassword(String senha) {
		this.password = senha;
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
		if (o == null || getClass() != o.getClass())
			return false;
		Usuario usuario = (Usuario) o;
		return oid.equals(usuario.oid);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(oid);
	}
}
