package br.com.med.clinica.administrativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.administrativo.model.Convenio;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long> {

}