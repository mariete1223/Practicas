using ServicioMedico.Data;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class PacienteRepository : EFCoreRepository<Paciente, DataContext>
    {
        private DataContext _dataContext;
        public PacienteRepository(DataContext context) : base(context)
        {
            _dataContext = context;
        }

        public async Task<Paciente> createPaciente(Paciente paciente)
        {
            List<Medico> medicoList = new List<Medico>();
            foreach(Medico p in paciente.medicos)
            {
                var medico = await _dataContext.MedicoDB.FindAsync(p.Id);
                if (medico != null)
                {
                    medicoList.Add(medico);
                }
            }
            
            paciente.medicos = medicoList;
            paciente.citas = new List<Cita>();
            return await this.add(paciente);
        }
    }
}
