package net.acc.customproyect.entitiesDTO;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Paciente;

public class MedicoSearchFilter extends UsuarioDTO{
	
	
	/*private UsuarioDTO usuario;*/
	private String numColegio;
	private List<PacienteDTO> pacientes;
	private List<CitaDTO> citas;
	
	

	public String getNumColegio() {
		return numColegio;
	}
	public void setNumColegio(String numColegio) {
		this.numColegio = numColegio;
	}
	public List<PacienteDTO> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<PacienteDTO> pacientes) {
		this.pacientes = pacientes;
	}
	public List<CitaDTO> getCitas() {
		return citas;
	}
	public void setCitas(List<CitaDTO> citas) {
		this.citas = citas;
	}
	
	

}
