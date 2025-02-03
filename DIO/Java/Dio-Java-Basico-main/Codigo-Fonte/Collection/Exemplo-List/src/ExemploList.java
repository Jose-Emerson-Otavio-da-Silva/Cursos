import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) throws Exception {

        // Cria uma lista e adiciona sete notas
        System.out.println("Crie uma lista e adicione as sete notas: ");
        List<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        System.out.println(notas.toString());

        // Exibe a posição da nota 5.0
        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5d));

        // Adiciona a nota 8.0 na posição 4
        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8.0); // Adiciona na posição 4
        System.out.println(notas);

        // Substitui a nota 5.0 pela nota 6.0
        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d), 6.0);
        System.out.println(notas);

        // Verifica se a nota 5.0 está na lista
        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5d));

        // Exibe todas as notas na ordem em que foram informadas
        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        for (Double nota : notas)
            System.out.println(nota);

        // Exibe a terceira nota adicionada
        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas.toString());

        // Exibe a menor nota
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        // Exibe a maior nota
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        // Calcula e exibe a soma dos valores
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        // Calcula e exibe a média das notas
        System.out.println("Exiba a média das notas: " + (soma / notas.size()));

        // Remove a nota 0.0
        System.out.println("Remova a nota 0.0: ");
        notas.remove(0d);

        // Remove a nota da posição 0
        System.out.println("Remova a nota da posição 0: ");
        notas.remove(0);
        System.out.println(notas);

        // Remove as notas menores que 7 e exibe a lista
        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7)
                iterator1.remove();
        }
        System.out.println(notas);

        // Apaga toda a lista
        System.out.println("Apague toda a lista: ");
        notas.clear();
        System.out.println(notas);

        // Verifica se a lista está vazia
        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());
    }
}
