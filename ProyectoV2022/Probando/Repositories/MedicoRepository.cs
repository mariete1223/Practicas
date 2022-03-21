using ServicioMedico.Data;
using ServicioMedico.Entities;

namespace ServicioMedico.Repositories
{
    public class MedicoRepository : EFCoreRepository<Medico, DataContext>
    {
        private DataContext _dataContext;
        public MedicoRepository(DataContext context) : base(context)
        {
            _dataContext = context;
        }

        public async Task<Medico> createMedico(Medico medico)
        {
            List<Paciente> pacienteList = new List<Paciente>();
            foreach(Paciente p in medico.pacientes)
            {
                var paciente = await _dataContext.PacienteDB.FindAsync(p.Id);
                if (paciente != null)
                {
                    pacienteList.Add(paciente);
                }
            }
            
            medico.pacientes = pacienteList;
            medico.citas= new List<Cita>();
            return await this.add(medico);
        }
    }
}
