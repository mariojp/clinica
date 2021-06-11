package br.com.med.clinica.agendamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.agendamento.model.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

	List<Paciente> findAll();

}
