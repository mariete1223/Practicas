package net.acc.customproyect.entitiesDTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import net.acc.customproyect.entities.Medico;

public class PacienteDTO extends UsuarioDTO{
	
	/*private UsuarioDTO usuario;*/
	private String NSS;
	private String numTarjeta;
	private String telefono;
	private String direccion;
	
	

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
	
	

}
