using ServicioMedico.Data;

namespace ServicioMedico.Entities
{
    public class Medico : Usuario
    {
        [Required]
        [StringLength(15)]
        public string numColegio { get; set; }

        public virtual List<Cita> citas { get; set; }

        public virtual List<Paciente> pacientes { get; set; }   
    }
}
