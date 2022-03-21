using ServicioMedico.Data;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class CitaRepository : EFCoreRepository<Cita, DataContext>
    {
        private DataContext _dataContext;

        public CitaRepository(DataContext context) : base(context)
        {
            _dataContext = context;
        }

        public async Task<Cita> createCita(Cita cita)
        {

            var diagnostico = await _dataContext.Diagnostico.FindAsync(cita.diagnostico.Id);
            if (diagnostico != null)
            {
                cita.diagnostico = diagnostico;
            }
            var medico = await _dataContext.MedicoDB.FindAsync(cita.medico.Id);
            if (medico != null)
            {
                cita.medico = medico;
            }
            var paciente= await _dataContext.PacienteDB.FindAsync(cita.paciente.Id);
            if (paciente != null)
            {
                cita.paciente = paciente;
            }

            return await this.add(cita);
        }
    }
}
