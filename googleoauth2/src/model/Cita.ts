import diagnosticoDTO from "./DiagnosticoDTO";
import medicoDTO from "./MedicoDTO";
import pacienteDTO from "./PacienteDTO";

interface cita {
    citaId: ConstrainULong,
    fechaHora: Date,
    motivoCita: string,
    attribute11: number,
    paciente: pacienteDTO,
    medico: medicoDTO,
    diagnostico: diagnosticoDTO,

}

export default cita;