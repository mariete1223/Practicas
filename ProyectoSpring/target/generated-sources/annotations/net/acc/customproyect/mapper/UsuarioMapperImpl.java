package net.acc.customproyect.mapper;

import javax.annotation.Generated;
import net.acc.customproyect.entities.Usuario;
import net.acc.customproyect.entitiesDTO.UsuarioDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-25T17:37:39+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO UsuarioToUsuarioDto(Usuario Usuario) {
        if ( Usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setUsuarioId( Usuario.getUsuarioId() );
        usuarioDTO.setNombre( Usuario.getNombre() );
        usuarioDTO.setApellidos( Usuario.getApellidos() );
        usuarioDTO.setUsuario( Usuario.getUsuario() );
        usuarioDTO.setClave( Usuario.getClave() );

        return usuarioDTO;
    }

    @Override
    public Usuario UsuarioDTOToUsuario(UsuarioDTO UsuarioDTO) {
        if ( UsuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setUsuarioId( UsuarioDTO.getUsuarioId() );
        usuario.setNombre( UsuarioDTO.getNombre() );
        usuario.setApellidos( UsuarioDTO.getApellidos() );
        usuario.setUsuario( UsuarioDTO.getUsuario() );
        usuario.setClave( UsuarioDTO.getClave() );

        return usuario;
    }
}
