package br.com.med.clinica.agendamento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agendas")
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private List<Horario> horarios;
	private List<Consulta> consultas;
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public List<Horario> getHorario() {
		return horarios;
	}
	public void setHorario(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public List<Consulta> getConsulta() {
		return consultas;
	}
	public void setConsulta(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
}
