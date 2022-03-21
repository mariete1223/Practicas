using ServicioMedico.Data;
using ServicioMedico.DTO;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class DiagnosticoRepository : EFCoreRepository<Diagnostico, DataContext>
    {
        private DataContext _dataContext;
        public DiagnosticoRepository(DataContext context) : base(context)
        {
            _dataContext = context;
        }

        public async Task<Diagnostico> createDiag(Diagnostico diagnostico)
        {

            var cita = await _dataContext.Cita.FindAsync(diagnostico.cita.Id);
            if (cita == null)
            {
                var paciente = await _dataContext.PacienteDB.FindAsync(diagnostico.cita.paciente.Id);
                var medico = await _dataContext.MedicoDB.FindAsync(diagnostico.cita.medico.Id);
                if (paciente != null)
                {
                    diagnostico.cita.paciente = paciente;
                }
                if (medico != null)
                {
                    diagnostico.cita.medico = medico;
                }

            }
            else
            {
                diagnostico.cita = cita;
            }

            return await this.add(diagnostico);
        }
    }
}
