

using ExemploExplorando.Models;
using ExemploExplorandoRevisando.Models;


Pessoa p1 = new Pessoa("emerson", "silva");
Pessoa p2 = new Pessoa("danielle", "silva");

Curso cursoDeIngles = new Curso();
cursoDeIngles.Nome = "Ingles";
cursoDeIngles.Alunos = new List<Pessoa>();

cursoDeIngles.AdicionarAlunos(p1);
cursoDeIngles.AdicionarAlunos(p2);
cursoDeIngles.ListarAluno();