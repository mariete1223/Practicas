package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entitiesDTO.CitaDTO;

public interface CitaService {
	
	public List<Cita> findAllCita();
	public Optional<Cita> getCitaById(Long id);
	public void deleteCitaById(Long cita);
	public CitaDTO saveCita(Cita cita);
	public Cita updateCita(Long citaId, Cita cita);
	

}
