package net.acc.customproyect.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entitiesDTO.MedicoSearchFilter;
import net.acc.customproyect.entitiesDTO.MedicoDTO;

@Mapper(componentModel="spring")
public interface MedicoMapper {

	MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);
	
	public MedicoSearchFilter MedicoToMedicoSearchFilterDTO(Medico medico);
	
	public Medico MedicoSearchFilterDTOToMedico(MedicoSearchFilter medicoDTO);
	
	public MedicoDTO MedicoToMedicoDTO(Medico medico);
	
	public Medico MedicoDTOToMedico(MedicoDTO medicoDTO);

	public List<MedicoSearchFilter> MedicoListToMedicoSearchFilterDTOList(List<Medico> findAll);

}
