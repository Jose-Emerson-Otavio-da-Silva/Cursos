using Gestao.Domain.Interfaces;

namespace Gestao.Domain
{
    public class Account : ISoftDelete
    {
        public int Id { get; set; }
        public string Description { get; set; } = string.Empty;
        public decimal Balance { get; set; }
        public DateTimeOffset BalanceDate { get; set; }
        public int? CompanyId { get; set; }
        public Company? Company { get; set; }
        public DateTimeOffset CreatedAt { get; set; }
        public DateTimeOffset? DeletedAt { get; set; }
    }
}