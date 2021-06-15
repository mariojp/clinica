package br.com.med.clinica.agendamento.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;


	@ManyToOne()
	@JoinColumn(name = "horario_oid")
	private Horario horario;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	@Column
	private boolean retorno;

	@Column
	private boolean cancelada;


	@ManyToOne
	@JoinColumn(name="paciente_oid")
	private Paciente paciente;


	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}


	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	
	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}



	
	
}