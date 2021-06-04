package br.com.med.clinica.administrativo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.Medico;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Long> {

	@Query("select m from Medico m where m.funcionario.oid = ?1")
	public Medico findMedicoByFuncionarioId(Long id);
	
	@Query("select m from Medico m where m.funcionario = ?1 ")
	public Medico getMedicoByFuncionario(Funcionario funcionario);
	
}