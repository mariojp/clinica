package br.com.med.clinica.administrativo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.administrativo.model.Especialidade;
import br.com.med.clinica.administrativo.model.Funcionarios;

@Repository
public interface FuncionarioRepository extends  CrudRepository<Funcionarios,Long>{

}
