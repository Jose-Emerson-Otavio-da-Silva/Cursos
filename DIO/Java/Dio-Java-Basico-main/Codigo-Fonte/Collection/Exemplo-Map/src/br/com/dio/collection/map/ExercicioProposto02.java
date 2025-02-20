package br.com.dio.collection.map;

import java.util.*;

/*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi conseguido.
 */
public class ExercicioProposto02 {
    public static void main(String[] args) {
        int quantLancamentos = 100; // Define o número de lançamentos de dados

        List<Integer> valores = new ArrayList<>(); // Lista para armazenar os resultados dos lançamentos
        Random geradorDeLancamento = new Random(); // Gerador de números aleatórios para os lançamentos
        for (int i = 0; i < quantLancamentos; i++) {
            int number = geradorDeLancamento.nextInt(6) + 1; // Gera um número aleatório entre 1 e 6
            valores.add(number); // Adiciona o resultado à lista
        }

        Map<Integer, Integer> lancamentos = new HashMap<>(); // Mapa para armazenar a frequência de cada resultado
        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1)); // Incrementa a contagem se o resultado já
                                                                              // estiver no mapa
            else
                lancamentos.put(resultado, 1); // Adiciona o resultado ao mapa com contagem 1 se não estiver presente
        }

        System.out.print("Jogando");
        // Simula um atraso para mostrar o progresso dos lançamentos
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(3000); // Espera por 3 segundos
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace(); // Imprime o stack trace se ocorrer uma interrupção
            }
        }

        System.out.println("\nValor " + " Quant. de vezes"); // Imprime o cabeçalho dos resultados
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue()); // Imprime cada resultado e sua
                                                                               // frequência
        }
    }
}