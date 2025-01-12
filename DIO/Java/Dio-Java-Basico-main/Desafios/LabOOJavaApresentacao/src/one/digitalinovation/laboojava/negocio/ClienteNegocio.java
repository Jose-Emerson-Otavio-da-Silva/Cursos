package one.digitalinovation.laboojava.negocio;

import one.digitalinovation.laboojava.basedados.Banco;
import one.digitalinovation.laboojava.entidade.Cliente;

import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Cliente}.
 * 
 * @author thiago leite
 */
public class ClienteNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * 
     * @param banco Banco de dados para ter acesso aos clientes cadastrados
     */
    public ClienteNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Consulta o cliente pelo seu CPF.
     * 
     * @param cpf CPF de um cliente
     * @return O cliente que possuir o CPF passado.
     */
    public Optional<Cliente> consultar(String cpf) {

        Cliente clienteIdentificado = null;
        for (int i = 0; i < bancoDados.getClientes().length; i++) {

            clienteIdentificado = bancoDados.getClientes()[i];
            if (clienteIdentificado.getCpf().equals(cpf)) {
                break;
            }
        }

        if (clienteIdentificado != null) {
            return Optional.of(clienteIdentificado);
        } else {
            return Optional.empty();
        }

        // Cliente[] clientes = bancoDados.getClientes();

        // if (bancoDados.getCliente().getCpf().equals(cpf)) {
        // return Optional.of(bancoDados.getCliente());
        // } else {
        // return Optional.empty();
        // }
    }

    /**
     * Cadastra um novo cliente.
     * 
     * @param cliente Novo cliente que terá acesso a aplicação
     */

    public void salvar(Cliente novoCliente) {

        boolean clienteRepetido = false;
        for (Cliente cliente : bancoDados.getClientes()) {
            if (cliente.getCpf() == novoCliente.getCpf()) {
                clienteRepetido = true;
                System.out.println("CPF de cliente já cadastrado.");
                break;
            }
        }

        if (!clienteRepetido) {
            this.bancoDados.adicionarCliente(novoCliente);
            System.out.println("Cliente cadastrado com sucesso.");
        }
    }

    /**
     * Exclui um cliente específico.
     * 
     * @param cpf CPF do cliente
     */

    public void excluir(String cpf) {

        int clienteExclusao = -1;
        for (int i = 0; i < bancoDados.getClientes().length; i++) {

            Cliente cliente = bancoDados.getClientes()[i];
            if (cliente.getCpf().equals(cpf)) {
                clienteExclusao = i;
                break;
            }
        }

        if (clienteExclusao != -1) {
            bancoDados.removerCliente(clienteExclusao);
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Produto inexistente.");
        }
    }

}
