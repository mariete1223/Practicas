using ServicioMedico.DTO;
using ServicioMedico.Entities;

namespace ServicioMedico.Mapper
{
    public class PacienteMapper : Profile
    {
        public PacienteMapper()
        {
            CreateMap<PacienteDTO, Paciente>();
            CreateMap<Paciente, PacienteDTO>();
            CreateMap<PacienteSearchFilter, Paciente>();
            CreateMap<Paciente, PacienteSearchFilter>();
        }
    }
}
