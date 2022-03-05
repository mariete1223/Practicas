package net.acc.customproyect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Medico;

public interface MedicoRepository  extends JpaRepository<Medico, Long>{
	
}
