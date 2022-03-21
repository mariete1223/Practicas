package net.acc.customproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.acc.customproyect.entities.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

}
