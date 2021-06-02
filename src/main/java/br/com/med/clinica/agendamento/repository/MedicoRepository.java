package br.com.med.clinica.agendamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.agendamento.model.Medico;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Long>{
	List<Medico> findAll();
}
