package br.com.med.clinica.agendamento.model;

public class AgendaDto {
	private Long id;
	private Medico medico;
	
	
	public AgendaDto(Long id, Medico medico) {
		super();
		this.id = id;
		this.medico = medico;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
