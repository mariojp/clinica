package br.com.med.clinica.administrativo.model;

public class MedicoDTO {

	private Long oid;

	private String conselho;
	
	private Long especialidade;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	

	public Long getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Long especialidade) {
		this.especialidade = especialidade;
	}

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}
	
	
}
