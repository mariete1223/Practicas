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
import net.acc.customproyect.entitiesDTO.PacienteSearchFilter;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-21T16:53:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public PacienteDTO PacienteToPacienteDto(Paciente paciente) {
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

    @Override
    public Paciente PacienteDTOToPaciente(PacienteDTO pacienteDTO) {
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

    @Override
    public PacienteSearchFilter PacienteToPacienteSearchFilterDTO(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        PacienteSearchFilter pacienteSearchFilter = new PacienteSearchFilter();

        pacienteSearchFilter.setUsuarioId( paciente.getUsuarioId() );
        pacienteSearchFilter.setNombre( paciente.getNombre() );
        pacienteSearchFilter.setApellidos( paciente.getApellidos() );
        pacienteSearchFilter.setUsuario( paciente.getUsuario() );
        pacienteSearchFilter.setClave( paciente.getClave() );
        pacienteSearchFilter.setNSS( paciente.getNSS() );
        pacienteSearchFilter.setNumTarjeta( paciente.getNumTarjeta() );
        pacienteSearchFilter.setTelefono( paciente.getTelefono() );
        pacienteSearchFilter.setDireccion( paciente.getDireccion() );
        pacienteSearchFilter.setMedicos( medicoListToMedicoDTOList( paciente.getMedicos() ) );
        pacienteSearchFilter.setCitas( citaListToCitaDTOList( paciente.getCitas() ) );

        return pacienteSearchFilter;
    }

    @Override
    public Paciente PacienteSearchFilterDTOToPaciente(PacienteSearchFilter pacienteDTO) {
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
        paciente.setMedicos( medicoDTOListToMedicoList( pacienteDTO.getMedicos() ) );
        paciente.setCitas( citaDTOListToCitaList( pacienteDTO.getCitas() ) );

        return paciente;
    }

    @Override
    public List<PacienteDTO> pacienteListToPacienteDTOList(List<Paciente> pacientes) {
        if ( pacientes == null ) {
            return null;
        }

        List<PacienteDTO> list = new ArrayList<PacienteDTO>( pacientes.size() );
        for ( Paciente paciente : pacientes ) {
            list.add( PacienteToPacienteDto( paciente ) );
        }

        return list;
    }

    @Override
    public List<PacienteSearchFilter> pacienteListToPacienteSearchFilterDTOList(List<Paciente> pacientes) {
        if ( pacientes == null ) {
            return null;
        }

        List<PacienteSearchFilter> list = new ArrayList<PacienteSearchFilter>( pacientes.size() );
        for ( Paciente paciente : pacientes ) {
            list.add( PacienteToPacienteSearchFilterDTO( paciente ) );
        }

        return list;
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

    protected List<MedicoDTO> medicoListToMedicoDTOList(List<Medico> list) {
        if ( list == null ) {
            return null;
        }

        List<MedicoDTO> list1 = new ArrayList<MedicoDTO>( list.size() );
        for ( Medico medico : list ) {
            list1.add( medicoToMedicoDTO( medico ) );
        }

        return list1;
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

    protected CitaDTO citaToCitaDTO(Cita cita) {
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
        citaDTO.setPaciente( PacienteToPacienteDto( cita.getPaciente() ) );

        return citaDTO;
    }

    protected List<CitaDTO> citaListToCitaDTOList(List<Cita> list) {
        if ( list == null ) {
            return null;
        }

        List<CitaDTO> list1 = new ArrayList<CitaDTO>( list.size() );
        for ( Cita cita : list ) {
            list1.add( citaToCitaDTO( cita ) );
        }

        return list1;
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

    protected List<Medico> medicoDTOListToMedicoList(List<MedicoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Medico> list1 = new ArrayList<Medico>( list.size() );
        for ( MedicoDTO medicoDTO : list ) {
            list1.add( medicoDTOToMedico( medicoDTO ) );
        }

        return list1;
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

    protected Cita citaDTOToCita(CitaDTO citaDTO) {
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
        cita.setPaciente( PacienteDTOToPaciente( citaDTO.getPaciente() ) );

        return cita;
    }

    protected List<Cita> citaDTOListToCitaList(List<CitaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Cita> list1 = new ArrayList<Cita>( list.size() );
        for ( CitaDTO citaDTO : list ) {
            list1.add( citaDTOToCita( citaDTO ) );
        }

        return list1;
    }
}
