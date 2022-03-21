package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entities.Usuario;
import net.acc.customproyect.entitiesDTO.UsuarioDTO;

public interface UsuarioService {
	
	public List<UsuarioDTO> findAllUsuario();
	public UsuarioDTO getUsuarioById(Long id);
	public void deleteUsuarioById(Long usuario);
	public UsuarioDTO saveUsuario(UsuarioDTO usuario);
	public UsuarioDTO updateUsuario(Long usuarioId, UsuarioDTO usuario);
}
