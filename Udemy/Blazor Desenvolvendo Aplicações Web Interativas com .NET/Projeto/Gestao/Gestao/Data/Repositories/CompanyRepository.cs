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
    /// Interface para o repositório de empresas
    /// Define os métodos para manipulação de dados de empresas no banco de dados
    /// </summary>
    public interface ICompanyRepository
    {
        Task Add(Company company); // Adiciona uma nova empresa
        Task Delete(int id); // Remove uma empresa pelo ID
        Task<Company?> Get(int id); // Obtém uma empresa pelo ID
        Task<PaginatedList<Company>> GetAll(Guid applicationUserId, int pageIndex, int pageSize); // Obtém uma lista paginada de empresas associadas a um usuário
        Task Update(Company company); // Atualiza os dados de uma empresa
    }

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
        /// Método para obter uma lista paginada de empresas associadas a um usuário
        /// </summary>
        /// <param name="applicationUserId"></param>
        /// <param name="pageIndex"></param>
        /// <param name="pageSize"></param>
        /// <returns></returns>
        public async Task<PaginatedList<Company>> GetAll(Guid applicationUserId, int pageIndex, int pageSize)
        {
            // Obtém os itens da página atual
            var items = await _context.Companies
                .Where(a => a.UserId == applicationUserId) // Filtra as empresas pelo ID do usuário
                .Skip((pageIndex - 1) * pageSize) // Ignora os itens das páginas anteriores
                .Take(pageSize) // Seleciona os itens da página atual
                .ToListAsync();

            // Conta o total de empresas associadas ao usuário
            var count = await _context.Companies
                .Where(a => a.UserId == applicationUserId).CountAsync();

            // Calcula o número total de páginas
            int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

            // Retorna a lista paginada
            return new PaginatedList<Company>(items, pageIndex, totalPages);
        }

        /// <summary>
        /// Método para obter uma empresa pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task<Company?> Get(int id)
        {
            return await _context.Companies.SingleOrDefaultAsync(a => a.Id == id);
        }

        /// <summary>
        /// Método para adicionar uma nova empresa
        /// </summary>
        /// <param name="company"></param>
        /// <returns></returns>
        public async Task Add(Company company)
        {
            _context.Companies.Add(company); // Adiciona a empresa ao contexto
            await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
        }

        /// <summary>
        /// Método para atualizar os dados de uma empresa
        /// </summary>
        /// <param name="company"></param>
        /// <returns></returns>
        public async Task Update(Company company)
        {
            _context.Companies.Update(company); // Atualiza a empresa no contexto
            await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
        }

        /// <summary>
        /// Método para remover uma empresa pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            var company = await Get(id); // Obtém a empresa pelo ID
            if (company is not null) // Verifica se a empresa existe
            {
                _context.Companies.Remove(company); // Remove a empresa do contexto
                await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }
    }
}