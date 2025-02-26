import java.util.Iterator;
import java.util.TreeSet;

/**
 * ExemploTreeSet demonstra o uso da classe TreeSet em Java.
 * 
 * TreeSet é uma implementação de NavigableSet baseada em um TreeMap. Os
 * elementos em um TreeSet são ordenados de acordo com sua ordenação natural, ou
 * por um Comparator fornecido no momento da criação do conjunto, dependendo de
 * qual construtor é usado.
 * 
 * Principais características do TreeSet:
 * - Armazena elementos em ordem crescente e ordenada.
 * - Não permite elementos duplicados.
 * - Fornece métodos para navegar pelo conjunto (por exemplo, first(), last(),
 * lower(), higher()).
 * - Oferece custo de tempo log(n) para as operações básicas (add, remove,
 * contains).
 * - Não é sincronizado, mas pode ser sincronizado externamente usando
 * Collections.synchronizedSortedSet.
 * 
 * Este exemplo inclui:
 * - Adição de elementos ao TreeSet.
 * - Exibição do TreeSet.
 * - Recuperação dos primeiros e últimos elementos.
 * - Encontrar elementos menores e maiores que um determinado elemento.
 * - Remoção dos primeiros e últimos elementos.
 * - Iteração pelo TreeSet usando um iterator e um loop for-each.
 */
public class ExemploTreeSet {

    public static void main(String[] args) {

        // Instanciando um TreeSet
        TreeSet<String> treeCapitais = new TreeSet<>();

        // Montando a árvore com as capitais
        treeCapitais.add("Porto Alegre");
        treeCapitais.add("Florianópolis");
        treeCapitais.add("Curitiba");
        treeCapitais.add("São Paulo");
        treeCapitais.add("Rio de Janeiro");
        treeCapitais.add("Belo Horizonte");
        // Exibindo as capitais
        System.out.println(treeCapitais);

        // Retorna a primeira capital no topo da árvore
        System.out.println(treeCapitais.first());

        // Retorna a última capital no final da árvore
        System.out.println(treeCapitais.last());

        // Retorna a primeira capital abaixo na árvore da capital parametrizada
        System.out.println(treeCapitais.lower("Florianópolis"));

        // Retorna a primeira capital acima na árvore da capital parametrizada
        System.out.println(treeCapitais.higher("Florianópolis"));

        // Exibe todas as capitais no console
        System.out.println(treeCapitais);

        // Retorna a primeira capital no topo da árvore, removendo do set
        System.out.println(treeCapitais.pollFirst());

        // Retorna a primeira capital no final da árvore, removendo do set
        System.out.println(treeCapitais.pollLast());

        // Exibe todas as capitais no console
        System.out.println(treeCapitais);

        // Navega em todos os itens do iterator
        Iterator<String> iterator = treeCapitais.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Navega em todos os itens usando for-each
        for (String capital : treeCapitais) {
            System.out.println(capital);
        }
    }
}
