package br.com.med.clinica.atendimento.controller;

import java.util.ArrayList;
import java.util.List;

public class ReceitaDTO {

	
	private Long oid;
	
	private List<ReceitaItemDTO> items = new ArrayList<>();
	
	private String texto;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public List<ReceitaItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ReceitaItemDTO> items) {
		this.items = items;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
}
