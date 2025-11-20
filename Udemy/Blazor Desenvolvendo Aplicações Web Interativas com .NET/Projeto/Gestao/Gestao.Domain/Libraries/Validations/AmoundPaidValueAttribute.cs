using System.ComponentModel.DataAnnotations;

namespace Gestao.Domain.Libraries.Validations
{
    public class AmoundPaidValueAttribute : ValidationAttribute
    {
        protected override ValidationResult? IsValid(object? value, ValidationContext validationContext)
        {
            if (value is null) return ValidationResult.Success;

            FinancialTransaction transaction = (FinancialTransaction)validationContext.ObjectInstance;
            decimal totalAmount = 0;

            if (transaction.Amount.HasValue)
            {
                totalAmount += transaction.Amount.Value;
                if (transaction.InterestPenalty.HasValue)
                {
                    totalAmount += transaction.InterestPenalty.Value;
                }
                if (transaction.Discount.HasValue)
                {
                    totalAmount -= transaction.Discount.Value;
                }
                if (totalAmount != transaction.AmountPaid)
                {
                    return new ValidationResult("Valor incorreto, verifique o Valor, Juros/Mutas e Desconto. Valor esperado: " + totalAmount.ToString("F2"),
                        new[] { validationContext.MemberName! });
                }
            }
            return ValidationResult.Success;
        }
    }
}