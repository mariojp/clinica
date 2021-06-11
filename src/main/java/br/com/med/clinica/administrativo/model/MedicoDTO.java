package br.com.med.clinica.administrativo.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class EnderecoFuncionarioMedicoEspecialidade.
 */
public class MedicoDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	private Long oid;

	private FuncionarioDTO funcionario = new FuncionarioDTO();
	
	/** The especialidade. */
	private Long especialidade;
	
	
	private String conselho;

	/**
	 * Instantiates a new endereco funcionario medico especialidade.
	 */
	public MedicoDTO() {

	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public Long getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Long especialidade) {
		this.especialidade = especialidade;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	
	
}

