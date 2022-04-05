package net.acc.customproyect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entitiesDTO.CitaDTO;
import net.acc.customproyect.mapper.CitaMapper;
import net.acc.customproyect.service.CitaService;

@CrossOrigin(origins="*",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
public class CitaController {

	
	@Autowired
	private CitaService citaService;
	
	@PostMapping("/citas")
	@Transactional
	public CitaDTO saveCita(@RequestBody CitaDTO cita) {
		return citaService.saveCita(cita);
	}
	
	@GetMapping("/citas")
	public List<CitaDTO> fetchCitasList() {
		return citaService.findAllCita();
	}

	@GetMapping("/citas/{id}")
	public CitaDTO fetchCitaById(@PathVariable("id") Long citaId) {
		CitaDTO cita = citaService.getCitaById(citaId);

		if (cita == null) {
			return null;// throw exception
		} else {
			return cita;
		}
	}

	@DeleteMapping("/citas/{id}")
	public String deleteCitaById(@PathVariable("id") Long citaId) {
		citaService.deleteCitaById(citaId);
		return "deleted succesfully";
	}

	@PutMapping("/citas/{id}")
	public CitaDTO updateCitaById(@PathVariable("id") Long citaId, @RequestBody CitaDTO cita) {
		return citaService.updateCita(citaId, cita);
	}
	
	
}
