package br.com.med.clinica.administrativo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Endereco.
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The oid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
	/** The logradouro. */
	//@Size(min = 2, max = 50, message = "Logradouro: Este campo NAO pode ser vazio")
	private String logradouro;
	
	/** The numero. */
	//@Size(min = 1, max = 8, message = "Número: Este campo NAO pode ser vazio")
	private String numero;
	
	/** The complemento. */
	//@Size(min = 2, max = 50, message = "Complemento: Se NAO possuir complemento, escreva  ''NAO POSSUI COMPLEMENTO''  ")
	private String complemento;
	
	/** The bairro. */
	//@Size(min = 2, max = 50, message = "Bairro: Este campo NAO pode ser vazio")
	private String bairro;
	
	/** The cidade. */
	//@Size(min = 2, max = 50, message = "Cidade: Este campo NAO pode ser vazio")
	private String cidade;
	
	/** The cep. */
	//@Size(max = 8, min = 8, message = "CEP: Este campo DEVE possuir  8 números!")
	private String cep;
	
	/** The estado. */
	//@NotBlank(message = "CAMPO OBRIGATÓRIO - NAO PODE ESTAR VAZIO")
	private String estado;

	/** The funcionarios. */
	@OneToMany(mappedBy = "endereco")
	private Set<Funcionario> funcionarios = new HashSet<>();

	/**
	 * Instantiates a new endereco.
	 */
	public Endereco() {

	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Gets the funcionarios.
	 *
	 * @return the funcionarios
	 */
	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * Sets the funcionarios.
	 *
	 * @param funcionarios the new funcionarios
	 */
	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
	 * Gets the logradouro.
	 *
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Sets the logradouro.
	 *
	 * @param logradouro the new logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Gets the complemento.
	 *
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Sets the complemento.
	 *
	 * @param complemento the new complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Gets the cidade.
	 *
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Sets the cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Gets the cep.
	 *
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Sets the cep.
	 *
	 * @param cep the new cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
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
