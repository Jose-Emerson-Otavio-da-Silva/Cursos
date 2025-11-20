using System.ComponentModel.DataAnnotations;
using Gestao.Domain.Enums;
using Gestao.Domain.Interfaces;
using Gestao.Domain.Libraries.Validations;

namespace Gestao.Domain
{
    public class FinancialTransaction : ISoftDelete
    {
        public int Id { get; set; }
        public TypeFinancialTransaction TypeFinancialTransaction { get; set; }
        [Required(ErrorMessage = "O campo é obrigatório.")]
        [MinLength(3, ErrorMessage = "O campo deve ter no mínimo {1} caracteres.")]
        [StringLength(150, ErrorMessage = "O campo deve ter no máximo {1} caracteres.")]
        public string Description { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo é obrigatório.")]
        [Range(typeof(DateTimeOffset), "1/1/1999", "1/1/2200", ErrorMessage = "O data deve estar entre {1:dd/MM/yyyy} e {2:dd/MM/yyyy}.")]
        public DateTimeOffset ReferenceDate { get; set; }
        [RequiredIfAmoundPaidFilledAttribute]
        [Range(typeof(DateTimeOffset), "1/1/1999", "1/1/2200", ErrorMessage = "O data deve estar entre {1:dd/MM/yyyy} e {2:dd/MM/yyyy}.")]
        public DateTimeOffset? DueDate { get; set; }
        [Range(0.01, double.MaxValue, ErrorMessage = "O campo deve ser maior que zero.")]
        [RequiredIfAmoundPaidFilledAttribute]
        public decimal? Amount { get; set; }
        public Recurrence Repeat { get; set; }
        [Range(1, 9999, ErrorMessage = "O campo deve ter entre {1} e {2}.")]
        [RequiredRepeatTimes]
        public int? RepeatTimes { get; set; }
        [Range(0, double.MaxValue, ErrorMessage = "O campo deve ser maior que zero.")]
        public decimal? InterestPenalty { get; set; }
        [Range(0, double.MaxValue, ErrorMessage = "O campo deve ser maior que zero.")]
        [DiscountNotBeGreaterThanAmountAttribute]
        public decimal? Discount { get; set; }
        [Range(typeof(DateTimeOffset), "1/1/1999", "1/1/2200", ErrorMessage = "O data deve estar entre {1:dd/MM/yyyy} e {2:dd/MM/yyyy}.")]
        [RequiredIfAmoundPaidFilledAttribute]
        public DateTimeOffset? PaymentDate { get; set; }
        [Range(0.01, double.MaxValue, ErrorMessage = "O campo deve ser maior que zero.")]
        [AmoundPaidValueAttribute]
        public decimal? AmountPaid { get; set; }
        public string? Observation { get; set; }
        public DateTimeOffset CreatedAt { get; set; }
        public DateTimeOffset? DeletedAt { get; set; }
        public ICollection<Document>? Documents { get; set; }
        public int? CompanyId { get; set; }
        public Company? Company { get; set; }
        [RequiredIfAmoundPaidFilledAttribute]
        public int? AccountId { get; set; }
        public Account? Account { get; set; }
        [RequiredIfAmoundPaidFilledAttribute]
        public int? CategoryId { get; set; }
        public Category? Category { get; set; }
    }
}