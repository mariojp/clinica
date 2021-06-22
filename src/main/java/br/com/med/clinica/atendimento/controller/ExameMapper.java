package br.com.med.clinica.atendimento.controller;

import br.com.med.clinica.atendimento.model.Exame;

public class ExameMapper {

	
	public static ExameDTO toDTO(Exame entity ) {
		ExameDTO dto = new ExameDTO();
		dto.setOid(entity.getOid());
		dto.setTexto(entity.getTexto());
		return dto;
	}
	
	public static Exame toExame(ExameDTO dto) {
		Exame entity = new Exame();
		entity.setOid(dto.getOid());
		entity.setTexto(dto.getTexto());
		return entity;
		
		
	}
	
	
	
}
