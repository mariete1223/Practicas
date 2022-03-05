namespace ServicioMedico.Data
{
    public abstract class ServiceAbstract<TEntityDTO, TRepository,TEntity> : IService<TEntityDTO>
        where TEntity : class, IEntity
        where TRepository : class, IRepository<TEntity>
        where TEntityDTO : class
    {

        private IMapper _mapper;

        private TRepository _repository;

        public ServiceAbstract(IMapper mapper, TRepository repository)
        {
            _mapper = mapper;
            _repository = repository;

        }

        public async Task<TEntityDTO> add(TEntityDTO entityDTO)
        {
            return _mapper.Map<TEntityDTO>(await _repository.add(_mapper.Map<TEntity>(entityDTO)));
        }

        public async Task<TEntityDTO> deleteCitaById(long id)
        {
            return _mapper.Map<TEntityDTO>(await _repository.deleteByIdAsync(id));
        }

        public async Task<TEntityDTO> get(long id)
        {
            return _mapper.Map<TEntityDTO>(await _repository.getAsync(id));
        }

        public async Task<List<TEntityDTO>> getAll()
        {
            var list = await _repository.getAll();
            if (list == null)
            {
                return new List<TEntityDTO>();
            }

            return _mapper.Map<List<TEntityDTO>>(list);
        }

        public async Task<TEntityDTO> update(long id,TEntityDTO entityDTO)
        {
            return _mapper.Map<TEntityDTO>(await _repository.update(_mapper.Map<TEntity>(entityDTO)));
        }
    }
}
