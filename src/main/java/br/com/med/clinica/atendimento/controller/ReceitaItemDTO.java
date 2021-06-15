package br.com.med.clinica.atendimento.controller;

public class ReceitaItemDTO {

	
	private Long oid;
	
	private Long oidDroga;
	
	private String droga;

	private String texto;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOidDroga() {
		return oidDroga;
	}

	public void setOidDroga(Long oidDroga) {
		this.oidDroga = oidDroga;
	}

	public String getDroga() {
		return droga;
	}

	public void setDroga(String droga) {
		this.droga = droga;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
}
