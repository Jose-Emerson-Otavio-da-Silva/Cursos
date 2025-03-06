import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio {

    public static void main(String[] args) {

        // Utilizando uma lista de objeto complexo (Estudante) com os seguintes
        // atributos:
        // nome, idade e matricula
        // criar uma lista com 7 estudantes
        List<Estudante> estudantes = new ArrayList<>();

        // Adiciona 7 estudantes para a coleção
        estudantes.add(new Estudante("Pedro", 20, 12345));
        estudantes.add(new Estudante("Thayse", 21, 12346));
        estudantes.add(new Estudante("Marcelo", 22, 12347));
        estudantes.add(new Estudante("Carla", 23, 12348));
        estudantes.add(new Estudante("Juliana", 24, 12349));
        estudantes.add(new Estudante("Thiago", 25, 12350));
        estudantes.add(new Estudante("Rafael", 26, 12351));

        // Transforme cada estudante em uma string com os atributos do objeto
        List<String> estudantesString = estudantes.stream()
                .map(estudante -> "Nome: " + estudante.getNome() + ", Idade: " + estudante.getIdade() + ", Matricula: "
                        + estudante.getMatricula())
                .collect(Collectors.toList());
        estudantesString.forEach(System.out::println);

        // Conte a quantidade de estudantes na coleção
        System.out.println("Quantidade de estudantes: " + estudantes.stream().count());

        // Filtre estudantes com idade igual ou superior a 18 anos
        System.out.println("Estudantes com idade igual ou superior a 18 anos: ");
        estudantes.stream()
                .filter(estudante -> estudante.getIdade() >= 18)
                .forEach(estudante -> System.out.println(estudante.getNome()));

        // Exiba cada estudante
        System.out.println("Estudantes: ");
        estudantes.forEach(estudante -> System.out.println(estudante.getNome()));

        // Retorne estudantes com nome que possuem a letra B
        System.out.println("Estudantes com nome que possuem a letra B: ");
        estudantes.stream()
                .filter(estudante -> estudante.getNome().toLowerCase().contains("b"))
                .forEach(estudante -> System.out.println(estudante.getNome()));

        // Retorne se existe ao menos um estudante com a letra D no nome
        System.out.println("Existe ao menos um estudante com a letra D no nome? "
                + estudantes.stream().anyMatch(estudante -> estudante.getNome().toLowerCase().contains("d")));

        // Retorne o estudante mais velho
        System.out.println("Estudante mais velho: " + estudantes.stream()
                .max((estudante1, estudante2) -> estudante1.getIdade() - estudante2.getIdade()).get());

        // Retorne o estudante mais novo
        System.out.println("Estudante mais novo: " + estudantes.stream()
                .min((estudante1, estudante2) -> estudante1.getIdade() - estudante2.getIdade()).get());

    }

}
