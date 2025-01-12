public class SistemaMedida {
    public static void main(String[] args) {
        String sigla = "P";

        // Exemplo de Switch case
        switch (sigla) {
            case "P": {
                System.out.println("Pequeno");
                break;
            }
            case "M": {
                System.out.println("Medio");
                break;
            }
            case "G": {
                System.out.println("Grande");
                break;
            }
            default:
                System.out.println("Indefinido");
                break;
        }

        PlanoOperadora("T");
    }

    public static void PlanoOperadora(String plano) {

        // Exemplo de switch case sem o break
        switch (plano) {
            case "T":
                System.out.println("5GB Youtube");
            case "M":
                System.out.println("Whats e Instagram grátis");
            case "B":
                System.out.println("100 minutos de ligacao");
        }
    }
}
