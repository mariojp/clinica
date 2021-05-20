package br.com.med.clinica.administrativo.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.administrativo.model.Funcionario;

import java.util.List;

    @Repository
     public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {


        List<Funcionario> findAll();
    }

