import cita from "./Cita";

interface diagnosticoDTO {
	diagnosticoId: ConstrainULong,
	valoracionEspecialista,
	enfermedad: string,
	cita: cita,
}

export default diagnosticoDTO;