using Microsoft.EntityFrameworkCore;
using Gestao.Domain;
using Gestao.Domain.Repositories;

namespace Gestao.Data.Repositories
{
    /// <summary>
    /// Implementação da interface IDocumentRepository
    /// </summary>
    public class DocumentRepository : IDocumentRepository
    {
        private readonly IDbContextFactory<ApplicationDbContext> _factory;

        // Construtor que recebe o contexto do banco de dados
        public DocumentRepository(IDbContextFactory<ApplicationDbContext> factory)
        {
            _factory = factory;
        }

        // Obtém um documento pelo ID
        public async Task<Document?> Get(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                return await _db.Documents.SingleOrDefaultAsync(a => a.Id == id);
            }
        }

        /// <summary>
        /// Adiciona um novo documento ao banco de dados
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Add(Document entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.Documents.Add(entity);
                await _db.SaveChangesAsync();
            }
        }

        /// <summary>
        /// Atualiza um documento existente no banco de dados
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Update(Document entity)
        {
            using (var _db = _factory.CreateDbContext())
            {
                _db.Documents.Update(entity);
                await _db.SaveChangesAsync();
            }
        }

        /// <summary>
        /// Remove um documento do banco de dados pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            using (var _db = _factory.CreateDbContext())
            {
                var entity = await Get(id); // Obtém o documento pelo ID
                if (entity is not null) // Verifica se o documento existe
                {
                    _db.Documents.Remove(entity); // Remove o documento
                    await _db.SaveChangesAsync(); // Salva as alterações
                }
            }
        }
    }
}
