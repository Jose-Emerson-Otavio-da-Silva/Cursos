import java.util.Optional;

public class ExemploOptionalEstados {
    public static void main(String[] args) throws Exception {

        // Criar um Optional
        Optional<String> optionalString = Optional.of("Valor presente");

        // Verificar se o valor está presente
        System.out.println("Valor opcional que está presente");
        optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("Não está presente"));

        // Se o valor não estiver presente, lançar uma exceção
        optionalString.orElseThrow(IllegalStateException::new);

        // Criar um Optional nulo
        Optional<String> optionalNull = Optional.ofNullable(null);

        // Verificar se o valor está presente
        System.out.println("Valor opcional que não está presente");
        optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("Não está presente"));

        // Criar um Optional vazio
        Optional<String> emptyOptional = Optional.empty();

        // Verificar se o valor está presente
        System.out.println("Valor opcional que não está presente");
        emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Não está presente"));

        // Lançar exceção ao tentar criar um Optional com valor nulo
        Optional<String> optionalNullErro = Optional.of(null);

        System.out.println("Valor opcional que lança erro NullPointerException");
        optionalNullErro.ifPresentOrElse(System.out::println,
                () -> System.out.println("Erro = não está presente"));

    }
}
