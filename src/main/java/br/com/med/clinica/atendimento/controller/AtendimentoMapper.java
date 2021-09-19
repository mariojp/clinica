package br.com.med.clinica.atendimento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Exame;
import br.com.med.clinica.atendimento.model.Receita;
import net.bytebuddy.asm.Advice.Return;

public class AtendimentoMapper {

	
	
	public static AtendimentoDTO toDTO(Atendimento entity ) {
		AtendimentoDTO dto = new AtendimentoDTO();
		dto.setOid(entity.getOid());
		dto.setConduta(entity.getConduta());
		dto.setPaciente(entity.getPaciente());
		if(entity.getExames()!= null) {
			dto.setExames(toListExameDTO(entity.getExames()));
		}
		if(entity.getReceitas()!= null) {
			dto.setReceitas(toListReceitaDTO(entity.getReceitas()));
		}
		
		return dto;
	}
	

	public static Atendimento toAtendimento(AtendimentoDTO dto) {
		Atendimento entity = new Atendimento();
		entity.setOid(dto.getOid());
		entity.setConduta(dto.getConduta());
		entity.setPaciente(dto.getPaciente());
		return entity;
		
		
	}
	
	
	private static List<ExameDTO> toListExameDTO(List<Exame> entitys){
		List<ExameDTO> dtos = entitys.stream().map( exame -> {
			return ExameMapper.toDTO(exame);
		}).collect(Collectors.toList());
		return dtos;
	}
	
	private static List<ReceitaDTO> toListReceitaDTO(List<Receita> entitys) {
		List<ReceitaDTO> dtos = entitys.stream().map( receita -> {
			return ReceitaMapper.toDTO(receita);
		}).collect(Collectors.toList());
		return dtos;
	}


}
