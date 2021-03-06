package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entitiesDTO.CitaDTO;

public interface CitaService {
	
	public List<CitaDTO> findAllCita();
	public CitaDTO getCitaById(Long id);
	public void deleteCitaById(Long cita);
	public CitaDTO saveCita(CitaDTO cita);
	public CitaDTO updateCita(Long citaId, CitaDTO cita);
	

}
