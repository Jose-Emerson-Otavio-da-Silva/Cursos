package br.com.dio.collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploOrdenacao {
    public static void main(String[] args) throws Exception {
        Map<String, Livro> meusLivros = new HashMap<>() {
            {
                put("Hawking, Stephen - Uma Breve História do Tempo",
                        new Livro("Uma Breve História do Tempo", 256));
                put("Duhigg, Charles - O Poder do Hábito", new Livro("O Poder do Hábito", 408));
                put("Harari, Yuval Noah - 21 Lições para o Século 21", new Livro("21 Lições para o Século 21", 432));
            }
        };
        for (Map.Entry<String, Livro> ivro : meusLivros.entrySet()) {
            System.out.println(ivro.getKey() + " - " + ivro.getValue());
        }

        System.out.println("\nOrdenando por ordem de inserção");
        Map<String, Livro> meusLivrosLinked = new LinkedHashMap<>() {
            {
                {
                    put("Hawking, Stephen - Uma Breve História do Tempo",
                            new Livro("Uma Breve História do Tempo", 256));
                    put("Duhigg, Charles - O Poder do Hábito", new Livro("O Poder do Hábito", 408));
                    put("Harari, Yuval Noah - 21 Lições para o Século 21",
                            new Livro("21 Lições para o Século 21", 432));
                }
            }
        };
        for (Map.Entry<String, Livro> livro : meusLivrosLinked.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\nOrdem alfabética dos autores");
        Map<String, Livro> meusLivrosTree = new TreeMap<>(meusLivros);
        for (Map.Entry<String, Livro> livro : meusLivrosTree.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\nOrdem alfabética dos livros");
        Set<Map.Entry<String, Livro>> meusLivrosSet = new TreeSet<>(new ComparatorNome());
        meusLivrosSet.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivrosSet) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }
    }

    static class Livro {
        private String nome;
        private Integer paginas;

        public Livro(String nome, Integer paginas) {
            this.nome = nome;
            this.paginas = paginas;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Livro livro = (Livro) o;
            return nome.equals(livro.nome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome);
        }

    }

    static class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {
        @Override
        public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
            return l1.getValue().getNome().compareTo(l2.getValue().getNome());
        }
    }
}
