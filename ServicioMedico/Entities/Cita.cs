using ServicioMedico.Data;

namespace ServicioMedico.Entities
{
    public class Cita : IEntity
    {
        [Key]
        public long Id { get; set; }

        [DataType(DataType.Date)]
        [Required]
        public DateTime fechaHora1 { get; set; }

        [Required]
        [StringLength(50)]
        public string motivoCita { get; set; }
        
        [Required]
        public int attribute11 { get; set; }

        public virtual Diagnostico diagnostico { get; set; }  
        
        public long diagnosticoFKId { get; set; }
        
        public virtual Medico medico { get; set; }

        public long medicoFKId { get; set; }

        public virtual Paciente paciente { get; set; }
        
        public long pacienteFKId { get; set; }


    }
}
