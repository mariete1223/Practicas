using ServicioMedico.DTO;
using ServicioMedico.Entities;

namespace ServicioMedico.Mapper
{
    public class MedicoMapper : Profile
    {
        public MedicoMapper()
        {
            CreateMap<MedicoDTO, Medico>();
            CreateMap<Medico, MedicoDTO>();
            CreateMap<MedicoSearchFilter, Medico>();
            CreateMap<Medico, MedicoSearchFilter>();
        }
    }
}
