package net.acc.customproyect.service;

import java.util.List;
import java.util.Optional;

import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entities.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAllUsuario();
	public Optional<Usuario> getUsuarioById(Long id);
	public void deleteUsuarioById(Long usuario);
	public Usuario saveUsuario(Usuario usuario);
	public Usuario updateUsuario(Long usuarioId, Usuario usuario);
}
