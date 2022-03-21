using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.Repositories;

namespace ServicioMedico.ServiceImpl
{
    public class MedicoService : ServiceAbstract<MedicoDTO, MedicoRepository, Medico>
    {
        private IMapper _mapper;
        private MedicoRepository _repository;
        
        public MedicoService(IMapper mapper, MedicoRepository repository) : base(mapper, repository)
        {
            _mapper = mapper;
            _repository = repository;
        }
        public async Task<MedicoDTO> create(MedicoDTO medico)
        {
            return _mapper.Map<MedicoDTO>(await _repository.createMedico(_mapper.Map<Medico>(medico)));
        }
    }
}
