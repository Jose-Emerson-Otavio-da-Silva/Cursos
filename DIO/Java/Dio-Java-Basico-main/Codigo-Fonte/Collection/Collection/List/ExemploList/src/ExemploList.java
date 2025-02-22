import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploList {
    /**
     * Este é um exemplo de uso da classe ArrayList em Java para manipulação de uma
     * lista de nomes.
     * 
     * O código realiza as seguintes operações:
     * - Instancia uma lista de nomes.
     * - Adiciona nomes à lista.
     * - Imprime a lista de nomes.
     * - Ordena a lista de nomes.
     * - Altera o nome na posição 2.
     * - Remove o nome na posição 4.
     * - Remove o nome "Maria".
     * - Recupera o nome na posição 1.
     * - Verifica o tamanho da lista.
     * - Verifica se o nome "Anderson" existe na lista.
     * - Verifica se a lista está vazia.
     * - Recupera a posição do nome "Larissa".
     * - Imprime todos os nomes da lista.
     * - Cria um iterator para percorrer a lista.
     * - Limpa a lista.
     * 
     * Definição de Iterator:
     * Um Iterator é uma interface em Java que permite percorrer uma coleção de
     * elementos, um por um.
     * Ele fornece métodos para verificar se há mais elementos na coleção
     * (hasNext()),
     * acessar o próximo elemento (next()) e remover elementos da coleção
     * (remove()).
     */
    public static void main(String[] args) throws Exception {
        // Instanciando uma lista de nomes
        List<String> nomes = new ArrayList<>();

        // Adicionando nomes na lista
        nomes.add("Carlos");
        nomes.add("Pedro");
        nomes.add("Juliana");
        nomes.add("Anderson");
        nomes.add("Maria");
        nomes.add("João");
        // Imprimindo a lista de nomes
        System.out.println(nomes);

        // Ordenando a lista de nomes
        Collections.sort(nomes);
        // Imprimindo a lista de nomes
        System.out.println(nomes);

        // Alterando o nome na posição 2
        nomes.set(2, "Larissa");
        // Imprimindo a lista de nomes
        System.out.println(nomes);

        // Removendo o nome na posição 4
        nomes.remove(4);
        // Imprimindo a lista de nomes
        System.out.println(nomes);
        // Removendo o nome Maria
        nomes.remove("Maria");
        // Imprimindo a lista de nomes
        System.out.println(nomes);

        // Recuperando o nome na posição 1
        String nome = nomes.get(1);
        // Imprimindo o nome
        System.out.println(nome);

        // verificando o tamanho da lista
        int tamanho = nomes.size();
        // Imprimindo o tamanho da lista
        System.out.println(tamanho);

        // Verificando se o nome Anderson existe na lista
        boolean temAnderson = nomes.contains("Anderson");
        // Imprimindo se o nome Anderson existe na lista"
        System.out.println(temAnderson);

        // Verificando se a lista está vazia
        boolean listaEstaVazia = nomes.isEmpty();
        // Imprimindo se a lista está vazia
        System.out.println(listaEstaVazia);

        // Recuperando a posição do nome Larissa
        int posicao = nomes.indexOf("Larissa"); // quando o nome não existe na lista, o retorno é -1
        // Imprimindo a posição do nome Larissa
        System.out.println(posicao);

        // Imprimindo todos os nomes da lista
        for (String nomeDoItem : nomes) {
            System.out.println("--> " + nomeDoItem);
        }

        // Criando um iterator para percorrer a lista
        Iterator<String> iterator = nomes.iterator();
        // Percorrendo a lista com o iterator
        while (iterator.hasNext()) {
            System.out.println("----> " + iterator.next());
        }

        // Limpando a lista
        nomes.clear();
    }
}
