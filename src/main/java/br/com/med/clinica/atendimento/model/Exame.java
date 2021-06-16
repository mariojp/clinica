package br.com.med.clinica.atendimento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "exames")
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@Column(length = 250)
	private String texto;
	// Criação da ligação de Exame com Atendimento
	@ManyToOne
	@JoinColumn(name = "atendimento_oid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Atendimento atendimento;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

}
