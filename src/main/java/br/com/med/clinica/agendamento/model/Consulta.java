package br.com.med.clinica.agendamento.model;

import java.util.List;

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
	private Paciente paciente;
	private Agenda agenda;
	//TODO subistituir o Long por Atendimento
	//quando essa classe for criada pelo outro grupo
	private List<Long> atendimentosId;
	
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
