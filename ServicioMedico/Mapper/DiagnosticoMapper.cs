using ServicioMedico.DTO;
using ServicioMedico.Entities;

namespace ServicioMedico.Mapper
{
    public class DiagnosticoMapper : Profile
    {
        public DiagnosticoMapper()
        {
            CreateMap<DiagnosticoDTO, Diagnostico>();
            CreateMap<Diagnostico, DiagnosticoDTO>();
            CreateMap<Diagnostico, DiagnosticoSearchFilter>();
            CreateMap<DiagnosticoSearchFilter, Diagnostico>();
        }
        
    }
}
