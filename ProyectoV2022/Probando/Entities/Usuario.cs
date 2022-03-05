using ServicioMedico.Data;
using System.ComponentModel.DataAnnotations;

namespace ServicioMedico.Entities
{
    public class Usuario : IEntity
    {
        [Key]
        public long Id { get; set; }

        [Required]
        [StringLength(15)]
        public string nombre { get; set; }

        [Required]
        [StringLength(25)]
        public string apellidos { get; set; }

        [Required]
        [StringLength(18)]
        public string usuario { get; set; }
        
        [Required]
        [StringLength(20)]
        public string clave { get; set; }

    }
}
