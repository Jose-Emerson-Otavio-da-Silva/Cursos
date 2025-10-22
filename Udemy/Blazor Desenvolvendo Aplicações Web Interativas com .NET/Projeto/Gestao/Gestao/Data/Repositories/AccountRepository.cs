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
    /// Implementação do repositório de contas
    /// </summary>
    public class AccountRepository : IAccountRepository
    {
        private readonly ApplicationDbContext _context;

        /// <summary>
        /// Construtor que recebe o contexto do banco de dados
        /// </summary>
        /// <param name="context"></param>
        public AccountRepository(ApplicationDbContext context)
        {
            _context = context;
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
            // Obtém os itens da página atual
            var items = await _context.Accounts
                .Where(a => a.CompanyId == companyId)
                .Where(a => a.Description.Contains(searchWord))
                .OrderBy(a => a.Description)
                .Skip((pageIndex - 1) * pageSize)
                .Take(pageSize)
                .ToListAsync();

            // Conta o total de itens
            var count = await _context.Accounts
                .Where(a => a.CompanyId == companyId).Where(a => a.Description.Contains(searchWord)).CountAsync();

            // Calcula o número total de páginas
            int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

            // Retorna a lista paginada
            return new PaginatedList<Account>(items, pageIndex, totalPages);
        }

        /// <summary>
        /// Método para obter todas as contas de uma empresa
        /// </summary>
        /// <param name="companyId"></param>
        /// <returns></returns>
        public async Task<List<Account>> GetAll(int companyId)
        {
            return await _context.Accounts
                .Where(a => a.CompanyId == companyId)
                .ToListAsync();
        }

        /// <summary>
        /// Método para obter uma conta pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task<Account?> Get(int id)
        {
            return await _context.Accounts.SingleOrDefaultAsync(a => a.Id == id);
        }

        /// <summary>
        /// Método para adicionar uma nova conta
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Add(Account entity)
        {
            _context.Accounts.Add(entity);
            await _context.SaveChangesAsync();
        }

        /// <summary>
        /// Método para atualizar uma conta existente
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Update(Account entity)
        {
            _context.Accounts.Update(entity);
            await _context.SaveChangesAsync();
        }

        /// <summary>
        /// Método para deletar uma conta pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            var entity = await Get(id); // Obtém a conta pelo ID
            if (entity is not null)
            {
                _context.Accounts.Remove(entity); // Remove a conta
                await _context.SaveChangesAsync(); // Salva as alterações
            }
        }
    }
}
