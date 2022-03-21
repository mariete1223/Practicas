package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entitiesDTO.DiagnosticoDTO;
import net.acc.customproyect.entitiesDTO.DiagnosticoSearchFilter;

public interface DiagnosticoService {
	
	public List<DiagnosticoSearchFilter> findAllDiagnostico();
	public DiagnosticoSearchFilter getDiagnosticoById(Long id);
	public void deleteDiagnisticoById(Long diagnostico);
	public DiagnosticoSearchFilter saveDiagnostico(DiagnosticoSearchFilter diagnostico);
	public DiagnosticoSearchFilter updateDiagnostico(Long diagnosticoId, DiagnosticoSearchFilter diagnostico);
}
//Cambiar por DTO