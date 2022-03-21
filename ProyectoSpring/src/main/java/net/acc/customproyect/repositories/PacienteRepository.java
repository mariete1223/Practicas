package net.acc.customproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.acc.customproyect.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
