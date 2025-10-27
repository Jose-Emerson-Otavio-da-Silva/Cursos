using Microsoft.AspNetCore.Identity;

namespace Gestao.Domain
{
    public class Company
    {
        public Company()
        {
        }

        public int Id { get; set; }
        public string LegalName { get; set; } = string.Empty;
        public string TradeName { get; set; } = string.Empty;
        public string TaxId { get; set; } = string.Empty;
        public string PostalCode { get; set; } = string.Empty;
        public string State { get; set; } = string.Empty;
        public string City { get; set; } = string.Empty;
        public string Neighborhood { get; set; } = string.Empty;
        public string Address { get; set; } = string.Empty;
        public string Complement { get; set; } = string.Empty;
        public DateTimeOffset CreatedAt { get; set; }
        public Guid UserId { get; set; }
        public required ApplicationUser User { get; set; }
    }
}