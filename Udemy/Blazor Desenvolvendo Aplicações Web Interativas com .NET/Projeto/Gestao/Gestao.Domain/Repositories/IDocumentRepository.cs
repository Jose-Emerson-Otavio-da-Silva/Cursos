using Microsoft.EntityFrameworkCore;
using Gestao.Domain;

namespace Gestao.Domain.Repositories
{
    /// <summary>
    /// Interface que define os métodos para manipulação de documentos no repositório
    /// </summary>
    public interface IDocumentRepository
    {
        Task Add(Document entity); // Adiciona um novo documento
        Task Delete(int id); // Remove um documento pelo ID
        Task<Document?> Get(int id); // Obtém um documento pelo ID
        Task Update(Document entity); // Atualiza um documento existente
    }
}
