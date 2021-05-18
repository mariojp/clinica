package br.com.med.clinica.funcionario.repository;
import br.com.med.clinica.funcionario.model.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
     public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {


        List<Funcionario> findAll();
    }

