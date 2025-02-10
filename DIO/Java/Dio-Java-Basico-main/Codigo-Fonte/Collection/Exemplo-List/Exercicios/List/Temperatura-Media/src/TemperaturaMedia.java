import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TemperaturaMedia {
    public static void main(String[] args) throws Exception {
        List<Temperatura> temperaturas = new ArrayList<>() {
            {
                for (int i = 0; i < 6; i++) {
                    System.out.println("Digite a temperatura média do mês: " + (i + 1));
                    Scanner scanner = new Scanner(System.in);
                    if (scanner.hasNextDouble()) {
                        String mes = "";
                        switch (i) {
                            case 0:
                                mes = "Janeiro";
                                break;
                            case 1:
                                mes = "Fevereiro";
                                break;
                            case 2:
                                mes = "Março";
                                break;
                            case 3:
                                mes = "Abril";
                                break;
                            case 4:
                                mes = "Maio";
                                break;
                            case 5:
                                mes = "Junho";
                                break;
                        }
                        add(new Temperatura("1 - " + mes, scanner.nextDouble()));
                    } else {
                        System.out.println("Valor inválido, digite um número.");
                        i--;
                    }
                }
            }
        };

        double media = temperaturas.stream().sorted().mapToDouble(Temperatura::getTemperatura).average().orElse(0.0);

        List<Temperatura> temperaturasAcimaDaMedia = new ArrayList<>();

        for (Temperatura temperatura : temperaturas) {
            if (temperatura.getTemperatura() > media) {
                temperaturasAcimaDaMedia.add(temperatura);
            }
        }

        System.out.println("Meses com temperaturas acima da média: " + media);
        temperaturasAcimaDaMedia.stream().sorted()
                .forEach(temp -> System.out.println(temp.getMes() + " - " + temp.getTemperatura()));

    }
}

class Temperatura implements Comparable<Temperatura> {
    private String mes;
    private double temperatura;

    public Temperatura(String mes, double temperatura) {
        this.mes = mes;
        this.temperatura = temperatura;
    }

    public String getMes() {
        return mes;
    }

    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public int compareTo(Temperatura temp) {
        return Double.compare(this.temperatura, temp.temperatura);
    }
}