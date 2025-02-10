import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArcoIris {
    public static void main(String[] args) throws Exception {

        System.out.println("Crie uma conjunto contendo as cores do arco-íris: ");
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("violeta");
        coresArcoIris.add("anil");
        coresArcoIris.add("azul");
        coresArcoIris.add("verde");
        coresArcoIris.add("amarelo");
        coresArcoIris.add("laranja");
        coresArcoIris.add("vermelho");
        System.out.println(coresArcoIris);

        System.out.println("Exiba todas as cores o arco-íris uma abaixo da outra: ");
        for (String cor : coresArcoIris) {
            System.out.println(cor);
        }

        System.out.println("A quantidade de cores que o arco-íris tem: " + coresArcoIris.size());

        System.out.println("Exiba as cores em ordem alfabética: ");
        Set<String> coresArcoIrisOrdemAlfabetica = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIrisOrdemAlfabetica);

        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
        Set<String> coresArcoIris2 = new LinkedHashSet<>(
                Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        List<String> coresArcoIrisInversa = new ArrayList<>(coresArcoIris2);
        Collections.reverse(coresArcoIrisInversa);
        System.out.println(coresArcoIrisInversa);

        System.out.println("Exiba todas as cores que começam com a letra ”v”: ");
        for (String cor : coresArcoIris) {
            if (cor.startsWith("v")) {
                System.out.println(cor);
            }
        }

        System.out.println("Remova todas as cores que não começam com a letra ”v”: ");
        coresArcoIris.removeIf(cor -> !cor.startsWith("v"));
        System.out.println(coresArcoIris);

        System.out.println("Limpe o conjunto, removendo todas as cores: ");
        coresArcoIris.clear();

        System.out.println("Confira se o conjunto está vazio: " + coresArcoIris.isEmpty());
    }
}
