using Microsoft.EntityFrameworkCore;
using Gestao.Domain;

namespace Gestao.Data.Repositories
{
    /// <summary>
    /// Implementação da interface IDocumentRepository
    /// </summary>
    public class DocumentRepository : IDocumentRepository
    {
        private readonly ApplicationDbContext _context;

        // Construtor que recebe o contexto do banco de dados
        public DocumentRepository(ApplicationDbContext context)
        {
            _context = context;
        }

        // Obtém um documento pelo ID
        public async Task<Document?> Get(int id)
        {
            return await _context.Documents.SingleOrDefaultAsync(a => a.Id == id);
        }

        /// <summary>
        /// Adiciona um novo documento ao banco de dados
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Add(Document entity)
        {
            _context.Documents.Add(entity);
            await _context.SaveChangesAsync();
        }

        /// <summary>
        /// Atualiza um documento existente no banco de dados
        /// </summary>
        /// <param name="entity"></param>
        /// <returns></returns>
        public async Task Update(Document entity)
        {
            _context.Documents.Update(entity);
            await _context.SaveChangesAsync();
        }

        /// <summary>
        /// Remove um documento do banco de dados pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            var entity = await Get(id); // Obtém o documento pelo ID
            if (entity is not null) // Verifica se o documento existe
            {
                _context.Documents.Remove(entity); // Remove o documento
                await _context.SaveChangesAsync(); // Salva as alterações
            }
        }
    }
}
