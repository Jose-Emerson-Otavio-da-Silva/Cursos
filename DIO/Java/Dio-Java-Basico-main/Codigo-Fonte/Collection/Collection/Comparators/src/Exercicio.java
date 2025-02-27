import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Exercicio {

    public static void main(String[] args) {

        // Crie uma lista de um objeto complexo
        List<Estudante> estudantes = new ArrayList<>();

        // Adicione elementos a lista
        estudantes.add(new Estudante("Pedro", 19));
        estudantes.add(new Estudante("Carlos", 23));
        estudantes.add(new Estudante("Mariana", 21));
        estudantes.add(new Estudante("João", 18));
        estudantes.add(new Estudante("Thiago", 20));

        // Ordene implementando a interface Comparator no seu objeto complexo
        estudantes.sort(Comparator.comparingInt(Estudante::getIdade));
        System.out.println(estudantes);

        // Ordene implementando um novo objeto com a interface Comparator
        estudantes.sort(new EstudanteOrdemIdadeReversaComparator());
        System.out.println(estudantes);

        // Ordene usando uma expressão lambda na chamada de suaLista.sort()
        estudantes.sort((first, second) -> first.getIdade() - second.getIdade());

        // Ordene usando referências de métodos e os métodos estáticos de Comparator
        estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());
        System.out.println(estudantes);

        // Ordene colecoes TreeSet e TreeMap
        TreeSet<Estudante> estudantesTreeSet = new TreeSet<>(estudantes);
    }

}
