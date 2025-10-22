using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Gestao.Client.Libraries.Utilities;
using Gestao.Domain;
using Microsoft.EntityFrameworkCore;

namespace Gestao.Data.Repositories
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