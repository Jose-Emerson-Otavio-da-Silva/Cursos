import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExemploMap {
    public static void main(String[] args) throws Exception {
        // Cria um dicionário que relaciona os modelos de carros e seus respectivos
        // consumos
        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos");
        Map<String, Double> carrosPopulares = new HashMap<>() {
            {
                put("gol", 14.4);
                put("uno", 15.6);
                put("mobi", 16.1);
                put("hb20", 14.5);
                put("kwid", 15.6);
            }
        };
        System.out.println(carrosPopulares.toString());

        // Substitui o consumo do gol por 15.2 km/l
        System.out.println("Substitua o consumo do gol por 15.2 km/l");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares.toString());

        // Verifica se o modelo tucson está no dicionário
        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        // Exibe o consumo do uno
        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));

        // Exibe os modelos de carros
        System.out.println("Exiba os modelos: " + carrosPopulares.keySet());
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        // Exibe os consumos dos carros
        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        // Exibe o modelo mais econômico e seu consumo
        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }

        // Exibe o modelo menos econômico e seu consumo
        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        // Exibe a soma dos consumos
        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("A soma dos consumos é: " + soma);

        // Exibe a média dos consumos deste dicionário de carros
        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + soma / carrosPopulares.size());

        // Remove os modelos com o consumo igual a 15.6 km/l
        System.out.println("Remova os modelos com o consumo igual a 15.6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) {
                iterator1.remove();
            }
        }
        System.out.println(carrosPopulares);

        // Exibe todos os carros na ordem em que foram informados
        System.out.println("Exiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {
            {
                put("gol", 14.4);
                put("uno", 15.6);
                put("mobi", 16.1);
                put("hb20", 14.5);
                put("kwid", 15.6);
            }
        };
        System.out.println(carrosPopulares1.toString());

        // Exibe o dicionário ordenado pelo modelo
        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        // Apaga o dicionário de carros
        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();

        // Verifica se o dicionário está vazio
        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());
    }
}
