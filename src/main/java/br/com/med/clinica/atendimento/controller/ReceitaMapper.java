package br.com.med.clinica.atendimento.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.med.clinica.atendimento.model.Droga;
import br.com.med.clinica.atendimento.model.Item;
import br.com.med.clinica.atendimento.model.Receita;

public class ReceitaMapper {

	public static Receita toReceita(ReceitaDTO dto) {
		Receita entity = new Receita();
		entity.setOid(dto.getOid());
		entity.setTexto(dto.getTexto());
		if(dto.getItems() != null) {
			entity.setItens(toListItem(dto.getItems(),dto));
		}
		return entity;
	}

	public static ReceitaDTO toDTO(Receita entity) {
		ReceitaDTO dto = new ReceitaDTO();
		dto.setOid(entity.getOid());
		dto.setTexto(entity.getTexto());
		if(entity.getItens() != null) {
			dto.setItems(toListReceitaItemDTO(entity.getItens()));
		}
		return dto;
		
	}
	
	private static List<Item> toListItem(List<ReceitaItemDTO> dtos, ReceitaDTO r){
		List<Item> itens = dtos.stream().map( dto -> {
			Item item = new Item();
			item.setOid(dto.getOid());
			Droga droga = new Droga();
			droga.setOid(dto.getOidDroga());
			item.setDroga(droga);
			item.setOid(dto.getOid());
			Receita receita = new Receita();
			receita.setOid(r.getOid());
			item.setReceita(receita);
			return item;
		}
		).collect(Collectors.toList());
		return itens;
	}
	
	private static List<ReceitaItemDTO> toListReceitaItemDTO(List<Item> entitys){
		List<ReceitaItemDTO> itens = entitys.stream().map( entity -> {
			ReceitaItemDTO dto = new ReceitaItemDTO();
			dto.setOid(entity.getOid());
			dto.setDroga(entity.getDroga().getNome());
			dto.setOidDroga(entity.getDroga().getOid());
			dto.setTexto(entity.getTexto());
			return dto;
		}
		).collect(Collectors.toList());
		return itens;

	}



}
