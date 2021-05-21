package br.com.med.clinica.agendamento.model;

import javax.persistence.Column;
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
	private long agenda_oid;
	
	@Column
	private long horario_oid;
	
	@Column
	private long category_id;
	
	@Column
	private String diaDaSemana;
	
	@Column
	private String hora;
	
	
	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getDdiaDaSemana() {
		return diaDaSemana;
	}

	public void setdiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public long getAgenda_oid() {
		return agenda_oid;
	}

	public void setAgenda_oid(long agenda_oid) {
		this.agenda_oid = agenda_oid;
	}

}
