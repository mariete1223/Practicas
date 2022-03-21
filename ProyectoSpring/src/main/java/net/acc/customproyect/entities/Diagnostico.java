package net.acc.customproyect.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "Diagnostico" )
public class Diagnostico {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "diagnostico_id")
	private Long diagnosticoId;
	
	@Column( name = "valoracionEspecialista")
	private String valoracionEspecialista;
	
	@Column( name = "enfermedad")
	private String enfermedad;
	
	/*@Column( name = "cita"  )*/
	@OneToOne(
			mappedBy = "diagnostico"
			)
	@JoinColumn 
			
	
	private Cita cita;
	
	

	public Diagnostico() {
		super();
	}


	public Diagnostico(String valoracionEspecialista, String enfermedad, Cita cita) {
		this.valoracionEspecialista=valoracionEspecialista;
		this.enfermedad=enfermedad;
		this.cita=cita;
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


	public Cita getCita() {
		return cita;
	}


	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	

}
