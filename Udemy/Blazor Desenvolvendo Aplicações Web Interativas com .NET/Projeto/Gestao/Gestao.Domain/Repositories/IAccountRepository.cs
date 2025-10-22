using Gestao.Domain.Libraries.Utilities;

namespace Gestao.Domain.Repositories
{
    /// <summary>
    /// Interface que define os métodos do repositório de contas
    /// </summary>
    public interface IAccountRepository
    {
        Task Add(Account entity); // Adicionar uma nova conta
        Task Delete(int id); // Deletar uma conta pelo ID
        Task<Account?> Get(int id); // Obter uma conta pelo ID
        Task<PaginatedList<Account>> GetAll(int companyId, int pageIndex, int pageSize, string searchWord); // Obter uma lista paginada de contas de uma empresa
        Task<List<Account>> GetAll(int companyId); // Obter todas as contas de uma empresa
        Task Update(Account entity); // Atualizar uma conta
    }
}
