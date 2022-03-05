namespace ServicioMedico.Entities
{
    public class Paciente : Usuario
    {
        [Required]
        [StringLength(11)]
        public string NSS { get; set; }

        [Required]
        [StringLength(16)]
        public string numTarjeta { get; set; }

        [Required]
        [StringLength(15)]
        public string telefono { get; set; }

        [Required]
        [StringLength(30)]
        public string direccion { get; set; }

        public virtual List<Medico> medicos { get; set; }

        public virtual List<Cita> citas { get; set; }    

    }
}
