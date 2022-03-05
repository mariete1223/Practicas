package net.acc.customproyect.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import net.acc.customproyect.entities.Usuario;
import net.acc.customproyect.entitiesDTO.UsuarioDTO;


@Mapper(componentModel="spring")
public interface UsuarioMapper {
	
	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	

	UsuarioDTO UsuarioToUsuarioDto(Usuario Usuario);
	
	
	Usuario UsuarioDTOToUsuario(UsuarioDTO UsuarioDTO);
}