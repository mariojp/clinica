package br.com.med.clinica.atendimento.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.med.clinica.atendimento.model.Receita;

public interface ReceitaRepository extends CrudRepository<Receita, Long>{

	List<Receita> findAll();
}
