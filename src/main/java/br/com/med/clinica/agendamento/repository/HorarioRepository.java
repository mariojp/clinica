package br.com.med.clinica.agendamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.agendamento.model.Horario;

	@Repository
	public interface HorarioRepository extends CrudRepository<Horario, Long>{

		List<Horario> findAll();
		List<Horario> findByAgendaAgendaOid(Long id);

	}
