package br.com.med.clinica.agendamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoriaId;
	private String diaSemana;
	private String hora;
	@ManyToOne
	private Agenda agenda;
	private Long agendaoid;
	
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public Long getAgendaoid() {
		return agendaoid;
	}
	public void setAgendaoid(Long agendaoid) {
		this.agendaoid = agendaoid;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	//esse atributo e pra dizer se uma agenda qualquer
	//não pegou esse horario
	private boolean agendado;

	public String getHora() {
		return hora;
	}
	public void Hora(String hora) {
		this.hora = hora;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public boolean isAgendado() {
		return agendado;
	}
	public void setAgendado(boolean agendado) {
		this.agendado = agendado;
	}
	
}