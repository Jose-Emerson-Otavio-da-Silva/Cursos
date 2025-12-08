using Gestao.Domain;
using Gestao.Domain.Enums;
using Gestao.Domain.Libraries.Utilities;
using Gestao.Domain.Repositories;
using Microsoft.EntityFrameworkCore;

namespace Gestao.Data.Repositories
{
    /// <summary>
    /// Implementação da interface IFinancialTransactionRepository
    /// </summary>
    public class FinancialTransactionRepository : IFinancialTransactionRepository
    {
        private readonly IDbContextFactory<ApplicationDbContext> _factory;

        // Construtor que recebe o contexto do banco de dados
        public FinancialTransactionRepository(IDbContextFactory<ApplicationDbContext> factory)
        {
            _factory = factory;
        }

        /// <summary>
        /// Método para obter uma lista paginada de transações financeiras
        /// </summary>
        /// <param name="companyId"></param>
        /// <param name="type"></param>
        /// <param name="pageIndex"></param>
        /// <param name="pageSize"></param>
        /// <returns></returns>
        public async Task<PaginatedList<FinancialTransaction>> GetAll(int companyId, TypeFinancialTransaction type, int pageIndex, int pageSize, string searchWord = "")
        {
            using (var _db = _factory.CreateDbContext())
            {
                // Filtra as transações financeiras pelo ID da empresa e tipo de transação
                var items = await _db.FinancialTransactions
                    .Where(a => a.CompanyId == companyId && a.TypeFinancialTransaction == type)
                    .Where(a => a.Description.Contains(searchWord))
                    .Skip((pageIndex - 1) * pageSize) // Pula os itens das páginas anteriores
                    .Take(pageSize) // Pega a quantidade de itens da página atual
                    .ToListAsync();

                // Conta o total de transações financeiras que atendem aos critérios
                var count = await _db.FinancialTransactions
                    .Where(a => a.CompanyId == companyId && a.TypeFinancialTransaction == type).Where(a => a.Description.Contains(searchWord)).CountAsync();

                // Calcula o total de páginas
                int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

                // Retorna a lista paginada
                return new PaginatedList<FinancialTransaction>(items, pageIndex, totalPages);
            }
        }

        /// <summary>
        /// Método para obter uma transação financeira pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task<FinancialTransaction?> Get(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                return await _db.FinancialTransactions.OrderByDescending(a => a.ReferenceDate).Include(a => a.Category).
                Include(a => a.Account).Include(a => a.Documents).SingleOrDefaultAsync(a => a.Id == id);
            }
        }

        /// <summary>
        /// Método para adicionar uma nova transação financeira
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Add(FinancialTransaction entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.FinancialTransactions.Add(entity); // Adiciona a entidade ao contexto
                await _db.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }

        /// <summary>
        /// Método para atualizar uma transação financeira existente
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Update(FinancialTransaction entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.FinancialTransactions.Update(entity); // Atualiza a entidade no contexto
                await _db.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }

        /// <summary>
        /// Método para deletar uma transação financeira pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                var entity = await Get(id); // Obtém a transação financeira pelo ID
                if (entity is not null) // Verifica se a transação existe
                {
                    await Delete(entity);
                }
            }
        }

        public async Task Delete(FinancialTransaction entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.FinancialTransactions.Remove(entity); // Remove a entidade do contexto
                await _db.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }

        public async Task<int> GetCountTransactionsSameGroup(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                return await _db.FinancialTransactions.Where(a => a.RepeatGroup == id).OrderBy(a => a.Id).CountAsync();
            }
        }

        public async Task<List<FinancialTransaction>> GetTransactionsSameGroup(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                return await _db.FinancialTransactions.Where(a => a.RepeatGroup == id).OrderBy(a => a.Id).ToListAsync();
            }
        }
    }
}
