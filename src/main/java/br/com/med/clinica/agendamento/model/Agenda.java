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
	private long agenda_oid;

	@Column
	private long medico_oid;

	@OneToMany(mappedBy = "agenda")
	private List<Horario> horarios;

	public long getMedico_oid() {
		return medico_oid;
	}

	public void setMedico_oid(long medico_oid) {
		this.medico_oid = medico_oid;
	}

	public long getAgenda_oid() {
		return agenda_oid;
	}

	public void setAgenda_oid(long agenda_oid) {
		this.agenda_oid = agenda_oid;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

}