package br.com.med.clinica.agendamento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agenda")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long agendaOid;

	@Column
	private String medico;

	@OneToMany(mappedBy = "agenda")
	private List<Horario> horarios;

	public Long getAgendaOid() {
		return agendaOid;
	}

	public void setAgendaOid(Long agendaOid) {
		this.agendaOid = agendaOid;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

}