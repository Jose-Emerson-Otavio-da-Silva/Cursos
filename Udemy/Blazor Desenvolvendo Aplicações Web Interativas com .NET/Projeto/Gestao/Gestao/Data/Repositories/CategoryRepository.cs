using Gestao.Domain;
using Gestao.Domain.Libraries.Utilities;
using Gestao.Domain.Repositories;
using Microsoft.EntityFrameworkCore;

namespace Gestao.Data.Repositories
{
    /// <summary>
    /// Implementação do repositório para a entidade Category
    /// </summary>
    public class CategoryRepository : ICategoryRepository
    {
        private readonly IDbContextFactory<ApplicationDbContext> _factory; // Contexto do banco de dados

        // Construtor que recebe o contexto do banco de dados via injeção de dependência
        public CategoryRepository(IDbContextFactory<ApplicationDbContext> factory)
        {
            _factory = factory;
        }

        /// <summary>
        /// Recupera uma lista paginada de categorias associadas a uma empresa
        /// </summary>
        /// <param name="companyId">ID da empresa</param>
        /// <param name="pageIndex">Índice da página atual</param>
        /// <param name="pageSize">Número de itens por página</param>
        /// <returns>Lista paginada de categorias</returns>
        public async Task<PaginatedList<Category>> GetAll(int companyId, int pageIndex, int pageSize)
        {
            using (var _db = _factory.CreateDbContext())
            {
                // Recupera os itens para a página atual
                var items = await _db.Categories
                    .OrderBy(a => a.Name) // Ordena as categorias pelo nome
                    .Where(a => a.CompanyId == companyId) // Filtra as categorias pelo ID da empresa
                    .Skip((pageIndex - 1) * pageSize) // Ignora os itens das páginas anteriores
                    .Take(pageSize) // Seleciona os itens para a página atual
                    .ToListAsync();

                // Conta o número total de categorias associadas à empresa
                var count = await _db.Categories
                    .Where(a => a.CompanyId == companyId).CountAsync();

                // Calcula o número total de páginas
                int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

                // Retorna a lista paginada
                return new PaginatedList<Category>(items, pageIndex, totalPages);
            }
        }

        /// <summary>
        /// Recupera todas as categorias associadas a uma empresa
        /// </summary>
        /// <param name="companyId">ID da empresa</param>
        /// <returns>Lista de categorias</returns>
        public async Task<List<Category>> GetAll(int companyId)
        {
            using (var _db = _factory.CreateDbContext())
            {
                return await _db.Categories
                    .Where(a => a.CompanyId == companyId)
                    .ToListAsync();
            }
        }

        /// <summary>
        /// Recupera uma categoria pelo seu ID
        /// </summary>
        /// <param name="id">ID da categoria</param>
        /// <returns>Categoria encontrada ou null</returns>
        public async Task<Category?> Get(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                return await _db.Categories.SingleOrDefaultAsync(a => a.Id == id);
            }
        }

        /// <summary>
        /// Adiciona uma nova categoria
        /// </summary>
        /// <param name="entity">Categoria a ser adicionada</param>
        /// <returns></returns>
        public async Task Add(Category entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.Categories.Add(entity); // Adiciona a categoria ao contexto
                await _db.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }

        /// <summary>
        /// Atualiza os dados de uma categoria
        /// </summary>
        /// <param name="entity">Categoria a ser atualizada</param>
        /// <returns></returns>
        public async Task Update(Category entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.Categories.Update(entity); // Atualiza a categoria no contexto
                await _db.SaveChangesAsync(); // Salva as alterações no banco de dados
            }
        }

        /// <summary>
        /// Remove uma categoria pelo seu ID
        /// </summary>
        /// <param name="id">ID da categoria</param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                var entity = await Get(id); // Recupera a categoria pelo seu ID
                if (entity is not null) // Verifica se a categoria existe
                {
                    _db.Categories.Remove(entity); // Remove a categoria do contexto
                    await _db.SaveChangesAsync(); // Salva as alterações no banco de dados
                }
            }
        }
    }
}