using Coravel.Invocable;
using Gestao.Domain;
using Gestao.Domain.Repositories;
using Microsoft.VisualBasic;

namespace Gestao.Libraries.Queues
{
    public class FinancialTransactionRepeatInvocable : IInvocable, IInvocableWithPayload<FinancialTransaction>
    {
        private IFinancialTransactionRepository _repository;
        public FinancialTransactionRepeatInvocable(IFinancialTransactionRepository repository)
        {
            _repository = repository;
        }
        public FinancialTransaction Payload { get; set; }

        public async Task Invoke()
        {
            var startPoint = 1;
            RegisterNewTransaction(startPoint);

            int transactionSameGroup = await _repository.GetCountTransactionsSameGroup(Payload.Id);
            RegisterNewTransaction(transactionSameGroup);
        }

        private void RegisterNewTransaction(int startPoint)
        {
            if (Payload.Repeat != Domain.Enums.Recurrence.None)
            {
                var repeatTimes = Payload.RepeatTimes - 1;

                for (int i = startPoint; i <= repeatTimes; i++)
                {
                    var financial = new FinancialTransaction();
                    financial.TypeFinancialTransaction = Payload.TypeFinancialTransaction;
                    financial.Description = Payload.Description;
                    financial.ReferenceDate = Payload.ReferenceDate;
                    financial.DueDate = Payload.DueDate;
                    financial.Amount = Payload.Amount;
                    financial.RepeatGroup = Payload.Id;
                    financial.Repeat = Domain.Enums.Recurrence.None;
                    financial.RepeatTimes = null;
                    financial.CreatedAt = DateTimeOffset.Now;

                    financial.CompanyId = Payload.CompanyId;
                    financial.AccountId = Payload.AccountId;
                    financial.CategoryId = Payload.CategoryId;
                    _repository.Add(financial);
                }
            }
        }
    }
}