package net.acc.customproyect.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.repositories.DiagnosticoRepository;
import net.acc.customproyect.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImp implements DiagnosticoService {

	@Autowired
	private DiagnosticoRepository diagnosticoRepository;

	@Override
	public List<Diagnostico> findAllDiagnostico() {

		return diagnosticoRepository.findAll();
	}

	@Override
	public Optional<Diagnostico> getDiagnosticoById(Long id) {

		return diagnosticoRepository.findById(id);

	}

	@Override
	public void deleteDiagnisticoById(Long diagnostico) {
		diagnosticoRepository.deleteById(diagnostico);

	}

	@Override
	public Diagnostico updateDiagnostico(Long diagnosticoId, Diagnostico diagnostico) {
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

			return diagnosticoRepository.save(newDiagnostico);
		}
		return null;
	}

	@Override
	public Diagnostico saveDiagnostico(Diagnostico diagnostico) {
		// TODO Auto-generated method stub
		return diagnosticoRepository.save(diagnostico);
	}
}
