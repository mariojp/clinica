package br.com.med.clinica.administrativo.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Size(max = 44, min = 1, message = "Nome: Este campo não pode ser vazio")
    private String nome;

    @Size(max = 10, min = 10,message = "RG: Este campo deve possuir 10 DÍGITOS")
    private String rg;

    @NotEmpty(message = "Orgão: orgão emissor não pode ser vazio")
    private String orgao;

    @CPF
    private String cpf;

    @Size(max = 10, min = 10,message = "Telefone: Deve possuir 10 digitos")
    private String telefone;

    @Size(max =11, min =11, message = "Celular: Deve possuir 11 digitos")
    private String celular;

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Funcionario [oid=");
        builder.append(oid);
        builder.append(", nome=");
        builder.append(nome);
        builder.append("]");
        builder.append(", rg=");
        builder.append(rg);
        builder.append("]");
        builder.append(", orgao=");
        builder.append(orgao);
        builder.append("]");
        builder.append(", CPF=");
        builder.append(cpf);
        builder.append("]");
        builder.append(", Telefone=");
        builder.append(telefone);
        builder.append("]");
        builder.append(", Celular=");
        builder.append(celular);
        builder.append("]");

        return builder.toString();
    }
}
