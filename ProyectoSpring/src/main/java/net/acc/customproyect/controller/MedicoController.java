package net.acc.customproyect.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import net.acc.customproyect.entitiesDTO.MedicoSearchFilter;
import net.acc.customproyect.mapper.MedicoMapper;
import net.acc.customproyect.service.MedicoService;

@RestController
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@Autowired 
	private MedicoMapper medicoMapper;
	
	
	@PostMapping("/medicos")
	public Medico saveMedico(@RequestBody MedicoSearchFilter medicoDTO) {
		return medicoService.saveMedico(medicoMapper.MedicoCompletoDTOToMedico(medicoDTO));
	}
	
	@GetMapping("/medicos")
	public List<MedicoSearchFilter> fetchMedicoList() {
		Medico medico = medicoService.findAllMedico().get(0);
		medicoMapper.MedicoToMedicoDTO(medico);
		medicoService.findAllMedico().forEach(e->System.out.println(e.getNumColegio()));
		return medicoService.findAllMedico().stream()
									.map((e) -> medicoMapper.MedicoToMedicoCompletoDTO(e))
									.collect(Collectors.toList());
	}

	@GetMapping("/medicos/{id}")
	public MedicoSearchFilter fetchMedicoById(@PathVariable("id") Long medicoId) {
		
		Optional<Medico> medico = medicoService.getMedicoById(medicoId);

		if (!medico.isPresent()) {
			return null;// throw exception
		} else {
			return medicoMapper.MedicoToMedicoCompletoDTO(medico.get());
		}
	}

	@DeleteMapping("/medicos/{id}")
	public String deleteMedicoById(@PathVariable("id") Long medicoId) {
		medicoService.deleteMedicoById(medicoId);
		return "deleted succesfully";
	}

	@PutMapping("/medicos/{id}")
	public Medico updateMedicoById(@PathVariable("id") Long medicoId, @RequestBody MedicoSearchFilter medico) {
		return medicoService.updateMedico(medicoId, medicoMapper.MedicoCompletoDTOToMedico(medico));
	}
}
