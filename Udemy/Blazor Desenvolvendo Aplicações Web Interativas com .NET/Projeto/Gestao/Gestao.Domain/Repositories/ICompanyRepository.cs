using Gestao.Domain.Libraries.Utilities;

namespace Gestao.Domain.Repositories
{
    /// <summary>
    /// Interface para o repositório de empresas
    /// Define métodos para gerenciar dados de empresas no banco de dados
    /// </summary>
    public interface ICompanyRepository
    {
        Task Add(Company company); // Adiciona uma nova empresa
        Task Delete(int id); // Remove uma empresa pelo ID
        Task<Company?> Get(int id); // Obtém uma empresa pelo ID
        Task<PaginatedList<Company>> GetAll(Guid applicationUserId, int pageIndex, int pageSize, string searchWord); // Obtém uma lista paginada de empresas associadas a um usuário
        Task Update(Company company); // Atualiza os dados de uma empresa
    }
}