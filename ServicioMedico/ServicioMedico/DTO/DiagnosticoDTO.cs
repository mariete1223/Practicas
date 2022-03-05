namespace ServicioMedico.DTO
{
    public class DiagnosticoDTO
    {
        public long Id { get; set; }

        public string valoracionEspedialista { get; set; }

        public string enfermedad { get; set; }

        public virtual CitaDTO cita { get; set; }
    }
}
