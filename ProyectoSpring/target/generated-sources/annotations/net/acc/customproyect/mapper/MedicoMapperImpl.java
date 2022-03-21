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
import net.acc.customproyect.entitiesDTO.MedicoSearchFilter;
import net.acc.customproyect.entitiesDTO.PacienteDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-21T16:53:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class MedicoMapperImpl implements MedicoMapper {

    @Override
    public MedicoSearchFilter MedicoToMedicoSearchFilterDTO(Medico medico) {
        if ( medico == null ) {
            return null;
        }

        MedicoSearchFilter medicoSearchFilter = new MedicoSearchFilter();

        medicoSearchFilter.setUsuarioId( medico.getUsuarioId() );
        medicoSearchFilter.setNombre( medico.getNombre() );
        medicoSearchFilter.setApellidos( medico.getApellidos() );
        medicoSearchFilter.setUsuario( medico.getUsuario() );
        medicoSearchFilter.setClave( medico.getClave() );
        medicoSearchFilter.setNumColegio( medico.getNumColegio() );
        medicoSearchFilter.setPacientes( pacienteListToPacienteDTOList( medico.getPacientes() ) );
        medicoSearchFilter.setCitas( citaListToCitaDTOList( medico.getCitas() ) );

        return medicoSearchFilter;
    }

    @Override
    public Medico MedicoSearchFilterDTOToMedico(MedicoSearchFilter medicoDTO) {
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
        medico.setPacientes( pacienteDTOListToPacienteList( medicoDTO.getPacientes() ) );
        medico.setCitas( citaDTOListToCitaList( medicoDTO.getCitas() ) );

        return medico;
    }

    @Override
    public MedicoDTO MedicoToMedicoDTO(Medico medico) {
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

    @Override
    public Medico MedicoDTOToMedico(MedicoDTO medicoDTO) {
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

    @Override
    public List<MedicoSearchFilter> MedicoListToMedicoSearchFilterDTOList(List<Medico> findAll) {
        if ( findAll == null ) {
            return null;
        }

        List<MedicoSearchFilter> list = new ArrayList<MedicoSearchFilter>( findAll.size() );
        for ( Medico medico : findAll ) {
            list.add( MedicoToMedicoSearchFilterDTO( medico ) );
        }

        return list;
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

    protected List<PacienteDTO> pacienteListToPacienteDTOList(List<Paciente> list) {
        if ( list == null ) {
            return null;
        }

        List<PacienteDTO> list1 = new ArrayList<PacienteDTO>( list.size() );
        for ( Paciente paciente : list ) {
            list1.add( pacienteToPacienteDTO( paciente ) );
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
        citaDTO.setMedico( MedicoToMedicoDTO( cita.getMedico() ) );
        citaDTO.setPaciente( pacienteToPacienteDTO( cita.getPaciente() ) );

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

    protected List<Paciente> pacienteDTOListToPacienteList(List<PacienteDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Paciente> list1 = new ArrayList<Paciente>( list.size() );
        for ( PacienteDTO pacienteDTO : list ) {
            list1.add( pacienteDTOToPaciente( pacienteDTO ) );
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
        cita.setMedico( MedicoDTOToMedico( citaDTO.getMedico() ) );
        cita.setPaciente( pacienteDTOToPaciente( citaDTO.getPaciente() ) );

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
