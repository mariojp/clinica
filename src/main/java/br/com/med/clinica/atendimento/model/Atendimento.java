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

@Entity
@Table(name = "atendimentos")
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@Column(length = 250)
	private String conduta;

	// @ManyToOne
	// @JoinColumn(name = "consulta_oid", nullable = false)
	// private Consulta consulta;

	@OneToMany(mappedBy = "atendimento")
	private List<Receita> receitas;

	@OneToMany(mappedBy = "atendimento")
	private List<Exames> exames;

	public Atendimento() {

	}

	public Atendimento(String conduta) {
		super();
		this.conduta = conduta;
	}

	// incluir Consulta depois
	public Atendimento(Long oid, String conduta, List<Receita> receitas, List<Exames> exames) {
		this();
		this.oid = oid;
		this.conduta = conduta;
		this.receitas = receitas;
		this.exames = exames;
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

	public List<Exames> getExames() {
		return exames;
	}

	public void setExames(List<Exames> exames) {
		this.exames = exames;
	}

//	public Consulta getConsulta() {
//		return consulta;
//	}

//	public void setConsulta(Consulta consulta) {
//		this.consulta = consulta;
//	}

	// incluir equals hash code depois
	// incluir toString

}
