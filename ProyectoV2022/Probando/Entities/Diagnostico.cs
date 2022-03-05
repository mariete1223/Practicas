global using System.ComponentModel.DataAnnotations;
using ServicioMedico.Data;

namespace ServicioMedico.Entities
{
    public class Diagnostico : IEntity
    {
        [Key]
        public long Id { get; set; }

        [Required]
        [StringLength(50)]
        public string valoracionEspedialista { get; set; }

        [Required]
        [StringLength(30)]
        public string enfermedad { get; set; }

        public virtual Cita cita { get; set; }

    }
}
