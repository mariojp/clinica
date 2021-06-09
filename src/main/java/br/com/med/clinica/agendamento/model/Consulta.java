package br.com.med.clinica.agendamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long consultaOid;

	@Column
	private String nomeDiaHora;

	@ManyToOne()
	@JoinColumn(name = "horarioOid")
	private Horario horarios;

	@Column
	private String semana;

	@Column
	private String retorno = "Não disponivel";

	@Column
	private boolean cancelada;

	@Column
	private String paciente;

	@Column
	@JoinColumn
	private Long pacienteOid;

	@Column
	private Long agendaOid;

	public Long getConsultaOid() {
		return consultaOid;
	}

	public void setConsultaOid(Long consultaOid) {
		this.consultaOid = consultaOid;
	}

	public String getNomeDiaHora() {
		return nomeDiaHora;
	}
	

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public void setNomeDiaHora(String nomeDiaHora) {
		this.nomeDiaHora = nomeDiaHora;
	}

	public Horario getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario horarios) {
		this.horarios = horarios;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public Long getPacienteOid() {
		return pacienteOid;
	}

	public void setPacienteOid(Long pacienteOid) {
		this.pacienteOid = pacienteOid;
	}

	public Long getAgendaOid() {
		return agendaOid;
	}

	public void setAgendaOid(Long agendaOid) {
		this.agendaOid = agendaOid;
	}

	
	
}