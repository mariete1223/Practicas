package net.acc.customproyect.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.repositories.MedicoRepository;
import net.acc.customproyect.service.MedicoService;
import net.acc.customproyect.service.UsuarioService;

@Service
public class MedicoServiceImp implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	UsuarioService usuarioservice;

	@Override
	public List<Medico> findAllMedico() {
		return medicoRepository.findAll();
	}

	@Override
	public Optional<Medico> getMedicoById(Long id) {
		return medicoRepository.findById(id);
	}

	@Override
	public String deleteMedicoById(Long medico) {
		if (medicoRepository.findById(medico).isPresent()) {
			medicoRepository.deleteById(medico);
			return "Se ha eliminado el medico\n";
		}
		return "Medico no existente";
	}

	@Override
	public Medico updateMedico(Long medicoId, Medico medico) {
		Optional<Medico> med = medicoRepository.findById(medicoId);
		if (med.isPresent()) {

			Medico newMedico = med.get();

			usuarioservice.updateUsuario(medicoId, medico);

			if (Objects.nonNull(medico.getNumColegio()) && !"".equalsIgnoreCase(medico.getNumColegio())) {
				newMedico.setNumColegio(medico.getNumColegio());
			}

			return medicoRepository.save(newMedico);
		}
		return null; // throw exception
	}

	@Override
	public Medico saveMedico(Medico medico) {
		// TODO Auto-generated method stub
		return medicoRepository.save(medico);
	}
}
