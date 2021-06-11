package br.com.med.clinica.agendamento.repository;

import java.util.List;

import br.com.med.clinica.agendamento.model.Agenda;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Long>{

	List<Agenda> findAll();
}
