import cita from './Cita';
import usuario from './UsuarioDTO';

interface paciente extends usuario {

	NSS: string,
	numTarjeta: string,
	telefono: string,
	direccion: string,
	citas: cita[],
}

export default paciente;