package br.com.med.clinica.administrativo.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

// TODO: Auto-generated Javadoc
/**
 * The Class Funcionario.
 */
@Entity
@Table(name = "funcionario")
public class Funcionario {

	/** The oid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
	/** The nome. */
	@NotBlank(message = "CAMPO OBRIGATÓRIO - NAO PODE ESTAR VAZIO")
	@Size(max = 44, min = 1, message = "Nome: Este campo nao pode ser vazio")
	private String nome;
	
	/** The rg. */
	@NotBlank(message = "CAMPO OBRIGATÓRIO - NAO PODE ESTAR VAZIO")
	@Size(max = 10, min = 10, message = "RG: Este campo deve possuir 10 DIGITOS")
	private String rg;
	
	/** The orgao. */
	@NotBlank(message = "CAMPO OBRIGATÓRIO - NAO PODE ESTAR VAZIO")
	@NotEmpty(message = "Orgão: orgao emissor nao pode ser vazio")
	private String orgao;
	
	/** The cpf. */
	@NotBlank(message = "CAMPO OBRIGATÓRIO - NAO PODE ESTAR VAZIO")
	@CPF
	private String cpf;
	
	/** The telefone. */
	@NotBlank(message = "CAMPO OBRIGATÓRIO - NAO PODE ESTAR VAZIO")
	@Size(max = 11, min = 11, message = "Telefone: Deve possuir 11 digitos")
	private String telefone;
	
	/** The celular. */
	@NotBlank(message = "CAMPO OBRIGATÓRIO - NAO PODE ESTAR VAZIO")
	@Size(max = 12, min = 12, message = "Celular: Deve possuir 12 digitos")
	private String celular;

	/**
	 * Instantiates a new funcionario.
	 */
	public Funcionario() {

	}

	/** The endereco. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "endereco_oid")
	private Endereco endereco;

	/** The usuario. */
	@OneToOne(mappedBy = "funcionario", cascade = CascadeType.REMOVE)
	private Usuario usuario;

	/** The medico. */
	@OneToOne(mappedBy = "funcionario", cascade = CascadeType.REMOVE)
	private Medico medico;

	/**
	 * Instantiates a new funcionario.
	 *
	 * @param oid the oid
	 * @param nome the nome
	 * @param rg the rg
	 * @param orgao the orgao
	 * @param cpf the cpf
	 * @param telefone the telefone
	 * @param celular the celular
	 */
	public Funcionario(Long oid, String nome, String rg, String orgao, String cpf, String telefone, String celular) {
		super();
		this.oid = oid;
		this.nome = nome;
		this.rg = rg;
		this.orgao = orgao;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
	}

	/**
	 * Gets the medico.
	 *
	 * @return the medico
	 */
	public Medico getMedico() {
		return medico;
	}

	/**
	 * Sets the medico.
	 *
	 * @param medico the new medico
	 */
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	 * Gets the rg.
	 *
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * Sets the rg.
	 *
	 * @param rg the new rg
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * Gets the orgao.
	 *
	 * @return the orgao
	 */
	public String getOrgao() {
		return orgao;
	}

	/**
	 * Sets the orgao.
	 *
	 * @param orgao the new orgao
	 */
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Gets the celular.
	 *
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Sets the celular.
	 *
	 * @param celular the new celular
	 */
	public void setCelular(String celular) {
		this.celular = celular;
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
		builder.append(" |  RG: ");
		builder.append(rg);
		builder.append(" | Orgão: ");
		builder.append(orgao);
		builder.append(" | CPF: ");
		builder.append(cpf);
		builder.append(" | Telefone: ");
		builder.append(telefone);
		builder.append(" | Celular: ");
		builder.append(celular);

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
		if (!(o instanceof Funcionario))
			return false;
		Funcionario that = (Funcionario) o;
		return getOid().equals(that.getOid());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getOid());
	}

}
