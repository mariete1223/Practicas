using Microsoft.AspNetCore.Mvc;
using ServicioMedico.DTO;
using ServicioMedico.ServiceImpl;

namespace ServicioMedico.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class DiagnosticoController
    {
        private readonly DiagnosticoService _diagnosticoService;

        public DiagnosticoController(DiagnosticoService diagnosticoService)
        {
            _diagnosticoService = diagnosticoService;
        }

        //api/Citas
        [HttpGet]
        public async Task<ActionResult<List<DiagnosticoDTO>>> GetAll()
        {

            return await _diagnosticoService.getAll();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<DiagnosticoDTO>> Get(long id)
        {
            var Cita = await _diagnosticoService.get(id);
            if (Cita == null)
            {

                return new NotFoundObjectResult(string.Format("ERROR 404,\nNo existe ninguna cita con id {0} ", id));
            }
            return Cita;
        }

        [HttpPost]
        public async Task<ActionResult<DiagnosticoDTO>> post(DiagnosticoDTO diagnosticoDTO)
        {
            return await _diagnosticoService.create(diagnosticoDTO);
        }

        [HttpPut("{id}")]
        public async Task<ActionResult<DiagnosticoDTO>> update(long id, DiagnosticoDTO diagnosticoDTO)
        {
            if (id != diagnosticoDTO.Id)
            {
                return new BadRequestResult();
            }
            return await _diagnosticoService.update(id, diagnosticoDTO);
        }
    }
}
