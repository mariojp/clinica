package br.com.med.clinica.agendamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consultas")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private String nome;
	private String hora;
	private String data;
	private Boolean retorno;
	private Boolean cancelada;
	private Long paciente_oid;
	private Long agenda_oid;
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Boolean getRetorno() {
		return retorno;
	}
	public void setRetorno(Boolean retorno) {
		this.retorno = retorno;
	}
	public Boolean getCancelada() {
		return cancelada;
	}
	public void setCancelada(Boolean cancelada) {
		this.cancelada = cancelada;
	}
	public Long getPaciente_oid() {
		return paciente_oid;
	}
	public void setPaciente_oid(Long paciente_oid) {
		this.paciente_oid = paciente_oid;
	}
	public Long getAgenda_oid() {
		return agenda_oid;
	}
	public void setAgenda_oid(Long agenda_oid) {
		this.agenda_oid = agenda_oid;
	}
	
	
}
