package net.acc.customproyect.imp;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entitiesDTO.CitaDTO;
import net.acc.customproyect.entitiesDTO.PacienteDTO;
import net.acc.customproyect.mapper.CitaMapper;
import net.acc.customproyect.repositories.CitaRepository;
import net.acc.customproyect.repositories.DiagnosticoRepository;
import net.acc.customproyect.repositories.MedicoRepository;
import net.acc.customproyect.repositories.PacienteRepository;
import net.acc.customproyect.service.CitaService;

@Service
public class CitaServiceImp implements CitaService {

	@Autowired
	private CitaRepository citaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private CitaMapper citaMapper;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private DiagnosticoRepository diagnosticoRepository;

	@Override
	public List<Cita> findAllCita() {
		return citaRepository.findAll();
	}

	@Override
	public Optional<Cita> getCitaById(Long id) {
		return citaRepository.findById(id);

	}

	@Override
	public void deleteCitaById(Long cita) {
		citaRepository.deleteById(cita);

	}

	@Override
	public Cita updateCita(Long citaId, Cita cita) {
		Optional<Cita> cit = citaRepository.findById(citaId);
		if (cit.isPresent()) {

			Cita newCita = cit.get();

			if (Objects.nonNull(cita.getMotivoCita()) && !"".equalsIgnoreCase(cita.getMotivoCita())) {
				newCita.setMotivoCita(cita.getMotivoCita());
			}

			if (Objects.nonNull(cita.getFechaHora())) {
				newCita.setFechaHora(cita.getFechaHora());
			}

			if (Objects.nonNull(cita.getAttribute11())) {
				newCita.setAttribute11(cita.getAttribute11());
			}

			return citaRepository.save(newCita);
		}

		return null;
	}

	@Override
	public CitaDTO saveCita(Cita cita) {
		
		Optional<Paciente> paciente = pacienteRepository.findById(cita.getPaciente().getUsuarioId());
		if (paciente.isPresent()) {
			cita.setPaciente(paciente.get());
		}
		else {
			return null;
		}
		
		Optional<Medico> medico = medicoRepository.findById(cita.getMedico().getUsuarioId());
		if (medico.isPresent()) {
			cita.setMedico(medico.get());
		}
		else {
			return null;
		}
		
		Optional<Diagnostico> diagnostico= Optional.ofNullable(null);
		
		if(cita.getDiagnostico().getDiagnosticoId()!=null) {
			diagnostico = diagnosticoRepository.findById(cita.getDiagnostico().getDiagnosticoId());
		}
		if (diagnostico.isPresent()) {
			cita.setDiagnostico(diagnostico.get());
		}
		else {
			
			Diagnostico diagnostico2 = cita.getDiagnostico();
			diagnostico2.setCita(cita);
			cita.setDiagnostico(diagnostico2);
		
		}
		
		Medico med = medico.get();
		LinkedList<Paciente> pac = new LinkedList<>( med.getPacientes());
		pac.add(paciente.get());
		med.setPacientes(pac);
		medicoRepository.save(med);
		
		
		return  citaMapper.CitaToCitaDTO(citaRepository.save(cita));
	}
}
