package Menu;

import Dispositivo.Iphone;

public class Menu {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();

        // Métodos do aparelho telefonico
        iphone.ligar();
        iphone.atender();
        iphone.iniciarCorrerioVoz();

        // Métodos do Navegador de Internet
        iphone.exibirPagina();
        iphone.adicionarNovaAba();
        iphone.atualizarPagina();

        // Métodos do Reprodutor Musical
        iphone.tocar();
        iphone.pausar();
        iphone.selecionarMusica();
    }
}
