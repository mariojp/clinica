package br.com.med.clinica.atendimento.controller;



public class AtendimentoDTO {

	private String idReceita;

	private String idAtendimento;

	private String textoReceita;

	public String getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(String idReceita) {
		this.idReceita = idReceita;
	}

	public String getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(String idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public String getTextoReceita() {
		return textoReceita;
	}

	public void setTextoReceita(String textoReceita) {
		this.textoReceita = textoReceita;
	}

}
