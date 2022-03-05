namespace ServicioMedico.Data
{
    public interface IRepository<T> where T : class, IEntity
    {
        public Task<List<T>> getAll();
        public Task<T> getAsync(long id);
        public Task<T> deleteByIdAsync(long id);
        public Task<T> add(T element);
        public Task<T> update(T element);
    }
}
