using Gestao.Domain.Enums;
using Gestao.Domain.Libraries.Utilities;

namespace Gestao.Domain.Repositories
{
    /// <summary>
    /// Interface que define os métodos para manipulação de transações financeiras
    /// </summary>
    public interface IFinancialTransactionRepository
    {
        Task Add(FinancialTransaction entity); // Adicionar uma nova transação financeira
        Task Delete(int id); // Deletar uma transação financeira pelo ID
        Task Delete(FinancialTransaction entity);
        Task<FinancialTransaction?> Get(int id); // Obter uma transação financeira pelo ID
        Task<PaginatedList<FinancialTransaction>> GetAll(int companyId, TypeFinancialTransaction type, int pageIndex, int pageSize, string searchWord); // Obter uma lista paginada de transações financeiras
        Task<int> GetCountTransactionsSameGroup(int id);
        Task<List<FinancialTransaction>> GetTransactionsSameGroup(int id);
        Task Update(FinancialTransaction entity); // Atualizar uma transação financeira existente
    }
}
