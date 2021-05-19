package br.com.med.clinica.administrativo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionarios extends Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	public int NumCarTrabalho;
	public String Login;
	public String Senha;

	public void setNumCarTrabalho(int Value) {
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public int getNumCarTrabalho() {
		return NumCarTrabalho;
	}

	@Override

	public void setRG(String RG) {
		if (!RG.equals("")) {
			super.setRG(RG);
		}
	}

	@Override
	public String getRG() {
		return super.getRG();
	}
}
