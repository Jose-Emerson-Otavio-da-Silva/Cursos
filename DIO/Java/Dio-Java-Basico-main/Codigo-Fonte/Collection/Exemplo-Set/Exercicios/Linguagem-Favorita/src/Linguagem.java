import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Linguagem {

    public static void main(String[] args) throws Exception {

        System.out.println("Criar tres conjuntos de objetos linguagemFavorita");
        LinguagemFavorita linguagem1 = new LinguagemFavorita("Java", 1995, "IntelliJ IDEA");
        LinguagemFavorita linguagem2 = new LinguagemFavorita("Python", 1991, "PyCharm");
        LinguagemFavorita linguagem3 = new LinguagemFavorita("JavaScript", 1995, "Visual Studio Code");

        Set<LinguagemFavorita> linguagensFavoritas = new HashSet<>();
        linguagensFavoritas.add(linguagem1);
        linguagensFavoritas.add(linguagem2);
        linguagensFavoritas.add(linguagem3);

        System.out.println("Imprimir os objetos de linguagemFavorita em ordem de inserção");
        Set<LinguagemFavorita> LinguagensFavoritas1 = new LinkedHashSet<>(
                Arrays.asList(
                        new LinguagemFavorita("Python", 1991, "Pycharm"),
                        new LinguagemFavorita("JavaScript", 1995, "IntelliJ"),
                        new LinguagemFavorita("Java", 1991, "Visual Studio Code")));
        for (LinguagemFavorita linguagem : LinguagensFavoritas1)
            System.out.println(linguagem);

        System.out.println("Imprimir ordem natural (nome)");
        Set<LinguagemFavorita> LinguagensFavoritas2 = new TreeSet<>(linguagensFavoritas);
        for (LinguagemFavorita linguagem : LinguagensFavoritas2)
            System.out.println(linguagem);

        System.out.println("Imprimir ordem ide");
        Set<LinguagemFavorita> LinguagensFavoritas3 = new TreeSet<LinguagemFavorita>(new ComparatorIde());
        LinguagensFavoritas3.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagem : LinguagensFavoritas3)
            System.out.println(linguagem);

        System.out.println("Imprimir ordem ano de criacao e nome");
        Set<LinguagemFavorita> LinguagensFavoritas4 = new TreeSet<LinguagemFavorita>(new ComparatorAnoDeCriacaoENome());
        LinguagensFavoritas4.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagem : LinguagensFavoritas4)
            System.out.println(linguagem);

        System.out.println("Imprimir ordem nome, ano de criacao e ide");
        Set<LinguagemFavorita> LinguagensFavoritas5 = new TreeSet<LinguagemFavorita>(
                new Linguagem().new ComparatorNomeAnoDeCriacaoIde());
        LinguagensFavoritas5.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagem : LinguagensFavoritas5)
            System.out.println(linguagem);

    }

    static class LinguagemFavorita implements Comparable<LinguagemFavorita> {
        private String nome;
        private int anoDeCriacao;
        private String ide;

        public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
            this.nome = nome;
            this.anoDeCriacao = anoDeCriacao;
            this.ide = ide;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getAnoDeCriacao() {
            return anoDeCriacao;
        }

        public void setAnoDeCriacao(int anoDeCriacao) {
            this.anoDeCriacao = anoDeCriacao;
        }

        public String getIde() {
            return ide;
        }

        public void setIde(String ide) {
            this.ide = ide;
        }

        @Override
        public String toString() {
            return "LinguagemFavorita [nome=" + nome + ", anoDeCriacao=" + anoDeCriacao + ", ide=" + ide + "]";
        }

        @Override
        public int compareTo(LinguagemFavorita linguagemFavorita) {
            return this.nome.compareTo(linguagemFavorita.getNome()); // Ordena alfabeticamente pelo nome
        }
    }

    static class ComparatorIde implements Comparator<LinguagemFavorita> {
        @Override
        public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
            return l1.ide.compareToIgnoreCase(l2.ide);
        }

    }

    static class ComparatorAnoDeCriacaoENome implements Comparator<LinguagemFavorita> {

        @Override
        public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
            int anoDeCriacao = Integer.compare(lf1.anoDeCriacao, lf2.anoDeCriacao);
            if (anoDeCriacao != 0)
                return anoDeCriacao;
            return lf1.nome.compareToIgnoreCase(lf2.nome);
        }
    }

    class ComparatorNomeAnoDeCriacaoIde implements Comparator<LinguagemFavorita> {

        @Override
        public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
            int nome = lf1.nome.compareToIgnoreCase(lf2.nome);
            int anoDeCriacao = Integer.compare(lf1.anoDeCriacao, lf2.anoDeCriacao);
            if (nome != 0)
                return nome;
            if (anoDeCriacao != 0)
                return anoDeCriacao;
            return lf1.ide.compareToIgnoreCase(lf2.ide);
        }
    }
}
