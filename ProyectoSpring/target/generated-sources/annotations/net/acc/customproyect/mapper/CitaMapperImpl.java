package net.acc.customproyect.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.acc.customproyect.entities.Cita;
import net.acc.customproyect.entities.Diagnostico;
import net.acc.customproyect.entities.Medico;
import net.acc.customproyect.entities.Paciente;
import net.acc.customproyect.entitiesDTO.CitaDTO;
import net.acc.customproyect.entitiesDTO.DiagnosticoDTO;
import net.acc.customproyect.entitiesDTO.MedicoDTO;
import net.acc.customproyect.entitiesDTO.PacienteDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-25T17:37:39+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class CitaMapperImpl implements CitaMapper {

    @Override
    public CitaDTO CitaToCitaDTO(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        CitaDTO citaDTO = new CitaDTO();

        citaDTO.setCitaId( cita.getCitaId() );
        citaDTO.setFechaHora( cita.getFechaHora() );
        citaDTO.setMotivoCita( cita.getMotivoCita() );
        citaDTO.setAttribute11( cita.getAttribute11() );
        citaDTO.setDiagnostico( diagnosticoToDiagnosticoDTO( cita.getDiagnostico() ) );
        citaDTO.setMedico( medicoToMedicoDTO( cita.getMedico() ) );
        citaDTO.setPaciente( pacienteToPacienteDTO( cita.getPaciente() ) );

        return citaDTO;
    }

    @Override
    public Cita CitaDTOToCita(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Cita cita = new Cita();

        cita.setCitaId( citaDTO.getCitaId() );
        cita.setFechaHora( citaDTO.getFechaHora() );
        cita.setMotivoCita( citaDTO.getMotivoCita() );
        cita.setAttribute11( citaDTO.getAttribute11() );
        cita.setDiagnostico( diagnosticoDTOToDiagnostico( citaDTO.getDiagnostico() ) );
        cita.setMedico( medicoDTOToMedico( citaDTO.getMedico() ) );
        cita.setPaciente( pacienteDTOToPaciente( citaDTO.getPaciente() ) );

        return cita;
    }

    @Override
    public List<Cita> citaDTOListToCitaList(List<CitaDTO> citasDTO) {
        if ( citasDTO == null ) {
            return null;
        }

        List<Cita> list = new ArrayList<Cita>( citasDTO.size() );
        for ( CitaDTO citaDTO : citasDTO ) {
            list.add( CitaDTOToCita( citaDTO ) );
        }

        return list;
    }

    @Override
    public List<CitaDTO> citaListToCitaDTOList(List<Cita> citasDTO) {
        if ( citasDTO == null ) {
            return null;
        }

        List<CitaDTO> list = new ArrayList<CitaDTO>( citasDTO.size() );
        for ( Cita cita : citasDTO ) {
            list.add( CitaToCitaDTO( cita ) );
        }

        return list;
    }

    protected DiagnosticoDTO diagnosticoToDiagnosticoDTO(Diagnostico diagnostico) {
        if ( diagnostico == null ) {
            return null;
        }

        DiagnosticoDTO diagnosticoDTO = new DiagnosticoDTO();

        diagnosticoDTO.setDiagnosticoId( diagnostico.getDiagnosticoId() );
        diagnosticoDTO.setValoracionEspecialista( diagnostico.getValoracionEspecialista() );
        diagnosticoDTO.setEnfermedad( diagnostico.getEnfermedad() );

        return diagnosticoDTO;
    }

    protected MedicoDTO medicoToMedicoDTO(Medico medico) {
        if ( medico == null ) {
            return null;
        }

        MedicoDTO medicoDTO = new MedicoDTO();

        medicoDTO.setUsuarioId( medico.getUsuarioId() );
        medicoDTO.setNombre( medico.getNombre() );
        medicoDTO.setApellidos( medico.getApellidos() );
        medicoDTO.setUsuario( medico.getUsuario() );
        medicoDTO.setClave( medico.getClave() );
        medicoDTO.setNumColegio( medico.getNumColegio() );

        return medicoDTO;
    }

    protected PacienteDTO pacienteToPacienteDTO(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        PacienteDTO pacienteDTO = new PacienteDTO();

        pacienteDTO.setUsuarioId( paciente.getUsuarioId() );
        pacienteDTO.setNombre( paciente.getNombre() );
        pacienteDTO.setApellidos( paciente.getApellidos() );
        pacienteDTO.setUsuario( paciente.getUsuario() );
        pacienteDTO.setClave( paciente.getClave() );
        pacienteDTO.setNSS( paciente.getNSS() );
        pacienteDTO.setNumTarjeta( paciente.getNumTarjeta() );
        pacienteDTO.setTelefono( paciente.getTelefono() );
        pacienteDTO.setDireccion( paciente.getDireccion() );

        return pacienteDTO;
    }

    protected Diagnostico diagnosticoDTOToDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        if ( diagnosticoDTO == null ) {
            return null;
        }

        Diagnostico diagnostico = new Diagnostico();

        diagnostico.setDiagnosticoId( diagnosticoDTO.getDiagnosticoId() );
        diagnostico.setValoracionEspecialista( diagnosticoDTO.getValoracionEspecialista() );
        diagnostico.setEnfermedad( diagnosticoDTO.getEnfermedad() );

        return diagnostico;
    }

    protected Medico medicoDTOToMedico(MedicoDTO medicoDTO) {
        if ( medicoDTO == null ) {
            return null;
        }

        Medico medico = new Medico();

        medico.setUsuarioId( medicoDTO.getUsuarioId() );
        medico.setNombre( medicoDTO.getNombre() );
        medico.setApellidos( medicoDTO.getApellidos() );
        medico.setUsuario( medicoDTO.getUsuario() );
        medico.setClave( medicoDTO.getClave() );
        medico.setNumColegio( medicoDTO.getNumColegio() );

        return medico;
    }

    protected Paciente pacienteDTOToPaciente(PacienteDTO pacienteDTO) {
        if ( pacienteDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setUsuarioId( pacienteDTO.getUsuarioId() );
        paciente.setNombre( pacienteDTO.getNombre() );
        paciente.setApellidos( pacienteDTO.getApellidos() );
        paciente.setUsuario( pacienteDTO.getUsuario() );
        paciente.setClave( pacienteDTO.getClave() );
        paciente.setNSS( pacienteDTO.getNSS() );
        paciente.setNumTarjeta( pacienteDTO.getNumTarjeta() );
        paciente.setTelefono( pacienteDTO.getTelefono() );
        paciente.setDireccion( pacienteDTO.getDireccion() );

        return paciente;
    }
}
