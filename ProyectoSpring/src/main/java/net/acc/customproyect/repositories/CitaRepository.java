package net.acc.customproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.acc.customproyect.entities.Cita;

@Repository
public interface CitaRepository  extends JpaRepository<Cita, Long>{
	
}
