package br.com.med.clinica.atendimento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.atendimento.model.Droga;

@Repository
public interface DrogaRepository extends CrudRepository<Droga, Long> {

	List<Droga> findAll();

}
