package br.com.med.clinica.administrativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.med.clinica.administrativo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
