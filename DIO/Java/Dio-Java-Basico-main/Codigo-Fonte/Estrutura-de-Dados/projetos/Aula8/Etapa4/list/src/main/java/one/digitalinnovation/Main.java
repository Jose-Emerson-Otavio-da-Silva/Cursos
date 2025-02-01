package one.digitalinnovation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String args[]) {

        List<Carro> listCarros = new ArrayList<>();

        listCarros.add(new Carro("Ford"));
        listCarros.add(new Carro("Chevrolet"));
        listCarros.add(new Carro("Fiat"));
        listCarros.add(new Carro("Peugeot"));

        // Verifica se contem o item na lista
        System.out.println(listCarros.contains(new Carro("Ford")));
        // Retorna o item da lista
        System.out.println(listCarros.get(2));
        // Retorna o index do item na lista
        System.out.println(listCarros.indexOf(new Carro("Fiat")));
        // Remove o item da lista
        System.out.println(listCarros.remove(2));
        // Exibe a lista
        System.out.println(listCarros);
    }

}
