package br.com.med.clinica.agendamento.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
	@OneToMany
	@JoinColumn(name = "consultas_id")
	private List<Consulta> consultas;
	@OneToMany
	@JoinColumn(name = "horarios_id")
	private List<Horario> horarios;
	private Long medicooid;
	

	public Agenda() {
		this.consultas = new ArrayList<>();
		this.setHorarios(new ArrayList<>());
	}
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public Long getMedicooid() {
		return medicooid;
	}
	
	public void setMedicooid(Long medicooid) {
		this.medicooid = medicooid;
	}
		
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	
}
