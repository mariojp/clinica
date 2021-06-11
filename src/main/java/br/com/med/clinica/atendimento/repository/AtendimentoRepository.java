package br.com.med.clinica.atendimento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Droga;

@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Long> {

	List<Atendimento> findAll();

	List<Atendimento> findAllByPaciente(String paciente);

	
	
	
}
