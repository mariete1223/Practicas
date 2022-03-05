package net.acc.customproyect.imp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Usuario;
import net.acc.customproyect.repositories.UsuarioRepository;
import net.acc.customproyect.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAllUsuario() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> getUsuarioById(Long id) {
		return usuarioRepository.findById(id);

	}

	@Override
	public void deleteUsuarioById(Long usuario) {
		usuarioRepository.deleteById(usuario);

	}

	@Override
	public Usuario updateUsuario(Long usuarioId, Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findById(usuarioId);
		if (user.isPresent()) {

			Usuario newUser = user.get();

			if (Objects.nonNull(usuario.getNombre()) && !"".equalsIgnoreCase(usuario.getNombre())) {
				newUser.setNombre(usuario.getNombre());
			}

			if (Objects.nonNull(usuario.getApellidos()) && !"".equalsIgnoreCase(usuario.getApellidos())) {
				newUser.setApellidos(usuario.getApellidos());
			}

			if (Objects.nonNull(usuario.getClave()) && !"".equalsIgnoreCase(usuario.getClave())) {
				newUser.setClave(usuario.getClave());
			}

			if (Objects.nonNull(usuario.getUsuario()) && !"".equalsIgnoreCase(usuario.getUsuario())) {
				newUser.setUsuario(usuario.getUsuario());
			}

			return usuarioRepository.save(newUser);
		}
		return null; // throw exception
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}
}
