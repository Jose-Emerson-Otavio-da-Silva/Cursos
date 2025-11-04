using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gestao.Domain.Interfaces
{
    public interface ISoftDelete
    {
        DateTimeOffset? DeletedAt { get; set; }
    }
}