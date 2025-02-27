
/**
 * Comparator para ordenar objetos Estudante pela idade em ordem reversa (decrescente).
 * Implementa a interface Comparator e sobrescreve o método compare.
 * 
 * O método compare recebe dois objetos Estudante e compara suas idades,
 * retornando um valor negativo se a idade do segundo estudante for maior,
 * zero se as idades forem iguais, e um valor positivo se a idade do primeiro estudante for maior.
 * 
 * Isso resulta em uma ordenação decrescente das idades dos estudantes.
 */
import java.util.Comparator;

public class EstudanteOrdemIdadeReversaComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return o2.getIdade() - o1.getIdade();
    }

}
