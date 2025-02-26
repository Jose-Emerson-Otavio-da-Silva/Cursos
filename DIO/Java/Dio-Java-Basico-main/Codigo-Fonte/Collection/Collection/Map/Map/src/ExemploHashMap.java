import java.util.HashMap;
import java.util.Map;

public class ExemploHashMap {
    // Este código demonstra o uso da classe HashMap em Java para armazenar e
    // manipular dados de campeões mundiais de futebol.
    // HashMap é uma implementação da interface Map que utiliza uma tabela hash para
    // armazenar as chaves e valores.
    // Principais características do HashMap:
    // - Permite chaves e valores nulos.
    // - Não garante a ordem dos elementos.
    // - Não é sincronizado, ou seja, não é seguro para uso em ambientes com
    // múltiplas threads.
    // - Operações básicas como adicionar, remover e buscar elementos têm
    // complexidade O(1) em média.
    public static void main(String[] args) throws Exception {

        // Cria um HashMap
        Map<String, Integer> campeoesMundiaisFifa = new HashMap<>();

        // Adiciona os campeões mundiais fifa no mapa
        campeoesMundiaisFifa.put("Brasil", 5);
        campeoesMundiaisFifa.put("Alemanha", 4);
        campeoesMundiaisFifa.put("Itália", 4);
        campeoesMundiaisFifa.put("Uruguai", 2);
        campeoesMundiaisFifa.put("Argentina", 2);
        campeoesMundiaisFifa.put("França", 2);
        campeoesMundiaisFifa.put("Inglaterra", 1);
        campeoesMundiaisFifa.put("Espanha", 1);
        // Exibe os campeões mundiais fifa
        System.out.println(campeoesMundiaisFifa);

        // Atualiza o valor para a chave Brasil
        campeoesMundiaisFifa.put("Brasil", 6);

        // Retorna a Argentina
        System.out.println(campeoesMundiaisFifa.get("Argentina"));

        // Retorna se existe ou não um campeão França
        System.out.println(campeoesMundiaisFifa.containsKey("França"));

        // Remove o campeão França
        campeoesMundiaisFifa.remove("França");

        // Retorna se existe ou não um campeão França
        System.out.println(campeoesMundiaisFifa.containsKey("França"));

        // Retorna se existe ou não alguma seleção hexacampeã
        System.out.println(campeoesMundiaisFifa.containsValue(6));

        // Retorna o tamanho do mapa
        System.out.println(campeoesMundiaisFifa.size());

        // Navega nos registros do mapa
        for (Map.Entry<String, Integer> entry : campeoesMundiaisFifa.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

        // Navega nos registros do mapa
        for (String key : campeoesMundiaisFifa.keySet()) {
            System.out.println(key + " -- " + campeoesMundiaisFifa.get(key));
        }
        // Exibe os campeões mundiais fifa
        System.out.println(campeoesMundiaisFifa);

        // Verifica se o mapa contém a chave Estados Unidos
        System.out.println(campeoesMundiaisFifa.containsKey("Estados Unidos"));

        // Verifica se o mapa contém o valor 5
        System.out.println(campeoesMundiaisFifa.containsValue(5));

        // Verifica o tamanho antes e depois de limpar o mapa
        System.out.println(campeoesMundiaisFifa.size());

        // Limpa o mapa
        campeoesMundiaisFifa.clear();

        // Verifica o tamanho antes e depois de limpar o mapa
        System.out.println(campeoesMundiaisFifa.size());
    }
}
