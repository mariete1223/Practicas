package net.acc.customproyect.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.acc.customproyect.repositories.CitaRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver.Unique;

@Entity
@Table( name = "Cita")
public class Cita {
	

	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "cita_id")
	private Long citaId;
	@Column(name = "fecha_Cita")
	private Date fechaHora;
	@Column(name = "motivoCita")
	private String motivoCita;
	@Column(name = "attribute11")
	private int attribute11;
	
/*	@Column( name="diagnostico" )*/
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (
			name = "diagnostico",
			referencedColumnName = "diagnostico_id"
			)
	private Diagnostico diagnostico;
	/*@Column(name="medico")*/
	@ManyToOne()
	@JoinColumn(
			name="medico",
			referencedColumnName = "medico_id")
	private Medico medico;
	/*@Column(name="paciente")*/
	@ManyToOne()
	@JoinColumn(
			name="paciente",
			referencedColumnName = "paciente_id"
			)
	private Paciente paciente;

	
	
	public Cita() {
		super();
	}

	public Cita(Long citaId, Date fechaHora, String motivoCita, int attribute11, Diagnostico diagnostico, Medico medico,
			Paciente paciente) {
		super();
		this.citaId = citaId;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.attribute11 = attribute11;
		this.diagnostico = diagnostico;
		this.medico = medico;
		this.paciente = paciente;
	}

	public Long getCitaId() {
		return citaId;
	}

	public void setCitaId(Long citaId) {
		this.citaId = citaId;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public int getAttribute11() {
		return attribute11;
	}

	public void setAttribute11(int attribute11) {
		this.attribute11 = attribute11;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
