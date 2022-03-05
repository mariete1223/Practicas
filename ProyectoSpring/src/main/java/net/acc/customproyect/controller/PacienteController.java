package net.acc.customproyect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entitiesDTO.PacienteSearchFilter;
import net.acc.customproyect.mapper.PacienteMapper;
import net.acc.customproyect.service.MedicoService;
import net.acc.customproyect.service.PacienteService;

@RestController
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private PacienteMapper pacienteMapper;
	
	@PostMapping("/pacientes")
	public Paciente savePaciente(@RequestBody PacienteSearchFilter paciente) {
		return pacienteService.savePaciente(pacienteMapper.PacienteCompletoDTOToPaciente(paciente));
	}
	
	@GetMapping("/pacientes")
	public List<PacienteSearchFilter> fetchPacienteList() {
		return pacienteMapper.pacienteListToPacienteCompletoDTOList(pacienteService.findAllPaciente());
	}

	@GetMapping("/pacientes/{id}")
	public PacienteSearchFilter fetchPacienteById(@PathVariable("id") Long medicoId) {
		Optional<Paciente> paciente = pacienteService.getPacienteById(medicoId);

		if (!paciente.isPresent()) {
			return null;// throw exception
		} else {
			return pacienteMapper.PacienteToPacienteCompletoDTO(paciente.get());
		}
	}

	@DeleteMapping("/pacientes/{id}")
	public String deletePacienteById(@PathVariable("id") Long pacienteId) {
		pacienteService.deletePacienteById(pacienteId);
		return "deleted succesfully";
	}
	

	@PutMapping("/pacientes/{id}")
	public Paciente updatePacienteById(@PathVariable("id") Long pacienteId, @RequestBody Paciente paciente) {
		return pacienteService.updatePaciente(pacienteId, paciente);
	}
}
