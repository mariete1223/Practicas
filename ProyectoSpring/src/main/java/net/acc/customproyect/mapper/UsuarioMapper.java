package net.acc.customproyect.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import net.acc.customproyect.entities.Usuario;
import net.acc.customproyect.entitiesDTO.UsuarioDTO;


@Mapper(componentModel="spring")
public interface UsuarioMapper {
	
	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	

	UsuarioDTO UsuarioToUsuarioDTO(Usuario Usuario);
	List<UsuarioDTO> UsuarioListToUsuarioDTOList(List<Usuario> usuarios);
	
	
	Usuario UsuarioDTOToUsuario(UsuarioDTO UsuarioDTO);
}