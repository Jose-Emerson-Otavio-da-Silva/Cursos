package one.digitalinovation.laboojava.console;

import one.digitalinovation.laboojava.basedados.Banco;
import one.digitalinovation.laboojava.entidade.*;
import one.digitalinovation.laboojava.entidade.constantes.Materias;
import one.digitalinovation.laboojava.negocio.ClienteNegocio;
import one.digitalinovation.laboojava.negocio.PedidoNegocio;
import one.digitalinovation.laboojava.negocio.ProdutoNegocio;
import one.digitalinovation.laboojava.utilidade.LeitoraDados;

import java.util.Optional;

/**
 * Classe responsável por controlar a execução da aplicação.
 * 
 * @author thiago leite
 */
public class Start {

    private static Cliente clienteLogado = null;

    private static Banco banco = new Banco();

    private static ClienteNegocio clienteNegocio = new ClienteNegocio(banco);
    private static PedidoNegocio pedidoNegocio = new PedidoNegocio(banco);
    private static ProdutoNegocio produtoNegocio = new ProdutoNegocio(banco);

    /**
     * Método utilitário para inicializar a aplicação.
     * 
     * @param args Parâmetros que podem ser passados para auxiliar na execução.
     */
    public static void main(String[] args) {
        // Verifica se a base de dados tem usuario cadastrado, caso não é inserido um
        // usuario padrao
        Cliente[] clientes = banco.getClientes();
        if (clientes.length == 0) {
            banco.adicionarCliente(new Cliente());
        }

        System.out.println("Bem vindo ao e-Compras");

        String opcao = "";

        while (true) {

            if (clienteLogado == null) {

                System.out.println("Digite o cpf:");

                String cpf = "";
                cpf = LeitoraDados.lerDado();

                identificarUsuario(cpf);
            }
            // limparTela();
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Excluir Livro");
            // Desafio: Consultar Livro(nome)
            System.out.println("3 - Consultar Livro por Nome");

            System.out.println("4 - Cadastrar Caderno");
            System.out.println("5 - Excluir Caderno");
            // Desafio: Consultar Caderno(matéria)
            System.out.println("6 - Consultar Caderno por Materia");

            System.out.println("7 - Fazer pedido");
            System.out.println("8 - Excluir pedido");
            // Desafio: Consultar Pedido(código)
            System.out.println("9 - Consultar Pedido por Codigo");

            System.out.println("10 - Listar produtos");
            System.out.println("11 - Listar pedidos");

            System.out.println("12 - Deslogar");
            System.out.println("13 - Sair");

            opcao = LeitoraDados.lerDado();

            switch (opcao) {
                case "1": // Cadastrar Livro
                    Livro livro = LeitoraDados.lerLivro();
                    produtoNegocio.salvar(livro);
                    break;
                case "2": // Excluir Livro
                    System.out.println("Digite o código do livro");
                    String codigoLivro = LeitoraDados.lerDado();
                    produtoNegocio.excluir(codigoLivro);
                    break;
                case "3":// Consultar livro por nome
                    System.out.println("Digite o nome do livro.");
                    String nomeLivro = LeitoraDados.lerDado();
                    produtoNegocio.listarPorNome(nomeLivro);
                    break;
                case "4": // Cadastrar Caderno
                    Caderno caderno = LeitoraDados.lerCaderno();
                    produtoNegocio.salvar(caderno);
                    break;
                case "5": // Excluir Caderno
                    System.out.println("Digite o codigo do caderno");
                    String codigoCaderno = LeitoraDados.lerDado();
                    produtoNegocio.excluir(codigoCaderno);
                    break;
                case "6":// Consultar caderno por materia
                    System.out.println("Digite a tipo de materias do caderno.");
                    Materias materias = Materias.valueOf(LeitoraDados.lerDado());
                    produtoNegocio.listarPorMaterias(materias);
                    break;
                case "7": // Fazer pedido
                    Pedido pedido = LeitoraDados.lerPedido(banco);
                    Optional<Cupom> cupom = LeitoraDados.lerCupom(banco);

                    if (cupom.isPresent()) {
                        pedidoNegocio.salvar(pedido, cupom.get());
                    } else {
                        pedidoNegocio.salvar(pedido);
                    }
                    break;
                case "8": // Excluir pedido
                    System.out.println("Digite o código do pedido");
                    String codigoPedido = LeitoraDados.lerDado();
                    pedidoNegocio.excluir(codigoPedido);
                    break;
                case "9":// Consultar pedido por codigo
                    System.out.println("Digite o codigo do podido.");
                    String codPedido = LeitoraDados.lerDado();
                    pedidoNegocio.listarPorCodigo(codPedido);
                    break;
                case "10": // Listar Produtos
                    System.out.println("Lista de pedidos:");
                    produtoNegocio.listarTodos();
                    break;
                case "11": // Listar todos os Pedidos
                    System.out.println("Lista de pedidos:");
                    pedidoNegocio.listarTodos();
                    break;
                case "12":
                    System.out.println(String.format("Volte sempre %s!", clienteLogado.getNome()));
                    clienteLogado = null;
                    break;
                case "13":
                    System.out.println("Aplicação encerrada.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    /**
     * Procura o usuário na base de dados.
     * 
     * @param cpf CPF do usuário que deseja logar na aplicação
     */
    private static void identificarUsuario(String cpf) {

        Optional<Cliente> resultado = clienteNegocio.consultar(cpf);

        if (resultado.isPresent()) {

            Cliente cliente = resultado.get();
            System.out.println(String.format("Olá %s! Você está logado.", cliente.getNome()));
            clienteLogado = cliente;
        } else {
            System.out.println("Usuário não cadastrado.");
            System.exit(0);
        }
    }

    /**
     * Simula a limpeza da tela imprimindo 50 linhas em branco
     * 
     */
    public static void limparTela() {
        // Simula a limpeza da tela imprimindo 50 linhas em branco
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }
}
