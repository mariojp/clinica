package br.com.med.clinica.administrativo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.med.clinica.administrativo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findAll();
}
