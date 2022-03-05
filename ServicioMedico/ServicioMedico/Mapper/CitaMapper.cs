using AutoMapper;
using ServicioMedico.DTO;
using ServicioMedico.Entities;

namespace ServicioMedico.Mapper
{
    public class CitaMapper : Profile
    {
        public CitaMapper()
        {
            CreateMap<CitaDTO, Cita>();
            CreateMap<Cita, CitaDTO>();

        }
    }
}
