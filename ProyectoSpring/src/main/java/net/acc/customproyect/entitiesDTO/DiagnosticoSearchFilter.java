package net.acc.customproyect.entitiesDTO;

public class DiagnosticoSearchFilter {
	
	private Long diagnosticoId;
	private String valoracionEspecialista;
	private String enfermedad;
	private CitaDTO cita;

	
	
	public Long getDiagnosticoId() {
		return diagnosticoId;
	}

	public void setDiagnosticoId(Long diagnosticoId) {
		this.diagnosticoId = diagnosticoId;
	}

	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}

	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public CitaDTO getCita() {
		return cita;
	}

	public void setCita(CitaDTO cita) {
		this.cita = cita;
	}
	
	
	
	
}
