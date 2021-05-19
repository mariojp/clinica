package br.com.med.clinica.administrativo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Medico extends Funcionario {

	private String ORM;
	
	@OneToOne
	private Especialidade especialidade;

	public String getORM() {
		return ORM;
	}

	public void setORM(String oRM) {
		ORM = oRM;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
}