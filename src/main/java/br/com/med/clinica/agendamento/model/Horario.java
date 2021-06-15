package br.com.med.clinica.agendamento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "horarios")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@ManyToOne()
	@JoinColumn(name = "agenda_oid")
	private Agenda agenda;

	@Column
	private String diaDaSemana;

	@Column
	private String horaInicio;

	@Column
	private String horaFinal;
	
	@OneToMany(mappedBy = "horario")
	private List<Consulta> consultas;

	public Agenda getAgenda() {
		return agenda;
	}
	

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

}
