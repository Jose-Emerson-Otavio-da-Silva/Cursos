using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Gestao.Client.Libraries.Utilities;
using Gestao.Domain;
using Gestao.Domain.Enums;
using Microsoft.EntityFrameworkCore;

namespace Gestao.Domain.Repositories
{
    /// <summary>
    /// Interface que define os métodos para manipulação de transações financeiras
    /// </summary>
    public interface IFinancialTransactionRepository
    {
        Task Add(FinancialTransaction entity); // Adicionar uma nova transação financeira
        Task Delete(int id); // Deletar uma transação financeira pelo ID
        Task<FinancialTransaction?> Get(int id); // Obter uma transação financeira pelo ID
        Task<PaginatedList<FinancialTransaction>> GetAll(int companyId, TypeFinancialTransaction type, int pageIndex, int pageSize, string searchWord); // Obter uma lista paginada de transações financeiras
        Task Update(FinancialTransaction entity); // Atualizar uma transação financeira existente
    }
}
