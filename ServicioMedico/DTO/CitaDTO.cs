using ServicioMedico.Entities;

namespace ServicioMedico.DTO
{
    public class CitaDTO
    {

        public long Id { get; set; }

        public DateTime fechaHora1 { get; set; }

        public string motivoCita { get; set; }

        [Required]
        public int attribute11 { get; set; }

        public virtual DiagnosticoSearchFilter diagnostico { get; set; }

        public virtual MedicoSearchFilter medico { get; set; }

        public virtual PacienteSearchFilter paciente { get; set; }

    }
}
