package br.com.med.clinica.administrativo.repository;
import br.com.med.clinica.administrativo.model.Medico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface MedicoRepository extends CrudRepository<Medico, Long> {


        List<Medico> findAll();
    }


