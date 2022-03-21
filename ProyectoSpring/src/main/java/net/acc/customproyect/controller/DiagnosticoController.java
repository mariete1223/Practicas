package net.acc.customproyect.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entitiesDTO.DiagnosticoSearchFilter;
import net.acc.customproyect.entitiesDTO.DiagnosticoDTO;
import net.acc.customproyect.mapper.DiagnosticoMapper;
import net.acc.customproyect.service.DiagnosticoService;

@RestController
public class DiagnosticoController {

	@Autowired
	private DiagnosticoService diagnosticoService;
	
	@PostMapping("/diagnosticos")
	public DiagnosticoSearchFilter saveDiagnostico(@RequestBody DiagnosticoSearchFilter diagnostico) {
		return diagnosticoService.saveDiagnostico(diagnostico);
	}
	
	@GetMapping("/diagnosticos")
	public List<DiagnosticoSearchFilter> fetchDiagnosticoList() {
		return diagnosticoService.findAllDiagnostico();	
	}

	@GetMapping("/diagnosticos/{id}")
	public DiagnosticoSearchFilter fetchDiagnosticoById(@PathVariable("id") Long medicoId) {
		return diagnosticoService.getDiagnosticoById(medicoId);
		
	
	}

	@DeleteMapping("/diagnosticos/{id}")
	public String deleteDiagnosticoById(@PathVariable("id") Long medicoId) {
		diagnosticoService.deleteDiagnisticoById(medicoId);
		return "deleted succesfully";
	}

	@PutMapping("/diagnosticos/{id}")
	public DiagnosticoSearchFilter updateDiagnosticoById(@PathVariable Long medicoId, @RequestBody DiagnosticoSearchFilter diagnostico) {
		return diagnosticoService.updateDiagnostico(medicoId, diagnostico);
	}
}
