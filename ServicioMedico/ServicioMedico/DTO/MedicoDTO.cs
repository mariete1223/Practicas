namespace ServicioMedico.DTO
{
    public class MedicoDTO : UsuarioDTO
    {
        public string numColegio { get; set; }

        public virtual List<CitaDTO> citas { get; set; }

        public virtual List<PacienteSearchFilter> pacientes { get; set; }
    }
}
