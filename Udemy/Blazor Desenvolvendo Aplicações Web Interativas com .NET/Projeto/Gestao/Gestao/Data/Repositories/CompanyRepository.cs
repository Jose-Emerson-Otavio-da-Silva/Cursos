using Gestao.Domain;
using Gestao.Domain.Libraries.Utilities;
using Gestao.Domain.Repositories;
using Microsoft.EntityFrameworkCore;

namespace Gestao.Data.Repositories
{
    /// <summary>
    /// Implementação da interface ICompanyRepository
    /// </summary>
    public class CompanyRepository : ICompanyRepository
    {
        private readonly ApplicationDbContext _context; // Contexto do banco de dados

        // Construtor que recebe o contexto do banco de dados via injeção de dependência
        public CompanyRepository(ApplicationDbContext context)
        {
            _context = context;
        }

        /// <summary>
        /// Obtém uma lista paginada de empresas associadas a um usuário
        /// </summary>
        /// <param name="applicationUserId">O ID do usuário</param>
        /// <param name="pageIndex">O índice da página atual</param>
        /// <param name="pageSize">O número de itens por página</param>
        /// <returns>Uma lista paginada de empresas</returns>
        public async Task<PaginatedList<Company>> GetAll(Guid applicationUserId, int pageIndex, int pageSize, string searchWord)
        {
            // Obtém os itens para a página atual
            var items = await _context.Companies
                .Where(a => a.UserId == applicationUserId) // Filtra as empresas pelo ID do usuário
                .Where(a => a.TradeName.Contains(searchWord) || a.LegalName.Contains(searchWord))
                .OrderBy(a => a.TradeName)
                .Skip((pageIndex - 1) * pageSize) // Ignora os itens das páginas anteriores
                .Take(pageSize) // Seleciona os itens para a página atual
                .ToListAsync();

            // Conta o número total de empresas associadas ao usuário
            var count = await _context.Companies
                .Where(a => a.UserId == applicationUserId).Where(a => a.TradeName.Contains(searchWord) || a.LegalName.Contains(searchWord)).CountAsync();

            // Calcula o número total de páginas
            int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

            // Retorna a lista paginada
            return new PaginatedList<Company>(items, pageIndex, totalPages);
        }

        /// <summary>
        /// Obtém uma empresa pelo ID
        /// </summary>
        /// <param name="id">O ID da empresa</param>
        /// <returns>A empresa, se encontrada, caso contrário, null</returns>
        public async Task<Company?> Get(int id)
        {
            return await _context.Companies.SingleOrDefaultAsync(a => a.Id == id);
        }

        /// <summary>
        /// Adiciona uma nova empresa
        /// </summary>
        /// <param name="entity">A entidade da empresa a ser adicionada</param>
        /// <returns>Uma tarefa que representa a operação assíncrona</returns>
        public async Task Add(Company entity)
        {
            _context.Companies.Add(entity); // Adiciona a empresa ao contexto
            await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
        }

        /// <summary>
        /// Atualiza os dados de uma empresa
        /// </summary>
        /// <param name="entity">A entidade da empresa a ser atualizada</param>
        /// <returns>Uma tarefa que representa a operação assíncrona</returns>
        public async Task Update(Company entity)
        {
            _context.Companies.Update(entity); // Atualiza a empresa no contexto
            await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
        }

        /// <summary>
        /// Remove uma empresa pelo ID
        /// </summary>
        /// <param name="id">O ID da empresa a ser removida</param>
        /// <returns>Uma tarefa que representa a operação assíncrona</returns>
        public async Task Delete(int id)
        {
            var entity = await Get(id); // Obtém a empresa pelo ID
            if (entity is not null) // Verifica se a empresa existe
            {
                _context.Companies.Remove(entity); // Remove a empresa do contexto
                await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }
    }
}