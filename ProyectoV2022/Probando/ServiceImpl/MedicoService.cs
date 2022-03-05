using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.Repositories;

namespace ServicioMedico.ServiceImpl
{
    public class MedicoService : ServiceAbstract<MedicoDTO, MedicoRepository, Medico>
    {
        public MedicoService(IMapper mapper, MedicoRepository repository) : base(mapper, repository)
        {
        }
    }
}
