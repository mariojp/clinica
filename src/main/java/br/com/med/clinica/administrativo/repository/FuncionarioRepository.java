package br.com.med.clinica.administrativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.med.clinica.administrativo.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
