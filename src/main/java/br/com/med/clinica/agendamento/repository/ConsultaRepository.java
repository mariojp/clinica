package br.com.med.clinica.agendamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.agendamento.model.Consulta;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

	List<Consulta> findAll();

}
