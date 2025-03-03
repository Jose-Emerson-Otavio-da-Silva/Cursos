namespace Blazor8.Models
{
    public class NumeroAleatorio
    {
        public int NumeroIdentificador { get; set; }

        public NumeroAleatorio()
        {
            Random rnd = new Random();
            NumeroIdentificador = rnd.Next(1, 100);
        }
    }
}