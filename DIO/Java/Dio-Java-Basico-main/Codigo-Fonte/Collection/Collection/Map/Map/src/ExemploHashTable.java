import java.util.Hashtable;
import java.util.Map;

/**
 * ExemploHashTable demonstra o uso da classe Hashtable em Java.
 * 
 * Hashtable é uma estrutura de dados que armazena pares chave-valor.
 * As principais características de um Hashtable são:
 * - Não permite chaves ou valores nulos.
 * - É sincronizado, o que significa que é seguro para uso em ambientes
 * multithread.
 * - A ordem dos elementos não é garantida.
 * - A busca, inserção e remoção de elementos são operações rápidas, geralmente
 * O(1).
 * 
 * Este exemplo inclui:
 * - Criação de um Hashtable.
 * - Adição de elementos ao Hashtable.
 * - Atualização de um valor associado a uma chave específica.
 * - Remoção de um elemento.
 * - Recuperação de um valor associado a uma chave.
 * - Exibição do número de elementos no Hashtable.
 * - Navegação e exibição dos elementos do Hashtable.
 */
public class ExemploHashTable {

    public static void main(String[] args) {

        // Cria um Hashtable
        Hashtable<String, Integer> estudantes = new Hashtable<>();

        // Adiciona os estudantes no Hashtable
        estudantes.put("Carlos", 21);
        estudantes.put("Mariana", 33);
        estudantes.put("Rafaela", 18);
        estudantes.put("Pedro", 44);
        // Exibe os estudantes
        System.out.println(estudantes);

        // Atualiza o valor para a chave Pedro
        estudantes.put("Pedro", 55);
        // Exibe os estudantes
        System.out.println(estudantes);

        // Remove um estudante no índice 0
        estudantes.remove("Pedro");
        // Exibe os estudantes
        System.out.println(estudantes);

        // Recupera um estudante no índice 2
        int idadeEstudante = estudantes.get("Mariana");
        System.out.println(idadeEstudante);

        // Retorna o número de estudantes no Hashtable
        System.out.println(estudantes.size());

        // Navega nos estudantes do Hashtable
        for (Map.Entry<String, Integer> entry : estudantes.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

        // Navega nos estudantes do Hashtable
        for (String key : estudantes.keySet()) {
            System.out.println(key + " -- " + estudantes.get(key));
        }

        // Exibe os estudantes
        System.out.println(estudantes);
    }

}
