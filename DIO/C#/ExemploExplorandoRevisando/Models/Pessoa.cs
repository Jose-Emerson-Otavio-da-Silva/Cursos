using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ExemploExplorando.Models
{
    public class Pessoa
    {
        //Construtores 
        //um construtor exige o preenchimento de nome e sobrenome
        //O outro não exige o preenchimento de propriedades, permitindo escolher entre preencher ou nao
        public Pessoa() { }
        public Pessoa(string nome, string sobrenome)
        {
            Nome = nome;
            Sobrenome = sobrenome;
        }
        //campos
        private string _nome;
        private int _idade;

        //propriedades
        public string Nome
        {
            // o sinal =>  é uma body expression que significa return
            get => _nome.ToUpper();
            //Validando o set
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("O nome não pode ser vazio.");
                }
                _nome = value;
            }

        }
        public string Sobrenome { get; set; }
        public string NomeCompleto => $"{Nome} {Sobrenome}".ToUpper();
        public int Idade
        {
            // o sinal =>  é uma body expression que significa return
            get => _idade;
            //Validando o set
            set
            {
                if (value < 0)
                {
                    throw new ArgumentException("A idade não pode ser menor que zero.");
                }
                _idade = value;
            }
        }

        public void Apresentar()
        {
            Console.WriteLine($"Nome: {Nome}, Idade: {Idade}");
        }
    }
}