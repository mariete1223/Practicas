global using ServicioMedico.Data;
using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.Repositories;

namespace ServicioMedico.ServiceImpl
{
    public class CitaService : ServiceAbstract<CitaDTO, CitaRepository, Cita>
    {
        public IMapper _mapper;
        public CitaRepository _repository;

        public CitaService(IMapper mapper, CitaRepository repository) : base(mapper, repository)
        {
            _mapper = mapper;   
            _repository = repository;
        }
        public async Task<CitaDTO> create(CitaDTO cita)
        {
            return _mapper.Map<CitaDTO>(await _repository.createCita(_mapper.Map<Cita>(cita)));
        }
    }
}
