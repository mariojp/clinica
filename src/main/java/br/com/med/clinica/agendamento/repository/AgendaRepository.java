package br.com.med.clinica.agendamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.agendamento.model.Agenda;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Long>{
	
	List<Agenda> findAll();
	List<Agenda> findByAgendaOid(Long id);

}
