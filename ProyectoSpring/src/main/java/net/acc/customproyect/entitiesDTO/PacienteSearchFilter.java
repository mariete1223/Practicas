package net.acc.customproyect.entitiesDTO;

import java.util.List;

public class PacienteSearchFilter extends UsuarioDTO{
	
	private String NSS;
	private String numTarjeta;
	private String telefono;
	private String direccion;
	private List<MedicoDTO> medicos;
	private List<CitaDTO> citas;
	
	
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
	
	public List<MedicoDTO> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<MedicoDTO> medicos) {
		this.medicos = medicos;
	}
	public List<CitaDTO> getCitas() {
		return citas;
	}
	public void setCitas(List<CitaDTO> citas) {
		this.citas = citas;
	}
	
	

}
