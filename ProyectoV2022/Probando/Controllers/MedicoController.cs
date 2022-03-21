using Microsoft.AspNetCore.Mvc;
using ServicioMedico.DTO;
using ServicioMedico.ServiceImpl;

namespace ServicioMedico.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class MedicoController
    {
        private readonly MedicoService _medicoService;

        public MedicoController(MedicoService medicoService)
        {
            _medicoService = medicoService;
        }

        //api/Citas
        [HttpGet]
        public async Task<ActionResult<List<MedicoDTO>>> GetAll()
        {

            return await _medicoService.getAll();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<MedicoDTO>> Get(long id)
        {
            var Medico = await _medicoService.get(id);
            if (Medico == null)
            {

                return new NotFoundObjectResult(string.Format("ERROR 404,\nNo existe ninguna cita con id {0} ", id));
            }
            return Medico;
        }

        [HttpPost]
        public async Task<ActionResult<MedicoDTO>> post(MedicoDTO medicoDTO)
        {
            return await _medicoService.create(medicoDTO);
        }

        [HttpPut("{id}")]
        public async Task<ActionResult<MedicoDTO>> update(long id, MedicoDTO medicoDTO)
        {
            if (id != medicoDTO.Id)
            {
                return new BadRequestResult();
            }
            return await _medicoService.update(id, medicoDTO);
        }
    }
}
