using System.ComponentModel.DataAnnotations;
using Gestao.Domain.Libraries.Validations;

namespace Gestao.Domain
{
    public class Company
    {
        public Company()
        {
        }

        public int Id { get; set; }

        [Required(ErrorMessage = "O campo Razão Social é obrigatório.")]
        [StringLength(150, ErrorMessage = "O campo Razão Social deve ter no máximo {1} caracteres.")]
        public string LegalName { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Nome Fantasia é obrigatório.")]
        [StringLength(150, ErrorMessage = "O campo Nome Fantasia deve ter no máximo {1} caracteres.")]
        public string TradeName { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo CNPJ é obrigatório.")]
        [RegularExpression(@"^\d{14}$", ErrorMessage = "O CNPJ deve conter exatamente 14 dígitos, apenas números.")]
        [CNPJ(ErrorMessage = "O CNPJ informado é inválido.")]
        public string TaxId { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo CEP é obrigatório.")]
        [RegularExpression(@"^\d{8}$", ErrorMessage = "O CEP deve conter 8 dígitos, apenas números.")]
        public string PostalCode { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Estado é obrigatório.")]
        [StringLength(2, ErrorMessage = "O Estado deve ter 2 caracteres (UF).")]
        public string State { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Cidade é obrigatório.")]
        [StringLength(100, ErrorMessage = "O campo Cidade deve ter no máximo {1} caracteres.")]
        public string City { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Bairro é obrigatório.")]
        [StringLength(100, ErrorMessage = "O campo Bairro deve ter no máximo {1} caracteres.")]
        public string Neighborhood { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Endereço é obrigatório.")]
        [StringLength(200, ErrorMessage = "O campo Endereço deve ter no máximo {1} caracteres.")]
        public string Address { get; set; } = string.Empty;
        public string Complement { get; set; } = string.Empty;
        public DateTimeOffset CreatedAt { get; set; }
        public Guid UserId { get; set; }
        public ApplicationUser? User { get; set; }
    }
}