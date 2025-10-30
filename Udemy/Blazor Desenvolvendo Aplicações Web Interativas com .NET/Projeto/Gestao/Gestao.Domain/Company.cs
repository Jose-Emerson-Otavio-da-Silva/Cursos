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
        [MinLength(5, ErrorMessage = "O campo Razão Social deve ter no mínimo {1} caracteres.")]
        [StringLength(150, ErrorMessage = "O campo Razão Social deve ter no máximo {1} caracteres.")]
        public string LegalName { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Nome Fantasia é obrigatório.")]
        [MinLength(5, ErrorMessage = "O campo Nome Fantasia deve ter no mínimo {1} caracteres.")]
        [StringLength(150, ErrorMessage = "O campo Nome Fantasia deve ter no máximo {1} caracteres.")]
        public string TradeName { get; set; } = string.Empty;

        [CNPJ(ErrorMessage = "O CNPJ informado é inválido.")]
        [Required(ErrorMessage = "O campo CNPJ é obrigatório.")]
        public string TaxId { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo CEP é obrigatório.")]
        [MinLength(9, ErrorMessage = "O campo CEP deve ter {1} caracteres.")]
        public string PostalCode { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Estado é obrigatório.")]
        public string State { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Cidade é obrigatório.")]
        public string City { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Bairro é obrigatório.")]
        public string Neighborhood { get; set; } = string.Empty;

        [Required(ErrorMessage = "O campo Endereço é obrigatório.")]
        [MinLength(5, ErrorMessage = "O campo Endereço deve ter no mínimo {1} caracteres.")]
        public string Address { get; set; } = string.Empty;
        public string Complement { get; set; } = string.Empty;
        public DateTimeOffset CreatedAt { get; set; }
        public Guid UserId { get; set; }
        public ApplicationUser? User { get; set; }
    }
}