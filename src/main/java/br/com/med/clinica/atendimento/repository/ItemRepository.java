package br.com.med.clinica.atendimento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.med.clinica.atendimento.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

	List<Item> findAll();

	Optional<Item> findById(Long id);

}