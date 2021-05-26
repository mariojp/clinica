package br.com.med.clinica.agendamento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
	@OneToMany
	@JoinColumn(name = "consultas_id")
	private List<Consulta> consultas;
	@OneToMany
	@JoinColumn(name = "horarios_id")
	private List<Horario> horarios;
	//TODO subistituir o Long por Medico
	//quando essa classe for criada pelo outro grupo
	private Long medicoOid;
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public Long getMedicoOid() {
		return medicoOid;
	}
	public void setMedicoOid(Long medicoOid) {
		this.medicoOid = medicoOid;
	}
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
}
