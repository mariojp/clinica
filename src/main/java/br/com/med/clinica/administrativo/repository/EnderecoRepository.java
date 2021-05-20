package br.com.med.clinica.administrativo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.med.clinica.administrativo.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

	List<Endereco> findAll();
}
