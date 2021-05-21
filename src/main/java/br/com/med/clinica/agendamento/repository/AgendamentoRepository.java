package br.com.med.clinica.agendamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.agendamento.model.Agendamento;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Long>{

	
	List<Agendamento> findAll();

}
