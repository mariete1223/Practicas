package net.acc.customproyect.imp;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entities.Usuario;
import net.acc.customproyect.entitiesDTO.UsuarioDTO;
import net.acc.customproyect.mapper.MedicoMapper;
import net.acc.customproyect.mapper.PacienteMapper;
import net.acc.customproyect.mapper.UsuarioMapper;
import net.acc.customproyect.repositories.UsuarioRepository;
import net.acc.customproyect.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	private PacienteMapper pacienteMapper;
	
	@Autowired
	private MedicoMapper medicoMapper;

	@Override
	public List<UsuarioDTO> findAllUsuario() {
		List<Usuario> usuarios=usuarioRepository.findAll();
		usuarios.forEach((e) -> System.out.println((e instanceof Paciente)+"\n\n"));
		
		List<UsuarioDTO> fin= new LinkedList<UsuarioDTO>(); 
		
		usuarios.stream().forEach((e) ->{
							if(e instanceof Paciente) {
								fin.add(pacienteMapper.PacienteToPacienteDto((Paciente)e));
							}
							else if(e instanceof Medico) {
								fin.add(medicoMapper.MedicoToMedicoDTO((Medico)e));
							}
							else {
								fin.add(usuarioMapper.UsuarioToUsuarioDTO(e));
							}
								
							
		});
		return fin;
	}

	@Override
	public UsuarioDTO getUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			
			return usuarioMapper.UsuarioToUsuarioDTO(usuario.get());
		}
		return null;

	}

	@Override
	public void deleteUsuarioById(Long usuario) {
		usuarioRepository.deleteById(usuario);

	}

	@Override
	public UsuarioDTO updateUsuario(Long usuarioId, UsuarioDTO usuario) {
		Optional<Usuario> user = usuarioRepository.findById(usuarioId);
		if (user.isPresent()) {

			Usuario newUser = user.get();

			if (Objects.nonNull(usuario.getNombre()) && !"".equalsIgnoreCase(usuario.getNombre())) {
				newUser.setNombre(usuario.getNombre());
			}

			if (Objects.nonNull(usuario.getApellidos()) && !"".equalsIgnoreCase(usuario.getApellidos())) {
				newUser.setApellidos(usuario.getApellidos());
			}

			if (Objects.nonNull(usuario.getEmail()) && !"".equalsIgnoreCase(usuario.getEmail())) {
				newUser.setEmail(usuario.getEmail());
			}

			return usuarioMapper.UsuarioToUsuarioDTO(usuarioRepository.save(newUser));
		}
		return null; // throw exception
	}

	@Override
	public UsuarioDTO saveUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return usuarioMapper.UsuarioToUsuarioDTO(usuarioRepository.save( usuarioMapper.UsuarioDTOToUsuario(usuario)));
	}

	@Override
	public UsuarioDTO getUsuarioByName(String name) {
		return usuarioMapper.UsuarioToUsuarioDTO(usuarioRepository.findByNombre(name));
	}
}
