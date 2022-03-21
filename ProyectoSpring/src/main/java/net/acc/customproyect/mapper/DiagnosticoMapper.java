package net.acc.customproyect.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entitiesDTO.DiagnosticoSearchFilter;
import net.acc.customproyect.entitiesDTO.CitaDTO;
import net.acc.customproyect.entitiesDTO.DiagnosticoDTO;

@Mapper(componentModel="spring")
public interface DiagnosticoMapper {
	
	DiagnosticoMapper INSTANCE=Mappers.getMapper(DiagnosticoMapper.class);
	
	public DiagnosticoDTO DiagnosticoToDiagnosticoDTO(Diagnostico diagnostico);
	public DiagnosticoSearchFilter DiagnosticoToDiagnosticoSearchFilterDTO(Diagnostico diagnostico);
	public Diagnostico DiagnosticoDTOToDiagnostico(DiagnosticoDTO diagnosticoDTO);
	public Diagnostico DiagnosticoSearchFilterDTOToDiagnostico(DiagnosticoSearchFilter diagnosticoDTO);
	
	List<DiagnosticoSearchFilter> DiagnosticoSListToDiagnosticoSearchFilterList(List<Diagnostico> diagnosticos);


}
