package net.acc.customproyect.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
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

	@Override
	public List<Paciente> findAllPaciente() {
		return pacienteRepository.findAll();
	}

	@Override
	public Optional<Paciente> getPacienteById(Long id) {
		return pacienteRepository.findById(id);

	}

	@Override
	public void deletePacienteById(Long paciente) {
		pacienteRepository.deleteById(paciente);
	}

	@Override
	public Paciente updatePaciente(Long pacienteId, Paciente paciente) {
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

			return pacienteRepository.save(newPaciente);
		}
		return null;
	}

	@Override
	public Paciente savePaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(paciente);
	}
}
