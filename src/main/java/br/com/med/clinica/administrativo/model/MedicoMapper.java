package br.com.med.clinica.administrativo.model;

public class MedicoMapper {

	
	public static MedicoDTO toDTO(Medico medico ) {
		MedicoDTO dto = new MedicoDTO();
		dto.setOid(medico.getOid());
		dto.setConselho(medico.getConselho());

		if(medico.getEspecialidade() != null) {
			dto.setEspecialidade(medico.getEspecialidade().getOid());
		} 
		return dto;
	}
	
	public static Medico toEntity(MedicoDTO dto) {
		Medico entity = new Medico();
		
		entity.setOid(dto.getOid());
		
		entity.setConselho(dto.getConselho());
		
		if(dto.getEspecialidade() != null) {
			Especialidade especialidade = new Especialidade();
			especialidade.setOid(dto.getEspecialidade());
			entity.setEspecialidade(especialidade);
		}else {
			entity.setEspecialidade(null);
		}
		

		return entity;
	}
}
