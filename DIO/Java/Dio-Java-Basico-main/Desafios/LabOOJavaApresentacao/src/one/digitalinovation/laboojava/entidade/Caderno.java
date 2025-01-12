package one.digitalinovation.laboojava.entidade;

import one.digitalinovation.laboojava.entidade.constantes.Materias;

/**
 * Classe que representa um caderdo, qual é uma especialização de um produto da
 * loja.
 * 
 * @author thiago leite
 */
public class Caderno extends Produto {

    /**
     * Tipo do caderno.
     */
    private Materias tipo;

    public Materias getMaterias() {
        return tipo;
    }

    public void setMaterias(Materias materias) {
        this.tipo = materias;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public double calcularFrete() {
        return (getPreco() * getQuantidade()) * (1 + tipo.getFator());
    }

    @Override
    public String toString() {
        return "Caderno{" +
                ", tipo=" + tipo + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                ", preço='" + getPreco() + '\'' +
                '}';
    }
}
