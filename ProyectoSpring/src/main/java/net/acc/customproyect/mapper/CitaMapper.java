package net.acc.customproyect.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entitiesDTO.CitaDTO;

@Mapper(componentModel = "spring")
public interface CitaMapper {
	
	CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);
	
	CitaDTO CitaToCitaDTO(Cita cita);
	Cita CitaDTOToCita(CitaDTO citaDTO);
	List<Cita> citaDTOListToCitaList(List<CitaDTO> citasDTO);
	List<CitaDTO> citaListToCitaDTOList(List<Cita> citasDTO);
	

}
