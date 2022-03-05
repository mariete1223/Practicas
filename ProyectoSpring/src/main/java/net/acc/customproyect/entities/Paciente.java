package net.acc.customproyect.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PACIENTE")
@PrimaryKeyJoinColumn( name="paciente_id")
public class Paciente extends Usuario {

	@Column(name = "NSS")
	private String NSS;
	@Column(name ="numTarjeta")
	private String numTarjeta;
	@Column( name="telefono")
	private String telefono;
	@Column( name="direccion")
	private String direccion;
	/*@Column(name ="medicos")*/
	@ManyToMany(
		mappedBy = "pacientes", fetch = FetchType.LAZY
			)
	private List<Medico> medicos;
	/*@Column(name="citas")*/
	@OneToMany(
			mappedBy = "paciente"
				)
	private List<Cita> citas;
	
	

	public Paciente() {
		super();
	}

	public Paciente(String nombre, String apellidos, String usuario, String clave, String nSS, String numTarjeta,
			String telefono, String direccion, List<Cita> citas, List<Medico> medicos) {
		super(nombre, apellidos, usuario, clave);
		NSS = nSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
		NSS = nSS;
		this.citas = citas;
		this.medicos = medicos;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}
