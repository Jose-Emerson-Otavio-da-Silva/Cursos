using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Gestao.Client.Libraries.Utilities;
using Gestao.Domain;
using Gestao.Domain.Enums;
using Microsoft.EntityFrameworkCore;

namespace Gestao.Data.Repositories
{
    /// <summary>
    /// Implementação da interface IFinancialTransactionRepository
    /// </summary>
    public class FinancialTransactionRepository : IFinancialTransactionRepository
    {
        private readonly ApplicationDbContext _context;

        // Construtor que recebe o contexto do banco de dados
        public FinancialTransactionRepository(ApplicationDbContext context)
        {
            _context = context;
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
            // Filtra as transações financeiras pelo ID da empresa e tipo de transação
            var items = await _context.FinancialTransactions
                .Where(a => a.CompanyId == companyId && a.TypeFinancialTransaction == type)
                .Where(a => a.Description.Contains(searchWord))
                .Skip((pageIndex - 1) * pageSize) // Pula os itens das páginas anteriores
                .Take(pageSize) // Pega a quantidade de itens da página atual
                .ToListAsync();

            // Conta o total de transações financeiras que atendem aos critérios
            var count = await _context.FinancialTransactions
                .Where(a => a.CompanyId == companyId && a.TypeFinancialTransaction == type).Where(a => a.Description.Contains(searchWord)).CountAsync();

            // Calcula o total de páginas
            int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

            // Retorna a lista paginada
            return new PaginatedList<FinancialTransaction>(items, pageIndex, totalPages);
        }

        /// <summary>
        /// Método para obter uma transação financeira pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task<FinancialTransaction?> Get(int id)
        {
            return await _context.FinancialTransactions.OrderByDescending(a => a.ReferenceDate).Include(a => a.Documents).SingleOrDefaultAsync(a => a.Id == id);
        }

        /// <summary>
        /// Método para adicionar uma nova transação financeira
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Add(FinancialTransaction entity)
        {
            _context.FinancialTransactions.Add(entity); // Adiciona a entidade ao contexto
            await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
        }

        /// <summary>
        /// Método para atualizar uma transação financeira existente
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Update(FinancialTransaction entity)
        {
            _context.FinancialTransactions.Update(entity); // Atualiza a entidade no contexto
            await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
        }

        /// <summary>
        /// Método para deletar uma transação financeira pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            var entity = await Get(id); // Obtém a transação financeira pelo ID
            if (entity is not null) // Verifica se a transação existe
            {
                _context.FinancialTransactions.Remove(entity); // Remove a entidade do contexto
                await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }
    }
}
