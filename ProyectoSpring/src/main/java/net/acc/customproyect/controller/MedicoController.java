package net.acc.customproyect.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entitiesDTO.MedicoSearchFilter;
import net.acc.customproyect.mapper.MedicoMapper;
import net.acc.customproyect.service.MedicoService;

@CrossOrigin(origins="*",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	
	@PostMapping("/medicos")
	public MedicoSearchFilter saveMedico(@RequestBody MedicoSearchFilter medicoDTO) {
		return medicoService.saveMedico(medicoDTO);
	}
	
	@GetMapping("/medicos")
	public List<MedicoSearchFilter> fetchMedicoList() {
		return medicoService.findAllMedico();
	}

	@GetMapping("/medicos/{id}")
	public MedicoSearchFilter fetchMedicoById(@PathVariable("id") Long medicoId) {
		
		return medicoService.getMedicoById(medicoId);

		
	}

	@DeleteMapping("/medicos/{id}")
	public String deleteMedicoById(@PathVariable("id") Long medicoId) {
		medicoService.deleteMedicoById(medicoId);
		return "deleted succesfully";
	}

	@PutMapping("/medicos/{id}")
	public MedicoSearchFilter updateMedicoById(@PathVariable("id") Long medicoId, @RequestBody MedicoSearchFilter medico) {
		return medicoService.updateMedico(medicoId, medico);
	}
}
