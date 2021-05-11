package br.com.med.clinica.agendamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.agendamento.model.Convenio;

@Repository
public interface ConvenioRepository extends CrudRepository<Convenio, Long>{

	
	List<Convenio> findAll();

}
