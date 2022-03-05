package net.acc.customproyect.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entitiesDTO.DiagnosticoSearchFilter;
import net.acc.customproyect.entitiesDTO.DiagnosticoDTO;

@Mapper(componentModel="spring")
public interface DiagnosticoMapper {
	
	DiagnosticoMapper INSTANCE=Mappers.getMapper(DiagnosticoMapper.class);
	
	public DiagnosticoDTO DiagnosticoToDiagnosticoDTO(Diagnostico diagnostico);
	public DiagnosticoSearchFilter DiagnosticoToDiagnosticoCompletoDTO(Diagnostico diagnostico);
	public Diagnostico DiagnosticoDTOToDiagnostico(DiagnosticoDTO diagnosticoDTO);
	public Diagnostico DiagnosticoCompletoDTOToDiagnostico(DiagnosticoSearchFilter diagnosticoDTO);


}
