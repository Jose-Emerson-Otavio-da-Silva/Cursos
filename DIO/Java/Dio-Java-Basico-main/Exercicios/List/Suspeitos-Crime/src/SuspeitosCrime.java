import java.util.ArrayList;
import java.util.List;

public class SuspeitosCrime {
    public static void main(String[] args) throws Exception {
        List<String> perguntas = new ArrayList<>();
        perguntas.add("Telefonou para a vítima?");
        perguntas.add("Esteve no local do crime?");
        perguntas.add("Mora perto da vítima?");
        perguntas.add("Devia para a vítima?");
        perguntas.add("Já trabalhou com a vítima?");

        System.out.println("Responda com 'S' para sim ou 'N' para não as perguntas a seguir:");
        List<String> respostas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println(perguntas.get(i));
            respostas.add(System.console().readLine());
        }

        int sim = 0;
        for (String resposta : respostas) {
            if (resposta.equals("S")) {
                sim++;
            }
        }

        System.out.println("Pessoa classificada como: ");
        if (sim == 2) {
            System.out.println("Suspeita");
        } else if (sim == 3 || sim == 4) {
            System.out.println("Cúmplice");
        } else if (sim == 5) {
            System.out.println("Assassino");
        } else {
            System.out.println("Inocente");
        }
    }
}
