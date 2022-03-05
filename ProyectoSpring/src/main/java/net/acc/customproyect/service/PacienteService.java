package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;

public interface PacienteService {
	
	public List<Paciente> findAllPaciente();
	public Optional<Paciente> getPacienteById(Long id);
	public void deletePacienteById(Long paciente);
	public Paciente savePaciente(Paciente paciente);
	public Paciente updatePaciente(Long pacienteId, Paciente paciente);
}
