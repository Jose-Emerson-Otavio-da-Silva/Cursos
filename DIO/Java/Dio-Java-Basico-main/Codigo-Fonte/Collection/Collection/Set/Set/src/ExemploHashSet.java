import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ExemploHashSet demonstra o uso básico da classe HashSet em Java.
 * 
 * Um HashSet é uma coleção que utiliza uma tabela hash para armazenar
 * elementos.
 * Ele não permite elementos duplicados e não garante a ordem de inserção dos
 * elementos.
 * 
 * Principais características do HashSet:
 * - Não permite elementos duplicados.
 * - Permite elementos nulos.
 * - Não garante a ordem dos elementos.
 * - Baseado em uma tabela hash para armazenar os elementos.
 * - Operações básicas como adicionar, remover e verificar a existência de um
 * elemento são realizadas em tempo constante O(1).
 * 
 * Este exemplo inclui:
 * - Instanciação de um HashSet.
 * - Adição de elementos ao HashSet.
 * - Remoção de um elemento do HashSet.
 * - Exibição dos elementos do HashSet.
 * - Verificação do tamanho do HashSet.
 * - Iteração sobre os elementos do HashSet usando Iterator e for-each.
 * - Limpeza do HashSet.
 * - Verificação se o HashSet está vazio.
 */
public class ExemploHashSet {

    public static void main(String[] args) throws Exception {

        // Instanciando um HashSet
        Set<Double> notasAlunos = new HashSet<>();

        // Adicionando notas no HashSet
        notasAlunos.add(5.8);
        notasAlunos.add(9.3);
        notasAlunos.add(6.5);
        notasAlunos.add(10.0);
        notasAlunos.add(5.4);
        notasAlunos.add(7.3);
        notasAlunos.add(3.8);
        notasAlunos.add(4.0);
        // Exibindo as notas
        System.out.println(notasAlunos);

        // Removendo a nota 3.8 do Set
        notasAlunos.remove(3.8);
        // Exibindo as notas
        System.out.println(notasAlunos);

        // Retorna a quantidade de itens no Set
        System.out.println(notasAlunos.size());

        // Navega em todos os itens do iterator
        Iterator<Double> iterator = notasAlunos.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Navega em todos os itens usando for-each
        for (Double nota : notasAlunos) {
            System.out.println(nota);
        }

        // Limpa o Set
        notasAlunos.clear();

        // Retorna se o Set está vazio ou não
        System.out.println(notasAlunos.isEmpty());

    }
}
