package br.com.med.clinica.agendamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agendamento") 
public class Agendamento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agendamento_oid;

    @Column
    private long medico_oid;
    
    @ManyToOne    
	@JoinColumn(name = "horario_oid",  foreignKey = @ForeignKey(name = "horario_oid_fk")) 
    private Horario horario;
    
	public long getOid() {
		return agendamento_oid;
	}

	public void setOid(long oid) {
		this.agendamento_oid = oid;
	}

	public long getMedico_oid() {
		return medico_oid;
	}

	public void setMedico_oid(long medico_oid) {
		this.medico_oid = medico_oid;
	}

	public Horario getHorarios() {
		return horario;
	}

	public void setHorarios(Horario horarios) {
		this.horario = horarios;
	}
	
	

}