package br.com.med.clinica.agendamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Consultas") 
public class Consultas{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long oid;

    @Column
    private String name;

    @Column
    private String Hora;

    @Column
    private String Data;

    @Column
    private boolean Retorno;

    @Column
    private boolean Cancelada;
    
	@Column
    private long paciente_oid;

	@Column
    private long agenda_oid;

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public boolean isRetorno() {
		return Retorno;
	}

	public void setRetorno(boolean retorno) {
		Retorno = retorno;
	}

	public boolean isCancelada() {
		return Cancelada;
	}

	public void setCancelada(boolean cancelada) {
		Cancelada = cancelada;
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