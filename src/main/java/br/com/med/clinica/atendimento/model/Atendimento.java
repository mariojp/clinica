package br.com.med.clinica.atendimento.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "atendimentos")
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	// private Paciente
	@Size(min = 3, max = 25)
	@Column(length = 50)
	private String paciente;

	@Size(min = 3, max = 150)
	@Column(length = 250)
	private String conduta;

	@OneToMany(mappedBy = "atendimento")
	private List<Receita> receitas;

	
	@OneToMany(mappedBy = "atendimento",cascade = CascadeType.ALL)
	private List<Exame> exames;

	public Atendimento() {

	}
	
	public Atendimento(Long oid) {
		this.oid = oid;
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


	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

}
