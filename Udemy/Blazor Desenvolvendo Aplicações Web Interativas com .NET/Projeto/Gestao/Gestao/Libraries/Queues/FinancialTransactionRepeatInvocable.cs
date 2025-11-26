using Coravel.Invocable;
using Gestao.Domain;

namespace Gestao.Libraries.Queues
{
    public class FinancialTransactionRepeatInvocable : IInvocable, IInvocableWithPayload<FinancialTransaction>
    {
        public FinancialTransaction Payload { get; set; }

        Task IInvocable.Invoke()
        {
            throw new NotImplementedException();
        }
    }
}