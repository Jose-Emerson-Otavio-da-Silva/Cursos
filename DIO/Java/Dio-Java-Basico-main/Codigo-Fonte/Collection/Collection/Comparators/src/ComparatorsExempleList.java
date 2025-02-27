import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorsExempleList {
    public static void main(String[] args) throws Exception {

        // Criar uma lista de estudantes
        List<Estudante> estudantes = new ArrayList<>();

        // Adicionar estudantes à lista
        estudantes.add(new Estudante("Pedro", 19));
        estudantes.add(new Estudante("Carlos", 23));
        estudantes.add(new Estudante("Mariana", 21));
        estudantes.add(new Estudante("João", 18));
        estudantes.add(new Estudante("Thiago", 20));
        estudantes.add(new Estudante("George", 22));
        estudantes.add(new Estudante("Larissa", 21));
        // Imprimir a lista de estudantes
        System.out.println("Lista de estudantes:");

        // Imprimir a lista de estudantes na ordem de inserção
        System.out.println("--- ordem de inserção ---");
        System.out.println(estudantes);

        // Ordenar a lista de estudantes pela idade
        System.out.println("--- ordem de idade ---");
        estudantes.sort(Comparator.comparingInt(Estudante::getIdade));
        System.out.println(estudantes);
        // De outra forma
        estudantes.sort((first, second) -> first.getIdade() - second.getIdade());
        System.out.println(estudantes);
        // De outra forma
        Collections.sort(estudantes);
        System.out.println(estudantes);

        // Ordenar a lista de estudantes pela idade em ordem reversa
        System.out.println("--- ordem de idade reversa ---");
        estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());
        System.out.println(estudantes);
        // De outra forma
        estudantes.sort((first, second) -> second.getIdade() - first.getIdade());
        System.out.println(estudantes);
        // De outra forma
        Collections.sort(estudantes, new EstudanteOrdemIdadeReversaComparator());
        System.out.println(estudantes);

    }
}
