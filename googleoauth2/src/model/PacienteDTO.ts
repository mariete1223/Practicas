import usuario from './UsuarioDTO';

interface pacienteDTO extends usuario {

	NSS: string,
	numTarjeta: string,
	telefono: string,
	direccion: string,
}

export default pacienteDTO;