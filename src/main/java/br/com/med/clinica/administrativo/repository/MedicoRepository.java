package br.com.med.clinica.administrativo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.administrativo.model.Medicos;

@Repository
public interface MedicoRepository extends CrudRepository<Medicos,Long> {

}
