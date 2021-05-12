package br.com.med.clinica.atendimento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atendimentos")
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	private String conduta;
//	private Consulta consulta;

	public Atendimento() {

	}

	public Atendimento(String conduta) {

		this.conduta = conduta;
	}

	
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getConduta() {
		return conduta;
	}

	public void setConduta(String conduta) {
		this.conduta = conduta;
	}

	@Override
	public String toString() {
		return "Atendimento [oid=" + oid + ", conduta=" + conduta + "]";
	}

//	public Consulta getConsulta() {
//		return consulta;
//	}

//	public void setConsulta(Consulta consulta) {
//		this.consulta = consulta;
//	}



}
