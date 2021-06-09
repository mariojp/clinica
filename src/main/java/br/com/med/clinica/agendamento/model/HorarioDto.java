package br.com.med.clinica.agendamento.model;

public class HorarioDto {

	private Long id;
	private String diaSemana;
	private String hora;
	private AgendaDto agenda;
	
	public HorarioDto(Long id, String diaSemana, String hora, AgendaDto agenda) {
		super();
		this.id = id;
		this.diaSemana = diaSemana;
		this.hora = hora;
		this.agenda = agenda;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public AgendaDto getAgenda() {
		return agenda;
	}
	public void setAgenda(AgendaDto agenda) {
		this.agenda = agenda;
	}
	
	
}
