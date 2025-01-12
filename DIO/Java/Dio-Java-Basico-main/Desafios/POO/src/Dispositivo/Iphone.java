package Dispositivo;

import Recursos.AparelhoTelefonico.AparelhoTelefonico;
import Recursos.NavegadorInternet.NavegadorInternet;
import Recursos.ReprodutorMusical.ReprodutorMusical;

public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    public void ligar() {
        System.out.println("Iniciando ligação pelo Iphone");
    }

    public void atender() {
        System.out.println("Atendendo ligação pelo Iphone");
    }

    public void iniciarCorrerioVoz() {
        System.out.println("Iniciando correio de voz pelo Iphone");
    }

    public void exibirPagina() {
        System.out.println("Exibindo página do Navegador do Iphone");
    }

    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba no navegador do Iphone");
    }

    public void atualizarPagina() {
        System.out.println("Atualizando página do navegador do Iphone");
    }

    public void tocar() {
        System.out.println("Tocando música pelo Iphone");
    }

    public void pausar() {
        System.out.println("Pausando música no Iphone");
    }

    public void selecionarMusica() {
        System.out.println("Selecionando música no Iphone");
    }

}
