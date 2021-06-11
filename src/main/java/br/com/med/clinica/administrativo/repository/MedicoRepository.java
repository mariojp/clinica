package br.com.med.clinica.administrativo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.administrativo.model.Medico;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Long> {

	List<Medico> findAll();
}
