import cita from './Cita';
import pacienteDTO from './PacienteDTO';
import usuario from './UsuarioDTO';

interface medico extends usuario {

	numColegio: string,
	pacientes: pacienteDTO[],
	citas: cita[],

}

export default medico;