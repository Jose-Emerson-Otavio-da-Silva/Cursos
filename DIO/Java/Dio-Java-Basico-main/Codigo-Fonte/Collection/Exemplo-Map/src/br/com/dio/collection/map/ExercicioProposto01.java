package br.com.dio.collection.map;

import java.util.*;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */
public class ExercicioProposto01 {
    public static void main(String[] args) {
        // Crie um dicionário que relacione os estados e suas respectivas populações
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> populaçãoEstadosNE = new HashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };
        System.out.println(populaçãoEstadosNE);

        // Substitua a população do estado RN por 3.534.165
        System.out.println("Substitua a população do estado RN por : 3.534.165");
        populaçãoEstadosNE.put("RN", 3534165);
        System.out.println(populaçãoEstadosNE);

        // Confira se o estado da Paraíba (PB) está no dicionário, caso não, adicione PB
        // - 4.039.277
        System.out
                .println("Confira se o estado da Paraíba (PB) está no dicionário, caso não, adicione PB - 4.039.277: ");
        populaçãoEstadosNE.put("PB", 4039277);
        System.out.println(populaçãoEstadosNE);

        // Exiba a população do estado PE
        System.out.println("Exiba a população do estado PE: " + populaçãoEstadosNE.get("PE"));

        // Exiba todos os estados e suas populações na ordem em que foram informados
        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String, Integer> populaçãoEstadosNE2 = new LinkedHashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
                put("PB", 4039277);
            }
        };
        System.out.println(populaçãoEstadosNE2);

        // Exiba todos os estados e suas populações na ordem alfabética
        System.out.println("Exiba todos os estados e suas populações na ordem alfabética: ");
        Map<String, Integer> populaçãoEstadosNE3 = new TreeMap<>(populaçãoEstadosNE);
        System.out.println(populaçãoEstadosNE3);

        // Exiba o estado com o menor população e seu respectivo valor
        Collection<Integer> populacao = populaçãoEstadosNE.values();
        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";
        for (Map.Entry<String, Integer> entry : populaçãoEstadosNE.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao)))
                estadoMaiorPopulacao = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao)))
                estadoMenorPopulacao = entry.getKey();
        }
        System.out.printf("Exiba o estado com o menor população (%s) e seu respectivo valor (%d)\n",
                estadoMenorPopulacao, Collections.min(populacao));
        System.out.printf("Exiba o estado com a maior população (%s) e seu respectivo valor (%d)\n",
                estadoMaiorPopulacao, Collections.max(populacao));

        // Exiba a soma da população desses estados
        int soma = 0;
        Iterator<Integer> iterator = populaçãoEstadosNE.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da população desses estados: " + soma);

        // Exiba a média da população deste dicionário de estados
        System.out.println(
                "Exiba a média da população deste dicionário de estados: " + (soma / populaçãoEstadosNE.size()));

        // Remova os estados com a população menor que 4.000.000
        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = populaçãoEstadosNE.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 4000000)
                iterator1.remove();
        }
        System.out.println(populaçãoEstadosNE);

        // Apague o dicionário de estados com suas respectivas populações estimadas
        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        populaçãoEstadosNE.clear();
        System.out.println(populaçãoEstadosNE);

        // Confira se a lista está vazia
        System.out.println("Confira se a lista está vazia: " + populaçãoEstadosNE.isEmpty());
    }
}