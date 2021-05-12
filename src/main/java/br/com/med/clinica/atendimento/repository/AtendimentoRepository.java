package br.com.med.clinica.atendimento.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.med.clinica.atendimento.model.Atendimento;

public interface AtendimentoRepository extends CrudRepository<Atendimento, Long>{

	List<Atendimento> findAll();
}
