namespace ServicioMedico.DTO
{
    public class PacienteDTO : UsuarioDTO
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

        public virtual List<MedicoSearchFilter> medicos { get; set; }

        public virtual List<CitaDTO> citas { get; set; }
    }
}
