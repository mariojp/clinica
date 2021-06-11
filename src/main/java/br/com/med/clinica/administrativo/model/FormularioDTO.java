package br.com.med.clinica.administrativo.model;

public class FormularioDTO {

	// Funcionário
	private FuncionarioDTO funcionario = new FuncionarioDTO();
	

	private MedicoDTO medico = new MedicoDTO(); 

	private boolean isMedico;


	
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public MedicoDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}

	public boolean getIsMedico() {
		return isMedico;
	}

	public void setIsMedico(boolean isMedico) {
		this.isMedico = isMedico;
	}


	
	
	
}