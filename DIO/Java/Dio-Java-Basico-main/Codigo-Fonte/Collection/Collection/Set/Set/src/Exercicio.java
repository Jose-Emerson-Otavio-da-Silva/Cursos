import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercicio {
    public static void main(String[] args) {
        // Instanciando um HashSet
        Set<Integer> numeros = new HashSet<>();

        // Adicionando notas no HashSet
        numeros.add(3);
        numeros.add(88);
        numeros.add(20);
        numeros.add(44);
        numeros.add(3);
        // Exibindo as notas
        System.out.println(numeros);

        // Navegue no set exibindo cada número no console
        Iterator<Integer> iterator = numeros.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // usando for each
        for (Integer nota : numeros) {
            System.out.println(nota);
        }

        // Remova o primeiro item do Set
        numeros.remove(3);
        // Exibindo as notas
        System.out.println(numeros);

        // Adcione um novo numero no set: 23
        numeros.add(23);

        // Verifica o tamanho do Set
        System.out.println(numeros.size());

        // Verifica se o Set está vazio
        System.out.println(numeros.isEmpty());
    }

}
