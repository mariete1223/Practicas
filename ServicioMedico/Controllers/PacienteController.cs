using Microsoft.AspNetCore.Mvc;
using ServicioMedico.DTO;
using ServicioMedico.ServiceImpl;

namespace ServicioMedico.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class PacienteController
    {
        private readonly PacienteService _pacienteService;

        public PacienteController(PacienteService pacienteService)
        {
            _pacienteService = pacienteService;
        }

        //api/Citas
        [HttpGet]
        public async Task<ActionResult<List<PacienteDTO>>> GetAll()
        {

            return await _pacienteService.getAll();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<PacienteDTO>> Get(long id)
        {
            var Paciente = await _pacienteService.get(id);
            if (Paciente == null)
            {

                return new NotFoundObjectResult(string.Format("ERROR 404,\nNo existe ninguna cita con id {0} ", id));
            }
            return Paciente;
        }

        [HttpPost]
        public async Task<ActionResult<PacienteDTO>> post(PacienteDTO pacienteDTO)
        {
            return await _pacienteService.add(pacienteDTO);
        }

        [HttpPut("{id}")]
        public async Task<ActionResult<PacienteDTO>> update(long id, PacienteDTO pacienteDTO)
        {
            if (id != pacienteDTO.Id)
            {
                return new BadRequestResult();
            }
            return await _pacienteService.update(id, pacienteDTO);
        }
    }
}
