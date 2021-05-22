package br.com.med.clinica.agendamento.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horarios")
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoriaId;
	private Date diaSemana;
	private String hora;
	//esse atributo e pra dizer se uma agenda qualquer
	//não pegou esse horario
	private boolean agendado;

	public String getHora() {
		return hora;
	}
	public void Hora(String hora) {
		this.hora = hora;
	}
	public Date getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(Date diaSemana) {
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