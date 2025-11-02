using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gestao.Domain.Interfaces
{
    public interface SoftDelete
    {
        DateTimeOffset? DeletedAt { get; set; }
    }
}