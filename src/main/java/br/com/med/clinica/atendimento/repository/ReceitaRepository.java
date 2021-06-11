package br.com.med.clinica.atendimento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Droga;
import br.com.med.clinica.atendimento.model.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Long> {

	List<Receita> findAll();

	List<Receita> findByAtendimento(Atendimento atendimento);

}
