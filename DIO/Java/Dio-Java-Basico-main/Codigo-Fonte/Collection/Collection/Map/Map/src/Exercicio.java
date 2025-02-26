import java.util.HashMap;
import java.util.Map;

public class Exercicio {
    public static void main(String[] args) {

        // Crie um Map
        Map<String, String> estadosBrasileiros = new HashMap<>();

        // Adicione os 26 estados brasileiros no map, onde a sigla será a chave e o nome
        // do estado o valor.
        estadosBrasileiros.put("AC", "Acre");
        estadosBrasileiros.put("AL", "Alagoas");
        estadosBrasileiros.put("AP", "Amapá");
        estadosBrasileiros.put("AM", "Amazonas");
        estadosBrasileiros.put("BA", "Bahia");
        estadosBrasileiros.put("CE", "Ceará");
        estadosBrasileiros.put("ES", "Espírito Santo");
        estadosBrasileiros.put("GO", "Goiás");
        estadosBrasileiros.put("MA", "Maranhão");
        estadosBrasileiros.put("MT", "Mato Grosso");
        estadosBrasileiros.put("MS", "Mato Grosso do Sul");
        estadosBrasileiros.put("MG", "Minas Gerais");
        estadosBrasileiros.put("PA", "Pará");
        estadosBrasileiros.put("PB", "Paraíba");
        estadosBrasileiros.put("PR", "Paraná");
        estadosBrasileiros.put("PE", "Pernambuco");
        estadosBrasileiros.put("PI", "Piauí");
        estadosBrasileiros.put("RJ", "Rio de Janeiro");
        estadosBrasileiros.put("RN", "Rio Grande do Norte");
        estadosBrasileiros.put("RS", "Rio Grande do Sul");
        estadosBrasileiros.put("RO", "Rondônia");
        estadosBrasileiros.put("RR", "Roraima");
        estadosBrasileiros.put("SC", "Santa Catarina");

        // Exiba os estados no console
        System.out.println(estadosBrasileiros);

        // Remova o estado de Minas Gerais
        estadosBrasileiros.remove("MG");

        // Adicione o Distrito Federal
        estadosBrasileiros.put("DF", "Distrito Federal");

        // Verifique o tamanho do map
        System.out.println(estadosBrasileiros.size());

        // Remova o estado de Mato Grosso do Sul usando o nome do estado
        estadosBrasileiros.values().remove("Mato Grosso do Sul");

        // Navegue em todos os registros do map, mostrando no console no formato: NOME
        // (SIGLA)
        for (Map.Entry<String, String> entry : estadosBrasileiros.entrySet()) {
            System.out.println(entry.getValue() + " (" + entry.getKey() + ")");
        }

        // Verifique se o estado de Santa Catarina está no map
        System.out.println(estadosBrasileiros.containsKey("SC"));

        // Verifique se o estado do Maranhão está no map usando o nome do estado
        System.out.println(estadosBrasileiros.containsValue("Maranhão"));
    }

}
