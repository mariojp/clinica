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

@Entity(name = "Exame")
@Table(name = "exames")
public class Exame {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long oid;
		
		@Column(length = 250)
		private String nome;
		


		@ManyToOne
		@JoinColumn(name = "atendimento_oid",
				foreignKey = @ForeignKey(name = "ATENDIMENTO_OID_FK")
		)
		private Atendimento atendimento;
		
		public Atendimento getAtendimento() {
			return atendimento;
		}

		public void setAtendimento(Atendimento atendimento) {
			this.atendimento = atendimento;
		}

		public Long getOid() {
			return oid;
		}

		public void setOid(Long oid) {
			this.oid = oid;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		

		
	}
