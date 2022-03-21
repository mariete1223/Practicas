package net.acc.customproyect.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entitiesDTO.PacienteSearchFilter;
import net.acc.customproyect.entitiesDTO.PacienteDTO;

@Mapper(componentModel="spring")
public interface PacienteMapper {
	
	PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);
	
	 PacienteDTO PacienteToPacienteDto(Paciente paciente);
	 Paciente PacienteDTOToPaciente(PacienteDTO pacienteDTO);
	 PacienteSearchFilter PacienteToPacienteSearchFilterDTO(Paciente paciente);
	 Paciente PacienteSearchFilterDTOToPaciente(PacienteSearchFilter pacienteDTO);
	 List<PacienteDTO> pacienteListToPacienteDTOList(List<Paciente> pacientes);
	 List<PacienteSearchFilter> pacienteListToPacienteSearchFilterDTOList(List<Paciente> pacientes);
}
