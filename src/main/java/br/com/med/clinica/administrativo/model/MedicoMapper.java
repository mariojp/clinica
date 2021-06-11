package br.com.med.clinica.administrativo.model;

/**
 * 
 * @author mariojp
 *
 */
public class MedicoMapper {

	public static MedicoDTO toDTO(Medico medico ) {
		MedicoDTO dto = new MedicoDTO();
		dto.setOid(medico.getOid());
		dto.setFuncionario(FuncionarioMapper.toDTO(medico.getFuncionario()));
		dto.setConselho(medico.getConcelho());

		if(medico.getEspecialidade() != null) {
			dto.setEspecialidade(medico.getEspecialidade().getOid());
		} 
		return dto;
	}
	
	public static Medico toEntity(MedicoDTO dto) {
		Medico entity = new Medico();
		
		entity.setOid(dto.getOid());
		
		entity.setConcelho(dto.getConselho());
		
		if(dto.getEspecialidade() != null) {
			Especialidade especialidade = new Especialidade();
			especialidade.setOid(dto.getEspecialidade());
			entity.setEspecialidade(especialidade);
		}else {
			entity.setEspecialidade(null);
		}
		
		entity.setFuncionario(FuncionarioMapper.toEntity(dto.getFuncionario()));

		return entity;
	}

	

	
	
}
