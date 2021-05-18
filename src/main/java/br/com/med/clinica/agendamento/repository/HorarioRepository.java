package br.com.med.clinica.agendamento.repository;

import java.util.List;

import br.com.med.clinica.agendamento.model.Horario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface HorarioRepository extends CrudRepository<Horario, Long>{

	List<Horario> findAll();
}
