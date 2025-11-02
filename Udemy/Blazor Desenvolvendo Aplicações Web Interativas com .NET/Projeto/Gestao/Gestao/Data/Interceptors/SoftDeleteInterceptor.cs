using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Diagnostics;

namespace Gestao.Data.Interceptors
{
    public class SoftDeleteInterceptor : SaveChangesInterceptor
    {
        public override InterceptionResult<int> SavingChanges(DbContextEventData eventData, InterceptionResult<int> result)
        {

            if (eventData.Context is null) return base.SavingChanges(eventData, result);

            foreach (var entry in eventData.Context.ChangeTracker.Entries())
            {
                if (entry.Entity is Domain.Interfaces.SoftDelete softDeleteEntity)
                {
                    if (entry.State == EntityState.Deleted)
                    {
                        entry.State = EntityState.Modified;
                        softDeleteEntity.DeletedAt = DateTimeOffset.UtcNow;
                    }
                }
            }

            return base.SavingChanges(eventData, result);
        }
    }
}