public class ResultadoEscolar {
    public static void main(String[] args) {
        int nota = 6;

        AprovadoReprovado(nota);
        AprovadoRecuperacaoReprovado(nota);
        AprovadoReprovadoTernario(nota);
        AprovadoRecuperacaoReprovadoTernario(nota);
    }

    public static void AprovadoReprovado(int valor) {
        // Exemplo de fluxo condicional composto
        if (valor >= 7)
            System.out.println("Aprovado");
        else
            System.out.println("Reprovado");
    }

    public static void AprovadoRecuperacaoReprovado(int valor) {
        // Exemplo de fluxo condicional encadeado
        if (valor >= 7)
            System.out.println("Aprovado");
        else if (valor >= 5 && valor < 7)
            System.out.println(("Prava Recuperacao"));
        else
            System.out.println("Reprovado");
    }

    public static void AprovadoReprovadoTernario(int valor) {
        // Exemplo de fluxo condicional ternario simples
        String resultado = valor >= 7 ? "Aprovado" : "Reprovado";

        System.out.println(resultado);
    }

    public static void AprovadoRecuperacaoReprovadoTernario(int valor) {
        // Exemplo de fluxo condicional ternario composto
        String resultado = valor >= 7 ? "Aprovado" : valor >= 5 && valor < 7 ? "Recuperacao" : "Reprovado";

        System.out.println(resultado);
    }
}
