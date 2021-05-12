package br.com.med.clinica.atendimento.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.med.clinica.atendimento.model.Exame;

public interface ExameRepository extends CrudRepository<Exame, Long>{

	List<Exame> findAll();
}
