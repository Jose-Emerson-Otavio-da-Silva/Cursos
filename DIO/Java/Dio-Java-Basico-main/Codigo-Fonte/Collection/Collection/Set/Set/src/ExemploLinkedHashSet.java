import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * ExemploLinkedHashSet demonstra o uso da classe LinkedHashSet em Java.
 * 
 * LinkedHashSet é uma implementação da interface Set que usa uma tabela de hash
 * com uma lista vinculada
 * para armazenar os elementos. Ele mantém a ordem de inserção dos elementos, ou
 * seja, os elementos são
 * armazenados na ordem em que foram adicionados.
 * 
 * Principais características do LinkedHashSet:
 * - Não permite elementos duplicados.
 * - Mantém a ordem de inserção dos elementos.
 * - Permite elementos nulos.
 * - Não é sincronizado, ou seja, não é seguro para uso em ambientes com
 * múltiplas threads sem sincronização externa.
 * 
 * Este exemplo inclui:
 * - Instanciação de um LinkedHashSet.
 * - Adição de elementos ao LinkedHashSet.
 * - Remoção de um elemento do LinkedHashSet.
 * - Exibição dos elementos do LinkedHashSet.
 * - Verificação do tamanho do LinkedHashSet.
 * - Iteração sobre os elementos do LinkedHashSet usando Iterator e for-each.
 * - Limpeza do LinkedHashSet.
 * - Verificação se o LinkedHashSet está vazio.
 */
public class ExemploLinkedHashSet {

    public static void main(String[] args) {

        // Instanciando um LinkedHashSet
        LinkedHashSet<Integer> sequenciaNumerica = new LinkedHashSet<>();

        // Adicionando números no Set
        sequenciaNumerica.add(1);
        sequenciaNumerica.add(2);
        sequenciaNumerica.add(4);
        sequenciaNumerica.add(8);
        sequenciaNumerica.add(16);
        // Exibindo os números
        System.out.println(sequenciaNumerica);

        // Removendo o número 4 do Set
        sequenciaNumerica.remove(4);
        // Exibindo os números
        System.out.println(sequenciaNumerica);

        // Retorna a quantidade de itens no Set
        System.out.println(sequenciaNumerica.size());

        // Navega em todos os itens do iterator
        Iterator<Integer> iterator = sequenciaNumerica.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Navega em todos os itens usando for-each
        for (Integer numero : sequenciaNumerica) {
            System.out.println(numero);
        }

        // Limpa o Set
        sequenciaNumerica.clear();

        // Retorna se o Set está vazio ou não
        System.out.println(sequenciaNumerica.isEmpty());

    }

}
