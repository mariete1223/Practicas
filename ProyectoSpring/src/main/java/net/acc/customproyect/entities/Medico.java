package net.acc.customproyect.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "MEDICO")
@PrimaryKeyJoinColumn( name="medico_id")
public class Medico extends Usuario {
	@Column(name = "numColegio")
	private String numColegio;
	
	/*@Column( name="pacientes")*/
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
			name="medico_paciente",
			joinColumns =  @JoinColumn(
					name="medico",
					referencedColumnName = "medico_id"
					),
			inverseJoinColumns = @JoinColumn(
					name="paciente",
					referencedColumnName = "paciente_id"
					)
	)
	private List<Paciente> pacientes;
	
	/*@Column( name= "citas")*/
	@OneToMany(
			mappedBy = "medico"
			)
	private List<Cita> citas;
	
	

	public Medico() {
		super();
	}

	public Medico(String nombre, String apellidos, String usuario, String clave, String numColegio,
			List<Paciente> pacientes, List<Cita> citas) {
		super(nombre, apellidos, usuario, clave);
		this.numColegio = numColegio;
		this.pacientes = pacientes;
		this.citas = citas;
	}

	public String getNumColegio() {
		return numColegio;
	}

	public void setNumColegio(String numColegio) {
		this.numColegio = numColegio;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}
