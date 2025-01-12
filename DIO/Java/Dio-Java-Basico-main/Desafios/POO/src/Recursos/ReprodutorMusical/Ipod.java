package Recursos.ReprodutorMusical;

public class Ipod implements ReprodutorMusical {

    public void tocar() {
        System.out.println("Reproduzindo Musica");
    }

    public void pausar() {
        System.out.println("Pausando Musica");
    }

    public void selecionarMusica() {
        System.out.println("Selecionando Musica");
    }

}
