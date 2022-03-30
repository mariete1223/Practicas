package net.acc.customproyect.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entitiesDTO.PacienteSearchFilter;
import net.acc.customproyect.mapper.PacienteMapper;
import net.acc.customproyect.service.MedicoService;
import net.acc.customproyect.service.PacienteService;

@CrossOrigin(origins="*",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping("/pacientes")
	public PacienteSearchFilter savePaciente(@RequestBody PacienteSearchFilter paciente) {
		return pacienteService.savePaciente(paciente);
	}
	@CrossOrigin(origins="*",methods = {RequestMethod.GET, RequestMethod.POST})
	@GetMapping("/pacientes")
	public List<PacienteSearchFilter> fetchPacienteList() {
		return pacienteService.findAllPaciente();
	}

	@GetMapping("/pacientes/{id}")
	public PacienteSearchFilter fetchPacienteById(@PathVariable("id") Long medicoId) {
		return pacienteService.getPacienteById(medicoId);
	}

	@DeleteMapping("/pacientes/{id}")
	public String deletePacienteById(@PathVariable("id") Long pacienteId) {
		pacienteService.deletePacienteById(pacienteId);
		return "deleted succesfully";
	}
	

	@PutMapping("/pacientes/{id}")
	public PacienteSearchFilter updatePacienteById(@PathVariable("id") Long pacienteId, @RequestBody PacienteSearchFilter paciente) {
		return pacienteService.updatePaciente(pacienteId, paciente);
	}
}
