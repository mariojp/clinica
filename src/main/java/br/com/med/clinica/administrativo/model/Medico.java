package br.com.med.clinica.administrativo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "tb_medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @NotEmpty(message = "Não pode ser vazio")
    private String concelho;

    @OneToOne
    @MapsId
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "especialidade_oid")
    private Especialidade especialidade;



    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medico)) return false;

        Medico medico = (Medico) o;

        return getOid().equals(medico.getOid());
    }

    @Override
    public int hashCode() {
        return getOid().hashCode();
    }
}
