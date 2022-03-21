using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.Repositories;

namespace ServicioMedico.ServiceImpl
{
    public class PacienteService : ServiceAbstract<PacienteDTO, PacienteRepository, Paciente>
    {

        private PacienteRepository _repository;
        private IMapper _mapper;
        public PacienteService(IMapper mapper, PacienteRepository repository) : base(mapper, repository)
        {
            _mapper = mapper;
            _repository = repository;
        }

        public async Task<PacienteDTO> create(PacienteDTO paciente)
        {
            return _mapper.Map<PacienteDTO>(await _repository.createPaciente(_mapper.Map<Paciente>(paciente)));
        }


    }
}
