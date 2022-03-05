using Microsoft.EntityFrameworkCore;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class DataContext : DbContext
    {
        
        public DataContext(DbContextOptions<DataContext> options) : base(options) {
            
        }

        public DbSet<Usuario> UsuarioDB { get; set; }
        public DbSet<Medico> MedicoDB { get; set; }
        public DbSet<Paciente> PacienteDB { get; set; }
        public DbSet<Diagnostico> Diagnostico { get; set; }
        public DbSet<Cita> Cita { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {

            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<Usuario>().ToTable("Usuario");

            modelBuilder.Entity<Medico>().ToTable("Medico");

            modelBuilder.Entity<Paciente>().ToTable("Paciente");

            modelBuilder.Entity<Cita>().HasOne(cita => cita.diagnostico)
                                              .WithOne(diagnostico => diagnostico.cita)
                                              .HasForeignKey<Cita>(a => a.diagnosticoFKId);
            

            modelBuilder.Entity<Cita>().HasOne<Medico>(cita => cita.medico)
                                       .WithMany(medico => medico.citas)
                                       .HasForeignKey(a => a.medicoFKId);

            modelBuilder.Entity<Cita>().HasOne<Paciente>( cita => cita.paciente)
                                       .WithMany(paciente => paciente.citas)
                                       .HasForeignKey(cita => cita.pacienteFKId);

            modelBuilder.Entity<Medico>()
                        .HasMany<Paciente>(m => m.pacientes)
                        .WithMany(p => p.medicos);
            

        }


      

    }
}
