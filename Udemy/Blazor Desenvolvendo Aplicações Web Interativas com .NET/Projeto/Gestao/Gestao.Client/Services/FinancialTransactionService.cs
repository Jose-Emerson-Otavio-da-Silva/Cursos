using Gestao.Domain;
using Gestao.Domain.Enums;
using Gestao.Domain.Libraries.Utilities;
using Gestao.Domain.Repositories;

namespace Gestao.Client.Services
{
    public class FinancialTransactionService : IFinancialTransactionRepository
    {
        public Task Add(FinancialTransaction entity)
        {
            throw new NotImplementedException();
        }

        public Task Delete(int id)
        {
            throw new NotImplementedException();
        }

        public Task<FinancialTransaction?> Get(int id)
        {
            throw new NotImplementedException();
        }

        public Task<PaginatedList<FinancialTransaction>> GetAll(int companyId, TypeFinancialTransaction type, int pageIndex, int pageSize, string searchWord)
        {
            throw new NotImplementedException();
        }

        public Task Update(FinancialTransaction entity)
        {
            throw new NotImplementedException();
        }
    }
}