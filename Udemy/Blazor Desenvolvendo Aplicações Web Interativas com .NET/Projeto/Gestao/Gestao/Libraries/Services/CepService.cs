using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gestao.Libraries.Services
{
    public class CepService : ICepService
    {
        public Task<LocalAddress?> SearchByPostalCode(string postalCode)
        {
            var http = new HttpClient();
            var url = $"https://viacep.com.br/ws/{postalCode.Replace(".", string.Empty).Replace("-", string.Empty)}/json/";
            return http.GetFromJsonAsync<LocalAddress?>(url);
        }
    }

    public class LocalAddress
    {
        public string Cep { get; set; } = string.Empty;
        public string Logradouro { get; set; } = string.Empty;
        public string Complemento { get; set; } = string.Empty;
        public string Unidade { get; set; } = string.Empty;
        public string Bairro { get; set; } = string.Empty;
        public string Localidade { get; set; } = string.Empty;
        public string Uf { get; set; } = string.Empty;
        public string Estado { get; set; } = string.Empty;
        public string Regiao { get; set; } = string.Empty;
        public string Ibge { get; set; } = string.Empty;
        public string Gia { get; set; } = string.Empty;
        public string Ddd { get; set; } = string.Empty;
        public string Siafi { get; set; } = string.Empty;
    }
}
