using Gestao.Domain.Libraries.Utilities;

namespace Gestao.Domain.Repositories
{
    /// <summary>
    /// Interface para CategoryRepository
    /// </summary>
    public interface ICategoryRepository
    {
        Task Add(Category entity);
        Task Delete(int id);
        Task<Category?> Get(int id);
        Task<PaginatedList<Category>> GetAll(int companyId, int pageIndex, int pageSize);
        Task<List<Category>> GetAll(int companyId);
        Task Update(Category entity);
    }
}