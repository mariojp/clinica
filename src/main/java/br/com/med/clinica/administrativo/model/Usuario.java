package br.com.med.clinica.administrativo.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Size(max = 15, min = 2, message = "O usuário deve ter de 2 a 15 Caracteres")
    private String Username;

    @javax.validation.constraints.Email
    private String Email;

    @Size(max = 8, min = 4, message = "A senha deve ser de 4 a 8 digitos")
    private String senha;

    @OneToOne
    private Funcionario funcionario;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return oid.equals(usuario.oid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid);
    }
}
