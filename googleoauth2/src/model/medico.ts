import cita from './Cita';
import medicoDTO from './MedicoDTO';
import pacienteDTO from './PacienteDTO';
import usuario from './UsuarioDTO';

interface medico extends medicoDTO {

	pacientes: pacienteDTO[],
	citas: cita[],

}

export default medico;