import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExemploTreeMap {

    public static void main(String[] args) {

        // Cria um TreeMap
        /**
         * A TreeMap is a map implementation that keeps its entries sorted according to
         * the natural ordering of its keys,
         * or by a comparator provided at map creation time. This implementation
         * provides guaranteed log(n) time cost for
         * the containsKey, get, put and remove operations.
         * 
         * Main characteristics of TreeMap:
         * - It implements the NavigableMap interface and extends AbstractMap class.
         * - It is sorted according to the natural ordering of its keys, or by a
         * comparator provided at map creation time.
         * - It does not allow null keys (throws NullPointerException).
         * - It is not synchronized, but can be synchronized externally using
         * Collections.synchronizedSortedMap.
         * - It provides guaranteed log(n) time cost for the containsKey, get, put and
         * remove operations.
         * - It is backed by a Red-Black tree, which is a self-balancing binary search
         * tree.
         */
        TreeMap<String, String> treeCapitais = new TreeMap<>();

        // Cria um TreeMap com as capitais
        treeCapitais.put("RS", "Porto Alegre");
        treeCapitais.put("SC", "Florianópolis");
        treeCapitais.put("PR", "Curitiba");
        treeCapitais.put("SP", "São Paulo");
        treeCapitais.put("RJ", "Rio de Janeiro");
        treeCapitais.put("MG", "Belo Horizonte");
        // Exibe as capitais
        System.out.println(treeCapitais);

        // Retorna a primeira capital no topo da árvore
        System.out.println(treeCapitais.firstKey());

        // Retorna a última capital no final da árvore
        System.out.println(treeCapitais.lastKey());

        // Retorna a primeira capital abaixo na árvore da capital parametrizada
        System.out.println(treeCapitais.lowerKey("SC"));

        // Retorna a primeira capital acima na árvore da capital parametrizada
        System.out.println(treeCapitais.higherKey("SC"));

        // Exibe todas as capitais no console
        System.out.println(treeCapitais);

        // Retorna a primeira capital no topo da árvore
        System.out.println(treeCapitais.firstEntry().getKey() + " - " + treeCapitais.firstEntry().getValue());

        // Retorna a última capital no final da árvore
        System.out.println(treeCapitais.lastEntry().getKey() + " - " + treeCapitais.lastEntry().getValue());

        // Retorna a primeira capital abaixo na árvore da capital parametrizada
        System.out.println(treeCapitais.lowerEntry("SC").getKey() + " - " + treeCapitais.lowerEntry("SC").getValue());

        // Retorna a primeira capital acima na árvore da capital parametrizada
        System.out.println(treeCapitais.higherEntry("SC").getKey() + " - " + treeCapitais.higherEntry("SC").getValue());

        // Exibe todas as capitais no console
        System.out.println(treeCapitais);

        // Retorna a primeira capital no topo da árvore, removendo do map
        System.out.println(treeCapitais.pollFirstEntry().getKey() + " - " + treeCapitais.pollFirstEntry().getValue());

        // Retorna a primeira capital no final da árvore, removendo do map
        System.out.println(treeCapitais.pollLastEntry().getKey() + " - " + treeCapitais.pollLastEntry().getValue());

        // Exibe todas as capitais no console
        System.out.println(treeCapitais);

        // Navega em todas as chaves do iterator
        Iterator<String> iterator = treeCapitais.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " - " + treeCapitais.get(key));
        }
        // Navega em todas as chaves usando for-each
        for (String capital : treeCapitais.keySet()) {
            System.out.println(capital + " -- " + treeCapitais.get(capital));
        }
        // Navega em todas as chaves usando for-each
        for (Map.Entry<String, String> capital : treeCapitais.entrySet()) {
            System.out.println(capital.getKey() + " --- " + capital.getValue());
        }

    }
}
