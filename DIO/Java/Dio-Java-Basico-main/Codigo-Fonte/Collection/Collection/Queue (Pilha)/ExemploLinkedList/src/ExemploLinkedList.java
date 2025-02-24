import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Exemplo de uso da classe LinkedList para simular uma fila de banco.
 * 
 * <p>
 * Este exemplo demonstra as seguintes operações em uma fila (Queue) usando
 * LinkedList:
 * <ul>
 * <li>Adicionar elementos à fila</li>
 * <li>Remover e retornar o primeiro elemento da fila</li>
 * <li>Retornar o primeiro elemento da fila sem removê-lo</li>
 * <li>Retornar o primeiro elemento da fila ou lançar uma exceção se a fila
 * estiver vazia</li>
 * <li>Percorrer e imprimir os elementos da fila usando um loop for-each</li>
 * <li>Percorrer e imprimir os elementos da fila usando um Iterator</li>
 * <li>Obter o tamanho da fila</li>
 * <li>Verificar se a fila está vazia</li>
 * <li>Limpar todos os elementos da fila</li>
 * </ul>
 * </p>
 * 
 * <p>
 * A interface Queue é parte do framework de coleções do Java e representa uma
 * coleção
 * projetada para manter elementos antes de processá-los.
 * 
 * <p>
 * Principais características da Queue:
 * <ul>
 * <li>Segue a ordem FIFO (First-In-First-Out)</li>
 * <li>Permite elementos duplicados</li>
 * <li>Permite elementos nulos (dependendo da implementação)</li>
 * <li>Não é thread-safe (a menos que explicitamente sincronizada)</li>
 * <li>Oferece métodos para inserção, remoção e inspeção de elementos</li>
 * </ul>
 * </p>
 */
public class ExemploLinkedList {

    public static void main(String[] args) throws Exception {

        // Instanciando um objeto da classe LinkedList
        Queue<String> filaBanco = new LinkedList<>();
        filaBanco.add("Patricia");
        filaBanco.add("Roberto");
        filaBanco.add("Flavio");
        filaBanco.add("Pamela");
        filaBanco.add("Anderson");
        System.out.println(filaBanco);

        // Retorna o primeiro elemento da fila e o remove
        String clienteASerAtendido = filaBanco.poll();
        System.out.println(clienteASerAtendido);
        System.out.println(filaBanco);

        // Retorna o primeiro elemento da fila e o mantém na fila
        String primeiroCliente = filaBanco.peek();
        System.out.println(primeiroCliente);
        System.out.println(filaBanco);

        // Retorna o primeiro elemento da fila ou retorna uma exceção caso a
        // fila esteja vazia
        String primeiroClienteOuErro = filaBanco.element();
        System.out.println(primeiroClienteOuErro);
        System.out.println(filaBanco);

        // Percorre a fila e imprime cada elemento
        for (String cliente : filaBanco) {
            System.out.println(cliente);
        }

        // Percorre a fila usando Iterator e imprime cada elemento
        Iterator<String> iteratorFilaBanco = filaBanco.iterator();
        while (iteratorFilaBanco.hasNext()) {
            System.out.println("-> " + iteratorFilaBanco.next());
        }

        // Retorna o tamanho da fila
        System.out.println(filaBanco.size());

        // Verifica se a fila está vazia
        System.out.println(filaBanco.isEmpty());

        // Limpa a fila
        filaBanco.clear();

    }
}
