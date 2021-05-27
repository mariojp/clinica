package br.com.med.clinica.agendamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long consulta_oid;

	@Column
	private String nome;

	@Column
	private String hora;

	@Column
	private String data;

	@Column
	private String retorno = "Não disponivel";

	@Column
	private boolean cancelada;

	@Column
	private long paciente_oid;

	@Column
	private long agenda_oid;

	public long getConsulta_oid() {
		return consulta_oid;
	}

	public void setConsulta_oid(long consulta_oid) {
		this.consulta_oid = consulta_oid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRetorno() {
		return retorno;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String isRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public boolean getCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public long getPaciente_oid() {
		return paciente_oid;
	}

	public void setPaciente_oid(long paciente_oid) {
		this.paciente_oid = paciente_oid;
	}

	public long getAgenda_oid() {
		return agenda_oid;
	}

	public void setAgenda_oid(long agenda_oid) {
		this.agenda_oid = agenda_oid;
	}

}