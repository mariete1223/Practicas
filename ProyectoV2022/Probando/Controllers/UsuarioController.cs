using Microsoft.AspNetCore.Mvc;
using ServicioMedico.DTO;
using ServicioMedico.ServiceImpl;

namespace ServicioMedico.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class UsuarioController
    {
        private readonly UsuarioService _usuarioService;

        public UsuarioController(UsuarioService usuarioService)
        {
            _usuarioService = usuarioService;
        }

        //api/Citas
        [HttpGet]
        public async Task<ActionResult<List<UsuarioDTO>>> GetAll()
        {

            return await _usuarioService.getAll();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<UsuarioDTO>> Get(long id)
        {
            var Medico = await _usuarioService.get(id);
            if (Medico == null)
            {

                return new NotFoundObjectResult(string.Format("ERROR 404,\nNo existe ninguna cita con id {0} ", id));
            }
            return Medico;
        }

        [HttpPost]
        public async Task<ActionResult<UsuarioDTO>> post(UsuarioDTO usuarioDTO)
        {
            return await _usuarioService.add(usuarioDTO);
        }

        [HttpPut("{id}")]
        public async Task<ActionResult<UsuarioDTO>> update(long id, UsuarioDTO usuarioDTO)
        {
            if (id != usuarioDTO.Id)
            {
                return new BadRequestResult();
            }
            return await _usuarioService.update(id, usuarioDTO);
        }
    }
}
