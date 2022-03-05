namespace ServicioMedico.DTO
{
    public class PacienteSearchFilter : UsuarioDTO
    {

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

    }
}
