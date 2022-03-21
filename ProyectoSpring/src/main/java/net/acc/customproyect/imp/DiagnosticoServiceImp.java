package net.acc.customproyect.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entitiesDTO.DiagnosticoSearchFilter;
import net.acc.customproyect.mapper.DiagnosticoMapper;
import net.acc.customproyect.repositories.CitaRepository;
import net.acc.customproyect.repositories.DiagnosticoRepository;
import net.acc.customproyect.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImp implements DiagnosticoService{

	@Autowired
	private DiagnosticoRepository diagnosticoRepository;
	
	@Autowired 
	DiagnosticoMapper diagnosticoMapper;

	@Override
	public List<DiagnosticoSearchFilter> findAllDiagnostico() {

		return diagnosticoMapper.DiagnosticoSListToDiagnosticoSearchFilterList(diagnosticoRepository.findAll());
	}

	@Override
	public DiagnosticoSearchFilter getDiagnosticoById(Long id) {
		
		Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
		
		if( diagnostico.isPresent()) {
			return diagnosticoMapper.DiagnosticoToDiagnosticoSearchFilterDTO(diagnostico.get());
		}
		return null;


	}

	@Override
	public void deleteDiagnisticoById(Long diagnostico) {
		diagnosticoRepository.deleteById(diagnostico);

	}

	@Override
	public DiagnosticoSearchFilter updateDiagnostico(Long diagnosticoId, DiagnosticoSearchFilter diagnostico) {
		Optional<Diagnostico> diagn = diagnosticoRepository.findById(diagnosticoId);
		if (diagn.isPresent()) {

			Diagnostico newDiagnostico = diagn.get();

			if (Objects.nonNull(diagnostico.getValoracionEspecialista())
					&& !"".equalsIgnoreCase(diagnostico.getValoracionEspecialista())) {
				newDiagnostico.setValoracionEspecialista(diagnostico.getValoracionEspecialista());
			}

			if (Objects.nonNull(diagnostico.getEnfermedad()) && !"".equalsIgnoreCase(diagnostico.getEnfermedad())) {
				newDiagnostico.setEnfermedad(diagnostico.getEnfermedad());
			}

			return diagnosticoMapper.DiagnosticoToDiagnosticoSearchFilterDTO( diagnosticoRepository.save(newDiagnostico));
		}
		return null;
	}

	@Override
	public DiagnosticoSearchFilter saveDiagnostico(DiagnosticoSearchFilter diagnostico) {
		// TODO Auto-generated method stub
		return diagnosticoMapper.DiagnosticoToDiagnosticoSearchFilterDTO(diagnosticoRepository.save( diagnosticoMapper.DiagnosticoSearchFilterDTOToDiagnostico(diagnostico)));
	}
}
