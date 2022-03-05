package net.acc.customproyect.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entities.Usuario;
import net.acc.customproyect.entitiesDTO.UsuarioDTO;
import net.acc.customproyect.mapper.UsuarioMapper;
import net.acc.customproyect.service.MedicoService;
import net.acc.customproyect.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@PostMapping("/usuarios")
	public Usuario saveUsuario(@RequestBody UsuarioDTO usuario) {
		return usuarioService.saveUsuario(usuarioMapper.UsuarioDTOToUsuario(usuario));
	}
	
	@GetMapping("/usuarios")
	public List<UsuarioDTO> fetchUsuarioList() {
		return usuarioService.findAllUsuario().stream()
											.map((e) -> usuarioMapper.UsuarioToUsuarioDto(e))
											.collect(Collectors.toList());
	}

	@GetMapping("/usuarios/{id}")
	public UsuarioDTO fetchUsuarioById(@PathVariable("id") Long medicoId) {
		Optional<Usuario> usuario = usuarioService.getUsuarioById(medicoId);

		if (!usuario.isPresent()) {
			return null;// throw exception
		} else {
			return usuarioMapper.UsuarioToUsuarioDto(usuario.get());
		}
	}

	@DeleteMapping("/usuarios/{id}")
	public String deleteUsuarioById(@PathVariable("id") Long usuarioId) {
		usuarioService.deleteUsuarioById(usuarioId);
		return "deleted succesfully";
	}


	@PutMapping("/usuarios/{id}")
	public Usuario updateUsuarioById(@PathVariable("id") Long usuarioId, @RequestBody Usuario usuario) {
		return usuarioService.updateUsuario(usuarioId, usuario);
	}
}
