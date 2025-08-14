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
    /// Implementação do repositório para a entidade entity
    /// </summary>
    public class entityRepository
    {
        private readonly ApplicationDbContext _context; // Contexto do banco de dados

        // Construtor que recebe o contexto do banco de dados via injeção de dependência
        public entityRepository(ApplicationDbContext context)
        {
            _context = context;
        }

        /// <summary>
        /// Obtém uma lista paginada de categorias associadas a uma empresa
        /// </summary>
        /// <param name="companyId">ID da empresa</param>
        /// <param name="pageIndex">Índice da página atual</param>
        /// <param name="pageSize">Quantidade de itens por página</param>
        /// <returns>Lista paginada de categorias</returns>
        public async Task<PaginatedList<Category>> GetAll(int companyId, int pageIndex, int pageSize)
        {
            // Obtém os itens da página atual
            var items = await _context.Categories
                .Where(a => a.CompanyId == companyId) // Filtra as categorias pelo ID da empresa
                .Skip((pageIndex - 1) * pageSize) // Ignora os itens das páginas anteriores
                .Take(pageSize) // Seleciona os itens da página atual
                .ToListAsync();

            // Conta o total de categorias associadas à empresa
            var count = await _context.Categories
                .Where(a => a.CompanyId == companyId).CountAsync();

            // Calcula o número total de páginas
            int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

            // Retorna a lista paginada
            return new PaginatedList<Category>(items, pageIndex, totalPages);
        }

        /// <summary>
        /// Obtém todas as categorias associadas a uma empresa
        /// </summary>
        /// <param name="companyId">ID da empresa</param>
        /// <returns>Lista de categorias</returns>
        public async Task<List<Category>> GetAll(int companyId)
        {
            return await _context.Categories
                .Where(a => a.CompanyId == companyId)
                .ToListAsync();
        }

        /// <summary>
        /// Obtém uma categoria pelo ID
        /// </summary>
        /// <param name="id">ID da categoria</param>
        /// <returns>Categoria encontrada ou null</returns>
        public async Task<Category?> Get(int id)
        {
            return await _context.Categories.SingleOrDefaultAsync(a => a.Id == id);
        }

        /// <summary>
        /// Adiciona uma nova categoria
        /// </summary>
        /// <param name="entity">Categoria a ser adicionada</param>
        /// <returns></returns>
        public async Task Add(Category entity)
        {
            _context.Categories.Add(entity); // Adiciona a categoria ao contexto
            await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
        }

        /// <summary>
        /// Atualiza os dados de uma categoria
        /// </summary>
        /// <param name="entity">Categoria a ser atualizada</param>
        /// <returns></returns>
        public async Task Update(Category entity)
        {
            _context.Categories.Update(entity); // Atualiza a categoria no contexto
            await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
        }

        /// <summary>
        /// Remove uma categoria pelo ID
        /// </summary>
        /// <param name="id">ID da categoria</param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            var entity = await Get(id); // Obtém a categoria pelo ID
            if (entity is not null) // Verifica se a categoria existe
            {
                _context.Categories.Remove(entity); // Remove a categoria do contexto
                await _context.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }
    }
}