namespace ServicioMedico.Data
{
    public interface IService<Tentity> where Tentity : class
    {
        public Task<List<Tentity>> getAll();
        public Task<Tentity> get(long id);
        public Task<Tentity> deleteCitaById(long id);
        public Task<Tentity> add(Tentity entity);
        public Task<Tentity> update(long id, Tentity entity);
    }
}
