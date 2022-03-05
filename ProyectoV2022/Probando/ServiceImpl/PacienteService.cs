using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.Repositories;

namespace ServicioMedico.ServiceImpl
{
    public class PacienteService : ServiceAbstract<PacienteDTO, PacienteRepository, Paciente>
    {
        public PacienteService(IMapper mapper, PacienteRepository repository) : base(mapper, repository)
        {
        }
    }
}
