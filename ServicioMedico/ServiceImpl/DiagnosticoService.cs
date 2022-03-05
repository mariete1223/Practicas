using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.Repositories;

namespace ServicioMedico.ServiceImpl
{
    public class DiagnosticoService : ServiceAbstract<DiagnosticoDTO, DiagnosticoRepository, Diagnostico>
    {
        private DiagnosticoRepository _repository;
        private IMapper _mapper;
        public DiagnosticoService(IMapper mapper, DiagnosticoRepository repository) : base(mapper, repository)
        {
            _repository = repository;
            _mapper=mapper;
        }
        public async Task<DiagnosticoDTO> createExistente(DiagnosticoDTO diagnostico)
        {
            return _mapper.Map<DiagnosticoDTO>(await _repository.createDiag(_mapper.Map<Diagnostico>(diagnostico)));
        }
        
    }
}
