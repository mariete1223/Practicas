package net.acc.customproyect.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entitiesDTO.PacienteSearchFilter;
import net.acc.customproyect.mapper.PacienteMapper;
import net.acc.customproyect.repositories.PacienteRepository;
import net.acc.customproyect.service.PacienteService;
import net.acc.customproyect.service.UsuarioService;

@Service
public class PacienteServiceImp implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	/* Duda */
	@Autowired
	UsuarioService usuarioservice;
	
	@Autowired
	private PacienteMapper pacienteMapper;

	@Override
	public List<PacienteSearchFilter> findAllPaciente() {
		return pacienteMapper.pacienteListToPacienteSearchFilterDTOList(pacienteRepository.findAll());
	}

	@Override
	public PacienteSearchFilter getPacienteById(Long id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		
		if(paciente.isPresent()) {
			return pacienteMapper.PacienteToPacienteSearchFilterDTO(paciente.get());
		}
		
		return null;

	}

	@Override
	public void deletePacienteById(Long paciente) {
		pacienteRepository.deleteById(paciente);
	}

	@Override
	public PacienteSearchFilter updatePaciente(Long pacienteId, PacienteSearchFilter paciente) {
		Optional<Paciente> pac = pacienteRepository.findById(pacienteId);
		if (pac.isPresent()) {

			Paciente newPaciente = pac.get();

			usuarioservice.updateUsuario(pacienteId, paciente);

			if (Objects.nonNull(paciente.getNSS()) && !"".equalsIgnoreCase(paciente.getNSS())) {
				newPaciente.setNSS(paciente.getNSS());
			}

			if (Objects.nonNull(paciente.getDireccion()) && !"".equalsIgnoreCase(paciente.getDireccion())) {
				newPaciente.setDireccion(paciente.getDireccion());
			}

			if (Objects.nonNull(paciente.getNumTarjeta()) && !"".equalsIgnoreCase(paciente.getNumTarjeta())) {
				newPaciente.setNumTarjeta(paciente.getNumTarjeta());
			}

			if (Objects.nonNull(paciente.getTelefono()) && !"".equalsIgnoreCase(paciente.getTelefono())) {
				newPaciente.setTelefono(paciente.getTelefono());
			}

			return pacienteMapper.PacienteToPacienteSearchFilterDTO(pacienteRepository.save(newPaciente));
		}
		return null;
	}

	@Override
	public PacienteSearchFilter savePaciente(PacienteSearchFilter paciente) {
		// TODO Auto-generated method stub
		return pacienteMapper.PacienteToPacienteSearchFilterDTO(pacienteRepository.save(pacienteMapper.PacienteSearchFilterDTOToPaciente(paciente)));
	}
}
