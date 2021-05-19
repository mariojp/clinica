package br.com.med.clinica.administrativo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.administrativo.model.Especialidade;
import br.com.med.clinica.administrativo.model.Usuarios;

@Repository
public interface UsuarioRepository extends  CrudRepository<Usuarios,Long>{

}
