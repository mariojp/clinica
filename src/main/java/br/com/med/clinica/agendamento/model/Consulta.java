package br.com.med.clinica.agendamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private String nome;
	private String hora;
	private String data;
	private Boolean retorno;
	private Boolean cancelada;
	private String retornoSTR;
	private String canceladaSTR;
	private Long paciente_id;
	@OneToOne
	private Paciente paciente;
	@ManyToOne
	private Agenda agenda;
	//TODO Criar Lista de Atendimento
	//quando a classe "Medico" for criada pelo outro grupo
	
	public Long getOid() {
		return oid;
	}
	public String getRetornoSTR() {
		return retornoSTR;
	}
	public void setRetornoSTR(String retornoSTR) {
		this.retornoSTR = retornoSTR;
	}
	public String getCanceladaSTR() {
		return canceladaSTR;
	}
	public void setCanceladaSTR(String canceladaSTR) {
		this.canceladaSTR = canceladaSTR;
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
	public Long getPaciente_id() {
		return paciente_id;
	}
	public void setPaciente_id(Long paciente_id) {
		this.paciente_id = paciente_id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	
}
