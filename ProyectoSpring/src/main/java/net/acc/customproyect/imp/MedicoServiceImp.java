package net.acc.customproyect.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entitiesDTO.MedicoSearchFilter;
import net.acc.customproyect.mapper.MedicoMapper;
import net.acc.customproyect.repositories.MedicoRepository;
import net.acc.customproyect.service.MedicoService;
import net.acc.customproyect.service.UsuarioService;

@Service
public class MedicoServiceImp implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired 
	private MedicoMapper medicoMapper;

	@Autowired
	UsuarioService usuarioservice;

	@Override
	public List<MedicoSearchFilter> findAllMedico() {
		return medicoMapper.MedicoListToMedicoSearchFilterDTOList(medicoRepository.findAll());
	}

	@Override
	public MedicoSearchFilter getMedicoById(Long id) {
		Optional<Medico> medico = medicoRepository.findById(id);
		if(medico.isPresent()) {
			return medicoMapper.MedicoToMedicoSearchFilterDTO(medico.get());
		}
		return null;
		
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
	public MedicoSearchFilter updateMedico(Long medicoId, MedicoSearchFilter medico) {
		Optional<Medico> med = medicoRepository.findById(medicoId);
		if (med.isPresent()) {

			Medico newMedico = med.get();

			usuarioservice.updateUsuario(medicoId, medico);

			if (Objects.nonNull(medico.getNumColegio()) && !"".equalsIgnoreCase(medico.getNumColegio())) {
				newMedico.setNumColegio(medico.getNumColegio());
			}

			return medicoMapper.MedicoToMedicoSearchFilterDTO(medicoRepository.save(newMedico));
		}
		return null; // throw exception
	}

	@Override
	public MedicoSearchFilter saveMedico(MedicoSearchFilter medico) {
		// TODO Auto-generated method stub
		return medicoMapper.MedicoToMedicoSearchFilterDTO(medicoRepository.save(medicoMapper.MedicoSearchFilterDTOToMedico(medico)));
	}
}
