package br.com.med.clinica.atendimento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.med.clinica.atendimento.model.Receita;

public interface ReceitaRepository extends CrudRepository<Receita, Long> {

	List<Receita> findAll();

	Optional<Receita> findById(Long id);

}
