using ServicioMedico.Data;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class MedicoRepository : EFCoreRepository<Medico, DataContext>
    {
        public MedicoRepository(DataContext context) : base(context)
        {
        }
    }
}
