using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Blazor8.Models
{
    public class Usuario
    {
        public int Id { get; set; }
        public string? Nome { get; set; }
        [Required(ErrorMessage = "O campo Email é obrigatório.")]
        [EmailAddress(ErrorMessage = "O campo Email é inválido.")]
        public string? Email { get; set; }
        [Required(ErrorMessage = "O campo Senha é obrigatório.")]
        [MinLength(8, ErrorMessage = "O campo Senha deve ter no mínimo 8 caracteres.")]
        public string? Senha { get; set; }

    }
}