using ServicioMedico.Data;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class PacienteRepository : EFCoreRepository<Paciente, DataContext>
    {
        public PacienteRepository(DataContext context) : base(context)
        {
        }
    }
}
