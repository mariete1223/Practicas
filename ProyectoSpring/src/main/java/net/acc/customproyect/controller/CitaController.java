package net.acc.customproyect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entitiesDTO.CitaDTO;
import net.acc.customproyect.mapper.CitaMapper;
import net.acc.customproyect.service.CitaService;

@RestController
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@Autowired
	private CitaMapper citaMapper;
	
	@PostMapping("/citas")
	@Transactional
	public CitaDTO saveCita(@RequestBody CitaDTO cita) {
		return citaService.saveCita(citaMapper.CitaDTOToCita(cita));
	}
	
	@GetMapping("/citas")
	public List<CitaDTO> fetchCitasList() {
		return citaMapper.citaListToCitaDTOList(citaService.findAllCita());
	}

	@GetMapping("/citas/{id}")
	public CitaDTO fetchCitaById(@PathVariable("id") Long citaId) {
		Optional<Cita> cita = citaService.getCitaById(citaId);

		if (!cita.isPresent()) {
			return null;// throw exception
		} else {
			return citaMapper.CitaToCitaDTO( cita.get());
		}
	}

	@DeleteMapping("/citas/{id}")
	public String deleteCitaById(@PathVariable("id") Long citaId) {
		citaService.deleteCitaById(citaId);
		return "deleted succesfully";
	}

	@PutMapping("/citas/{id}")
	public Cita updateCitaById(@PathVariable("id") Long citaId, @RequestBody Cita cita) {
		return citaService.updateCita(citaId, cita);
	}
	
	
}
