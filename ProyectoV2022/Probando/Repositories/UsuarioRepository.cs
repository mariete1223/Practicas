using ServicioMedico.Data;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class UsuarioRepository : EFCoreRepository<Usuario, DataContext>
    {
        public UsuarioRepository(DataContext context) : base(context)
        {
        }
    }
}
