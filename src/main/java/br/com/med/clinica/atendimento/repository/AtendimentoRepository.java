package br.com.med.clinica.atendimento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.med.clinica.atendimento.model.Atendimento;

public interface AtendimentoRepository extends CrudRepository<Atendimento, Long>  {


	Optional<Atendimento> findById(Long id);

	List<Atendimento> findAll();


	

}
