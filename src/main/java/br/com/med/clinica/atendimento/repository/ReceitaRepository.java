package br.com.med.clinica.atendimento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.atendimento.model.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Long> {

	List<Receita> findAll();

	Optional<Receita> findById(Long id);

}
