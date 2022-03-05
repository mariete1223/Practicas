global using ServicioMedico.Data;
using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.Repositories;

namespace ServicioMedico.ServiceImpl
{
    public class CitaService : ServiceAbstract<CitaDTO, CitaRepository, Cita>
    {
        public CitaService(IMapper mapper, CitaRepository repository) : base(mapper, repository)
        {
        }
    }
}
