import java.util.Vector;

public class ExemploVector {
    /**
     * Este programa demonstra o uso da classe Vector em Java para manipulação de
     * uma lista de esportes.
     * 
     * Funcionalidades:
     * - Instancia um vetor de esportes.
     * - Adiciona quatro esportes ao vetor.
     * - Altera o valor na posição 2 do vetor.
     * - Remove o esporte na posição 2.
     * - Remove o esporte "Handebol" do vetor.
     * - Retorna e imprime o primeiro item do vetor.
     * - Navega e imprime todos os itens restantes do vetor.
     */
    public static void main(String[] args) {

        // Instanciando um vetor de esportes
        Vector<String> esportes = new Vector<>();

        // Adicionando esportes no vetor
        esportes.add("Futebol");
        esportes.add("Basquetebol");
        esportes.add("Tenis de Mesa");
        esportes.add("Handebol");

        // Alterando o valor na posição 2 do vetor
        esportes.set(2, "Ping Pong");

        // Removendo o esporte na posição 2
        esportes.remove(2);

        // Removendo o esporte Handebol do vetor
        esportes.remove("Handebol");

        // Retornando e imprimindo o primeiro item do vetor
        System.out.println(esportes.get(0));

        // Navegando e imprimindo todos os itens do vetor
        for (String esporte : esportes) {
            System.out.println(esporte);
        }
    }

}
