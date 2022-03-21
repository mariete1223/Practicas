package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entitiesDTO.MedicoSearchFilter;

public interface MedicoService {
	
	public List<MedicoSearchFilter> findAllMedico();
	public MedicoSearchFilter getMedicoById(Long id);
	public String deleteMedicoById(Long medico);
	public MedicoSearchFilter saveMedico(MedicoSearchFilter medico);
	public MedicoSearchFilter updateMedico(Long medicoId, MedicoSearchFilter medico);
}
