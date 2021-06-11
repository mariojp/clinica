package br.com.med.clinica.atendimento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "itens")
public class Item {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long oid;

		@NotEmpty
		@Column(length = 250)
		private String texto;
		// Criação da ligação de droga com item
		@ManyToOne
		@JoinColumn(name = "droga_oid",
		foreignKey = @ForeignKey(name = "DROGA_OID_FK"))
		private Droga droga;
		// Criação do elo bidirecional de receita com item
		@ManyToOne
		@JoinColumn(name = "receita_oid")
		private Receita receita;

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

		public Droga getDroga() {
			return droga;
		}

		public void setDroga(Droga droga) {
			this.droga = droga;
		}

		public Receita getReceita() {
			return receita;
		}

		public void setReceita(Receita receita) {
			this.receita = receita;
		}


}
