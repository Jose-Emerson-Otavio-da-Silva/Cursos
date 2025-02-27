import java.util.Optional;

/**
 * A classe ExemploOptional demonstra o uso da classe Optional do Java para
 * lidar com valores que podem ou não estar presentes.
 */
public class ExemploOptional {

    public static void main(String[] args) {

        // Cria um Optional vazio
        Optional<String> optionalString = Optional.empty();

        // Verifica se o Optional está vazio
        System.out.println(optionalString.isEmpty());
        // Verifica se o Optional contém um valor
        System.out.println(optionalString.isPresent());

        // Executa uma ação se o valor estiver presente, caso contrário, executa outra
        // ação
        optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("Valor não está presente"));

        // Verifica se o valor está presente e o imprime
        if (optionalString.isPresent()) {
            String valor = optionalString.get();
            System.out.println(valor);
        }

        // Transforma o valor se presente e o imprime
        optionalString.map((valor) -> valor.concat("****")).ifPresent(System.out::println);

        // Lança uma exceção se o valor não estiver presente
        optionalString.orElseThrow(IllegalStateException::new);
    }
}
