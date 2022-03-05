package net.acc.customproyect.entitiesDTO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.acc.customproyect.entities.Cita;

public class DiagnosticoDTO {
	
	private Long diagnosticoId;
	private String valoracionEspecialista;
	private String enfermedad;
	
	
	
	public DiagnosticoDTO() {
		super();
	}
	
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

	
	
	
	
	

}
