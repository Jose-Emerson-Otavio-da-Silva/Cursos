
using Gestao.Domain.Interfaces;
using Microsoft.AspNetCore.Identity;

namespace Gestao.Domain
{
    // Add profile data for application users by adding properties to the ApplicationUser class
    public class ApplicationUser : IdentityUser, ISoftDelete
    {
        public DateTimeOffset? DeletedAt { get; set; }
    }
}
