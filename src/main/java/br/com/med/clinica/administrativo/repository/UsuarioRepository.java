package br.com.med.clinica.administrativo.repository;

import br.com.med.clinica.administrativo.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {


    List<Usuario> findAll();
}