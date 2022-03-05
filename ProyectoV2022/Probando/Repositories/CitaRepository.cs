using ServicioMedico.Data;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class CitaRepository : EFCoreRepository<Cita, DataContext>
    {

        public CitaRepository(DataContext context) : base(context)
        {
        }
    }
}
