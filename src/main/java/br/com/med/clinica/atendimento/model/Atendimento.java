package br.com.med.clinica.atendimento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	// @ManyToOne
	// @JoinColumn(name = "consulta_oid", nullable = false)
	// private Consulta consulta;
	@Column
	private Long consultas_oid;

	@OneToMany(mappedBy = "atendimento")
	private List<Receita> receitas;

	
	@OneToMany(mappedBy = "atendimento")
	private List<Exame> exames;

	public Atendimento() {

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

	public Long getConsultas_oid() {
		return consultas_oid;
	}

	public void setConsultas_oid(Long consultas_oid) {
		this.consultas_oid = consultas_oid;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conduta == null) ? 0 : conduta.hashCode());
		result = prime * result + ((consultas_oid == null) ? 0 : consultas_oid.hashCode());
		result = prime * result + ((exames == null) ? 0 : exames.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result + ((receitas == null) ? 0 : receitas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		if (conduta == null) {
			if (other.conduta != null)
				return false;
		} else if (!conduta.equals(other.conduta))
			return false;
		if (consultas_oid == null) {
			if (other.consultas_oid != null)
				return false;
		} else if (!consultas_oid.equals(other.consultas_oid))
			return false;
		if (exames == null) {
			if (other.exames != null)
				return false;
		} else if (!exames.equals(other.exames))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (receitas == null) {
			if (other.receitas != null)
				return false;
		} else if (!receitas.equals(other.receitas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atendimento [oid=" + oid + ", paciente=" + paciente + ", conduta=" + conduta + ", consultas_oid="
				+ consultas_oid + ", receitas=" + receitas + ", exames=" + exames + "]";
	}

}
