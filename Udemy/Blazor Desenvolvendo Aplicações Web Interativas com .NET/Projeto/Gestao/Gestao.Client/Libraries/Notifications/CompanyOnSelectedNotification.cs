using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gestao.Client.Libraries.Notifications
{
    public class CompanyOnSelectedNotification
    {
        public Action? OnCompanySelected { get; set; }
        public void NotificationOnSelected()
        {
            OnCompanySelected?.Invoke();
        }
    }
}