using Microsoft.AspNetCore.Mvc;
using ServicioMedico.DTO;
using ServicioMedico.Entities;
using ServicioMedico.ServiceImpl;

namespace ServicioMedico.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class CitaController
    {

        private readonly CitaService _citaService;

        public CitaController(CitaService citaService)
        {
            _citaService = citaService;
        }

        //api/Citas
        [HttpGet]
        public async Task<ActionResult<List<CitaDTO>>> GetAll()
        {

            return await _citaService.getAll();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<CitaDTO>> Get(long id)
        {
            var Cita = await _citaService.get(id);
            if (Cita == null)
            {
                
                return new NotFoundObjectResult(string.Format("ERROR 404,\nNo existe ninguna cita con id {0} ",id));
            }
            return Cita;
        }

        [HttpPost]
        public async Task<ActionResult<CitaDTO>> post(CitaDTO cita)
        {
            return await _citaService.add(cita);
        }

        [HttpPut("{id}")]
        public async Task<ActionResult<CitaDTO>> update(long id, CitaDTO cita)
        {
            if (id != cita.Id)
            {
                return new BadRequestResult();
            }
            return await _citaService.update(id,cita);
        }



    }
}
