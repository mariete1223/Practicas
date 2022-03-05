package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entities.Medico;

public interface MedicoService {
	
	public List<Medico> findAllMedico();
	public Optional<Medico> getMedicoById(Long id);
	public String deleteMedicoById(Long medico);
	public Medico saveMedico(Medico medico);
	public Medico updateMedico(Long medicoId, Medico medico);
}
