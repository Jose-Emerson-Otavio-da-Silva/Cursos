import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

// Classe principal que demonstra a ordenação de um conjunto de séries
public class ExemploOrdenacaoSet {
    public static void main(String[] args) throws Exception {
        // Exemplo de ordenação aleatória usando HashSet
        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>() {
            {
                add(new Serie("got", "fantasia", 60));
                add(new Serie("dark", "Drama", 60));
                add(new Serie("that '70s show", "comédia", 25));
            }
        };
        for (Serie serie : minhasSeries)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        // Exemplo de ordenação por ordem de inserção usando LinkedHashSet
        System.out.println("--\tOrdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {
            {
                add(new Serie("got", "fantasia", 60));
                add(new Serie("dark", "Drama", 60));
                add(new Serie("that '70s show", "comédia", 25));
            }
        };
        for (Serie serie : minhasSeries1)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        // Exemplo de ordenação natural (por tempo de episódio) usando TreeSet
        System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie : minhasSeries2)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        // Exemplo de ordenação por Nome, Gênero e Tempo de Episódio usando TreeSet com
        // Comparator
        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new compareToNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie : minhasSeries3)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
}

// Classe que representa uma série e implementa a interface Comparable para
// ordenação natural
class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Serie serie = (Serie) o;

        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = this.genero.compareTo(serie.getGenero());
        if (tempoEpisodio != 0)
            return tempoEpisodio;
        return this.getGenero().compareTo(serie.getGenero());
    }
}

// Classe que implementa Comparator para ordenar séries por Nome, Gênero e Tempo
// de Episódio
class compareToNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0)
            return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0)
            return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }

}
