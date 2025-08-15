using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gestao.Domain
{
    public class Document
    {
        public int Id { get; set; }
        public string Path { get; set; } = null!;
        public int? FinancialTransactionId { get; set; }
        public FinancialTransaction? FinancialTransaction { get; set; }
    }
}