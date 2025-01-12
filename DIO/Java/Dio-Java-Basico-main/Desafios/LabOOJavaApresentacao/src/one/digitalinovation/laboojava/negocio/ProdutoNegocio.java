package one.digitalinovation.laboojava.negocio;

import one.digitalinovation.laboojava.basedados.Banco;
import one.digitalinovation.laboojava.entidade.Caderno;
import one.digitalinovation.laboojava.entidade.Livro;
import one.digitalinovation.laboojava.entidade.Produto;
import one.digitalinovation.laboojava.entidade.constantes.Materias;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Produto}.
 * 
 * @author thiago leite
 */
public class ProdutoNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * 
     * @param banco Banco de dados para ter armazenar e ter acesso os produtos
     */
    public ProdutoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Salva um novo produto(livro ou caderno) na loja.
     * 
     * @param novoProduto Livro ou caderno que pode ser vendido
     */
    public void salvar(Produto novoProduto) {

        String codigo = "PR%04d";
        codigo = String.format(codigo, bancoDados.getProdutos().length);
        novoProduto.setCodigo(codigo);

        boolean produtoRepetido = false;
        for (Produto produto : bancoDados.getProdutos()) {
            if (produto.getCodigo() == novoProduto.getCodigo()) {
                produtoRepetido = true;
                System.out.println("Produto já cadastrado.");
                break;
            }
        }

        if (!produtoRepetido) {
            this.bancoDados.adicionarProduto(novoProduto);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }

    /**
     * Exclui um produto pelo código de cadastro.
     * 
     * @param codigo Código de cadastro do produto
     */
    public void excluir(String codigo) {

        int produtoExclusao = -1;
        for (int i = 0; i < bancoDados.getProdutos().length; i++) {

            Produto produto = bancoDados.getProdutos()[i];
            if (produto.getCodigo().equals(codigo)) {
                produtoExclusao = i;
                break;
            }
        }

        if (produtoExclusao != -1) {
            bancoDados.removerProduto(produtoExclusao);
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto inexistente.");
        }
    }

    /**
     * Obtem um produto a partir de seu código de cadastro.
     * 
     * @param codigo Código de cadastro do produto
     * @return Optional indicando a existência ou não do Produto
     */
    public Optional<Produto> consultar(String codigo) {

        for (Produto produto : bancoDados.getProdutos()) {

            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return Optional.of(produto);
            }
        }

        return Optional.empty();
    }

    /**
     * Lista todos os produtos cadastrados.
     */
    public void listarTodos() {

        if (bancoDados.getProdutos().length == 0) {
            System.out.println("Não existem produtos cadastrados");
        } else {

            for (Produto produto : bancoDados.getProdutos()) {
                System.out.println(produto.toString());
            }
        }
    }

    /**
     * Lista os livros por nome.
     * 
     * @param nome do livro cadastrado
     */
    public void listarPorNome(String Nome) {

        Produto[] biblioteca = bancoDados.getProdutos();
        List<Produto> livrosEncontrados = new ArrayList<>();

        for (Produto produto : biblioteca) {
            // if (((Livro) produto).getNome().contains(Nome)) {
            // livrosEncontrados.add(produto);
            // }
            if (produto instanceof Livro && ((Livro) produto).getNome().contains(Nome)) {
                livrosEncontrados.add(produto);
            }
        }

        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado com nome informado.");
        } else {
            System.out.println("Livros encontrados com o nome: " + Nome + "':");
            for (Produto livro : livrosEncontrados) {
                System.out.println(livro.toString());
            }
        }
    }

    /**
     * Lista os cadernos por materia.
     *
     * @param materia do caderno cadastrado
     */
    public void listarPorMaterias(Materias Materias) {

        Produto[] biblioteca = bancoDados.getProdutos();
        List<Produto> cadernosEncontrados = new ArrayList<>();

        for (Produto produto : biblioteca) {

            if (produto instanceof Caderno && ((Caderno) produto).getMaterias() == Materias) {
                cadernosEncontrados.add(produto);
            }
        }

        if (cadernosEncontrados.isEmpty()) {
            System.out.println("Nao encontrado nenhum caderno com o numero de materias informado.");
        } else {
            System.out.println("Livros encontrados com quantidade de materias: " +
                    Materias + "':");
            for (Produto caderno : cadernosEncontrados) {
                System.out.println(caderno.toString());
            }
        }
    }
}