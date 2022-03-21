package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entitiesDTO.PacienteSearchFilter;

public interface PacienteService {
	
	public List<PacienteSearchFilter> findAllPaciente();
	public PacienteSearchFilter getPacienteById(Long id);
	public void deletePacienteById(Long paciente);
	public PacienteSearchFilter savePaciente(PacienteSearchFilter paciente);
	public PacienteSearchFilter updatePaciente(Long pacienteId, PacienteSearchFilter paciente);
}
