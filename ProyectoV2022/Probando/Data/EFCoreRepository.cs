using Microsoft.EntityFrameworkCore;
using ServicioMedico.Entities;
using System.Linq.Expressions;

namespace ServicioMedico.Data
{
    public abstract class EFCoreRepository<TEntity, TContext> : IRepository<TEntity>
        where TEntity : class, IEntity
        where TContext : DbContext
    {
        private readonly TContext _context;

        public EFCoreRepository(TContext context) 
        { 
            _context = context;
        }

        public async Task<TEntity> add(TEntity element)
        {
            _context.Set<TEntity>().Add(element);
            await _context.SaveChangesAsync();
            return element;
        }

        public async Task<TEntity> deleteByIdAsync(long id)
        {
            TEntity entity = await _context.Set<TEntity>().FindAsync(id);
            if (entity == null)
            {
                return entity;
            }
            _context.Set<TEntity>().Remove(entity);
            await _context.SaveChangesAsync();
            return entity;
        }

        public async Task<TEntity> getAsync(long id)
        {
            return await _context.Set<TEntity>().FindAsync(id);
    
        }

        /*public async Task<TEntity> getAsyncIncluding(long id, params Expression<Func<TEntity, object>>[] includeProperties)
        {
            IQueryable<TEntity> entities = GetIncluding(includeProperties);
            TEntity entity = entities.Where(entity => entity.Id == id).First();
            return entity;

        }*/

        public async Task<List<TEntity>> getAll()
        {
           return await _context.Set<TEntity>().ToListAsync();
        }

        public async Task<TEntity> update(TEntity element)
        {
            _context.Entry(element).State = EntityState.Modified;
            await _context.SaveChangesAsync();
            return element;
            

        }

       /* protected IQueryable<TEntity> GetIncluding(params Expression<Func<TEntity, object>>[] includeProperties)
        {
            IQueryable<TEntity> queryable = _context.Set<TEntity>();
            foreach (Expression<Func<TEntity, object>> includeProperty in includeProperties)
            {
                queryable = queryable.Include<TEntity, object>(includeProperty);
            }
      
            return queryable;
        }*/
    }
}
