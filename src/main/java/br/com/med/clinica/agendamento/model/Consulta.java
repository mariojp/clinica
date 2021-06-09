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
	private String nome;
	
	@Column
	private String hora;

	@ManyToOne()
	@JoinColumn(name = "horarioOid")
	private Horario horarios;

	@Column
	private String data;

	@Column
	private String retorno = "Não disponivel";

	@Column
	private boolean cancelada;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Horario getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario horarios) {
		this.horarios = horarios;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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