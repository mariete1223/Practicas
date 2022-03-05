using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.Repositories;

namespace ServicioMedico.ServiceImpl
{
    public class UsuarioService : ServiceAbstract<UsuarioDTO, UsuarioRepository, Usuario>
    {
        public UsuarioService(IMapper mapper, UsuarioRepository repository) : base(mapper, repository)
        {
        }
    }
}
