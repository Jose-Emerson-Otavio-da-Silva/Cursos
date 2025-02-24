import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Exercicio {
    public static void main(String[] args) {

        // Crie uma fila de 5 nomes
        Queue<String> nomes = new LinkedList<>();

        // Adicione 5 nomes: Juliana, Pedro, Carlos, Larissa e João
        nomes.add("Juliana");
        nomes.add("Pedro");
        nomes.add("Carlos");
        nomes.add("Larissa");
        nomes.add("João");

        // Navegue na fila exibindo cada nome no console
        for (String nome : nomes) {
            System.out.println(nome);
        }

        // Navegue na fila usando Iterator exibindo cada nome no console
        Iterator<String> iteratorNomes = nomes.iterator();
        while (iteratorNomes.hasNext()) {
            System.out.println("--->" + iteratorNomes.next());
        }

        // Retorne o primeiro item da fila, sem removê-lo
        System.out.println("Primeiro item da fila: " + nomes.peek());

        // Retorne o primeiro item da fila, removendo o mesmo
        System.out.println("Primeiro item da fila removido: " + nomes.poll());

        // Adicione um novo nome: Daniel. Verifique a posição que o mesmo assumiu na
        // fila
        nomes.add("Daniel");
        System.out.println("Posição de Daniel na fila: " + nomes.size());

        // Retorne o tamanho da fila
        System.out.println("Tamanho da fila: " + nomes.size());

        // Verifique se a fila está vazia
        System.out.println("Fila está vazia? " + nomes.isEmpty());

        // Verifique se o nome Carlos está na fila
        System.out.println("Carlos está na fila? " + nomes.contains("Carlos"));

    }

}
