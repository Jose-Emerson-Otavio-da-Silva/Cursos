using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components.Authorization;

namespace Gestao.Client.Libraries.Helpers
{
    public class AuthenticationHelper
    {
        public static async Task<Guid?> GetAuthenticationdUserIdAsync(AuthenticationStateProvider authenticationStateProvider)
        {
            var authenticationState = await authenticationStateProvider.GetAuthenticationStateAsync();
            var userId = authenticationState.User.Claims.FirstOrDefault(a => a.Type == ClaimTypes.NameIdentifier);

            if (userId != null && Guid.TryParse(userId.Value, out var applicationUserId))
            {
                return applicationUserId;
            }
            else
            {
                return null;
            }
        }
    }
}