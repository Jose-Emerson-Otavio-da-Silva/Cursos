import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercicio {
    public static void main(String[] args) {
        // Criando uma lista de nomes
        List<String> nomes = new ArrayList<>();

        // Adicionando 5 nomes
        nomes.add("Juliana");
        nomes.add("Pedro");
        nomes.add("Carlos");
        nomes.add("Larissa");
        nomes.add("João");

        // Navegue na lista exibindo cada nome no console
        for (String nome : nomes) {
            System.out.println(nome);
        }

        // Substitua o nome Carlos por Roberto
        nomes.set(2, "Roberto");

        // Retorne o nome da posição 1
        String nomePosicaoUm = nomes.get(1);
        System.out.println(nomePosicaoUm);

        // Remova o nome da posição 4
        nomes.remove(4);

        // Remova o nome João
        nomes.remove("João");

        // Retorne a quantidade de itens na lista
        int quantidadeItensNaLista = nomes.size();
        System.out.println("Quantidade de itens na lista: " + quantidadeItensNaLista);

        // Verifique se o nome Juliano existe na lista
        boolean temNomeNaLista = nomes.contains("Juliano");
        System.out.println("Tem Juliano na lista? " + temNomeNaLista);

        // Crie uma nova lista com os nomes: Ismael e Rodrigo. Adicione todos os itens
        // da nova lista na lista criada
        List<String> novosNomes = new ArrayList<>();
        novosNomes.add("Ismael");
        novosNomes.add("Rodrigo");
        nomes.addAll(novosNomes);

        // Ordene os itens da lista por ordem alfabética
        Collections.sort(nomes);
        System.out.println(nomes);

        // Verifique se a lista está vazia
        boolean listaEstaVazia = nomes.isEmpty();
        System.out.println("A lista está vazia? " + listaEstaVazia);

    }

}
