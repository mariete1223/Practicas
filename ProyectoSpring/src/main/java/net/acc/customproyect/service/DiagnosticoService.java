package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entitiesDTO.DiagnosticoDTO;

public interface DiagnosticoService {
	
	public List<Diagnostico> findAllDiagnostico();
	public Optional<Diagnostico> getDiagnosticoById(Long id);
	public void deleteDiagnisticoById(Long diagnostico);
	public Diagnostico saveDiagnostico(Diagnostico diagnostico);
	public Diagnostico updateDiagnostico(Long diagnosticoId, Diagnostico diagnostico);
}
//Cambiar por DTO