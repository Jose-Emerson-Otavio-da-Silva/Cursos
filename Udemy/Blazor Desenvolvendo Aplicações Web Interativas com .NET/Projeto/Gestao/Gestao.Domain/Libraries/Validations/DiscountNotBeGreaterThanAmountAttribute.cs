using System.ComponentModel.DataAnnotations;

namespace Gestao.Domain.Libraries.Validations
{
    public class DiscountNotBeGreaterThanAmountAttribute : ValidationAttribute
    {
        protected override ValidationResult? IsValid(object? value, ValidationContext validationContext)
        {
            if (value is null) return ValidationResult.Success;

            FinancialTransaction transaction = (FinancialTransaction)validationContext.ObjectInstance;

            if (transaction.Discount.HasValue && transaction.Amount.HasValue && transaction.Discount > transaction.Amount)
            {
                return new ValidationResult("O desconto não pode ser maior que o Valor.",
                    new[] { validationContext.MemberName! });
            }

            return ValidationResult.Success;
        }
    }
}