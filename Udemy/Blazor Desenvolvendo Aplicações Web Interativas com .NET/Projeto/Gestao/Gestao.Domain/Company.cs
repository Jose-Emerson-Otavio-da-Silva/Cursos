using System.ComponentModel.DataAnnotations;
using Microsoft.AspNetCore.Identity;

namespace Gestao.Domain
{
    public class Company
    {
        public Company()
        {
        }

        [RequiredAttribute] public int Id { get; set; }
        [RequiredAttribute] public string LegalName { get; set; } = string.Empty;
        [RequiredAttribute] public string TradeName { get; set; } = string.Empty;
        [RequiredAttribute] public string TaxId { get; set; } = string.Empty;
        [RequiredAttribute] public string PostalCode { get; set; } = string.Empty;
        [RequiredAttribute] public string State { get; set; } = string.Empty;
        [RequiredAttribute] public string City { get; set; } = string.Empty;
        [RequiredAttribute] public string Neighborhood { get; set; } = string.Empty;
        [RequiredAttribute] public string Address { get; set; } = string.Empty;
        public string Complement { get; set; } = string.Empty;
        public DateTimeOffset CreatedAt { get; set; }
        public Guid UserId { get; set; }
        public ApplicationUser? User { get; set; }
    }
}