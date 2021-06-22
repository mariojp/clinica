package br.com.med.clinica.atendimento.controller;

import java.util.ArrayList;
import java.util.List;



public class AtendimentoDTO {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AtendimentoDTO [oid=");
		builder.append(oid);
		builder.append(", paciente=");
		builder.append(paciente);
		builder.append(", conduta=");
		builder.append(conduta);
		builder.append(", exames=");
		builder.append(exames);
		builder.append(", receitas=");
		builder.append(receitas);
		builder.append("]");
		return builder.toString();
	}

	private Long oid;

	private String paciente;

	private String conduta;
	
	private List<ExameDTO> exames = new ArrayList<>();
	
	private List<ReceitaDTO> receitas= new ArrayList<>();

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getConduta() {
		return conduta;
	}

	public void setConduta(String conduta) {
		this.conduta = conduta;
	}

	public List<ExameDTO> getExames() {
		return exames;
	}

	public void setExames(List<ExameDTO> exames) {
		this.exames = exames;
	}

	public List<ReceitaDTO> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<ReceitaDTO> receitas) {
		this.receitas = receitas;
	}
	
	
}
