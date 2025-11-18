using System.ComponentModel.DataAnnotations;

namespace Gestao.Domain.Enums
{
    public enum Recurrence
    {
        [Display(Name = "Não repetir")]
        None,
        [Display(Name = "Semanalmente")]
        Weekly,
        [Display(Name = "Mensalmente")]
        Monthly,
        [Display(Name = "Anualmente")]
        Yearly
    }
}