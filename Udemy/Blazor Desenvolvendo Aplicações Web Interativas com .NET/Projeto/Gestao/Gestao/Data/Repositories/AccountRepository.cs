using Gestao.Domain;
using Gestao.Domain.Libraries.Utilities;
using Gestao.Domain.Repositories;
using Microsoft.EntityFrameworkCore;

namespace Gestao.Data.Repositories
{
    /// <summary>
    /// Implementação do repositório de contas
    /// </summary>
    public class AccountRepository : IAccountRepository
    {
        private readonly IDbContextFactory<ApplicationDbContext> _factory;

        /// <summary>
        /// Construtor que recebe o contexto do banco de dados
        /// </summary>
        /// <param name="factory"></param>
        public AccountRepository(IDbContextFactory<ApplicationDbContext> factory)
        {
            _factory = factory;
        }

        /// <summary>
        /// Método para obter uma lista paginada de contas de uma empresa
        /// </summary>
        /// <param name="companyId"></param>
        /// <param name="pageIndex"></param>
        /// <param name="pageSize"></param>
        /// <returns></returns>
        public async Task<PaginatedList<Account>> GetAll(int companyId, int pageIndex, int pageSize, string searchWord = "")
        {
            using (var _db = _factory.CreateDbContext())
            {
                // Obtém os itens da página atual
                var items = await _db.Accounts
                    .Where(a => a.CompanyId == companyId)
                    .Where(a => a.Description.Contains(searchWord))
                    .OrderBy(a => a.Description)
                    .Skip((pageIndex - 1) * pageSize)
                    .Take(pageSize)
                    .ToListAsync();

                // Conta o total de itens
                var count = await _db.Accounts
                    .Where(a => a.CompanyId == companyId).Where(a => a.Description.Contains(searchWord)).CountAsync();

                // Calcula o número total de páginas
                int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

                // Retorna a lista paginada
                return new PaginatedList<Account>(items, pageIndex, totalPages);
            }
        }

        /// <summary>
        /// Método para obter todas as contas de uma empresa
        /// </summary>
        /// <param name="companyId"></param>
        /// <returns></returns>
        public async Task<List<Account>> GetAll(int companyId)
        {
            using (var _db = _factory.CreateDbContext())
            {
                return await _db.Accounts
                    .Where(a => a.CompanyId == companyId)
                    .ToListAsync();
            }
        }

        /// <summary>
        /// Método para obter uma conta pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task<Account?> Get(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                return await _db.Accounts.SingleOrDefaultAsync(a => a.Id == id);
            }
        }

        /// <summary>
        /// Método para adicionar uma nova conta
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Add(Account entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.Accounts.Add(entity);
                await _db.SaveChangesAsync();
            }
        }

        /// <summary>
        /// Método para atualizar uma conta existente
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Update(Account entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.Accounts.Update(entity);
                await _db.SaveChangesAsync();
            }
        }

        /// <summary>
        /// Método para deletar uma conta pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                var entity = await Get(id); // Obtém a conta pelo ID
                if (entity is not null)
                {
                    _db.Accounts.Remove(entity); // Remove a conta
                    await _db.SaveChangesAsync(); // Salva as alterações
                }
            }
        }
    }
}
