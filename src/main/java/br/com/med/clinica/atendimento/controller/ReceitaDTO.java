package br.com.med.clinica.atendimento.controller;

public class ReceitaDTO {

	
	private Long oidAtendimento;
	
	private Long oidReceita;
	
	private String textoReceita;
	
	private String nomePaciente;
	
	
	private Long drogaOid;

	private String drogaTexto;


	public Long getDrogaOid() {
		return drogaOid;
	}

	public void setDrogaOid(Long drogaOid) {
		this.drogaOid = drogaOid;
	}

	public String getDrogaTexto() {
		return drogaTexto;
	}

	public void setDrogaTexto(String drogaTexto) {
		this.drogaTexto = drogaTexto;
	}

	public Long getOidAtendimento() {
		return oidAtendimento;
	}

	public void setOidAtendimento(Long oidAtendimento) {
		this.oidAtendimento = oidAtendimento;
	}

	public Long getOidReceita() {
		return oidReceita;
	}

	public void setOidReceita(Long oidReceita) {
		this.oidReceita = oidReceita;
	}

	public String getTextoReceita() {
		return textoReceita;
	}

	public void setTextoReceita(String textoReceita) {
		this.textoReceita = textoReceita;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	
	
}
