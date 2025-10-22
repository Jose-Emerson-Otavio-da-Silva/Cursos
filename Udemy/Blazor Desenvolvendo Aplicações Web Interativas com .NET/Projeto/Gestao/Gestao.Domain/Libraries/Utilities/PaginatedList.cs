using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gestao.Client.Libraries.Utilities
{
    public class PaginatedList<T>
    {
        // Construtor que inicializa a lista paginada com os itens, índice da página atual e total de páginas
        public PaginatedList(List<T> items, int pageIndex, int totalPages)
        {
            Items = items;
            PageIndex = pageIndex;
            TotalPages = totalPages;
        }

        // Lista de itens da página atual
        public List<T> Items { get; } = new List<T>();

        // Índice da página atual (começa em 1)
        public int PageIndex { get; }

        // Total de páginas disponíveis
        public int TotalPages { get; }

        // Indica se há uma página anterior
        public bool HasPreviousPage => PageIndex > 1;

        // Indica se há uma próxima página
        public bool HasNextPage => PageIndex < TotalPages;
    }
}