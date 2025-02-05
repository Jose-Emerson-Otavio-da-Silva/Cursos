import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        // Cria uma lista de gatos usando uma inicialização anônima
        List<Gato> meusGatos = new ArrayList<>() {
            { // Adiciona três objetos Gato à lista
                add(new Gato("Jon", 18, "preto"));
                add(new Gato("Simba", 6, "tigrado"));
                add(new Gato("Jon", 12, "amarelo"));
            }
        };

        // Exibe a lista na ordem de inserção
        System.out.println("--\tOrdem de inserção\t--");
        System.out.println(meusGatos);

        // Embaralha a lista de forma aleatória e exibe
        System.out.println("--\tOrdem aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        // Ordena a lista pela ordem natural (nome) e exibe
        System.out.println("--\tOrdem natural (Nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        // Ordena a lista pela idade usando um comparador e exibe
        System.out.println("--\tOrdem Idade\t--");
        meusGatos.sort(new CompatatorIdade());
        System.out.println(meusGatos);

        // Ordena a lista pela cor usando um comparador e exibe
        System.out.println("--\tOrdem cor\t--");
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        // Ordena a lista por nome, depois cor, depois idade usando um comparador e
        // exibe
        System.out.println("--\tOrdem Nome/Cor/Idade\t--");
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
    }
}

class Gato implements Comparable<Gato> {
    private String nome;
    private Integer idade;
    private String cor;

    // Construtor da classe Gato
    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    // Método getter para obter o nome do gato
    public String getNome() {
        return nome;
    }

    // Método getter para obter a idade do gato
    public Integer getIdade() {
        return idade;
    }

    // Método getter para obter a cor do gato
    public String getCor() {
        return cor;
    }

    // Método toString para representar o objeto Gato como uma string
    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    // Implementação do método compareTo para comparar gatos pelo nome, ignorando
    // maiúsculas e minúsculas
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

// Classe Comparator para comparar gatos pela idade
class CompatatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }

}

// Classe Comparator para comparar gatos pela cor
class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }

}

// Classe Comparator para comparar gatos pelo nome, depois pela cor, e por fim
// pela idade
class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        // Primeiro compara pelo nome
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0)
            return nome;

        // Se os nomes forem iguais, compara pela cor
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0)
            return cor;

        // Se os nomes e as cores forem iguais, compara pela idade
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }

}
