package br.com.med.clinica.atendimento.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import br.com.med.clinica.atendimento.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

	List<Item> findAll();
}
