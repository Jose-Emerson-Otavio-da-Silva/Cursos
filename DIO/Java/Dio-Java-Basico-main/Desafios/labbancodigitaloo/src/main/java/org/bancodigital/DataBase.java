package org.bancodigital;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    /**
     * Lista que armazena os clientes cadastrados.
     */
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Lista que armazena as contas cadastradas
     */
    private List<Conta> contas = new ArrayList<>();

    /**
     * Retorna lista de clientes
     */
    public Cliente[] getClientes() {
        return clientes.toArray(new Cliente[clientes.size()]);
    }

    /**
     * Retorna lista de contas
     */
    public Conta[] getContas() {
        return contas.toArray(new Conta[contas.size()]);
    }

    /**
     * Lista todos os clientes cadastrados.
     */
    public void listarTodosClientes() {

        if (getClientes().length == 0) {
            System.out.println("Não existem clientes cadastrados");
        } else {

            for (Cliente cliente : getClientes()) {
                System.out.println(cliente.toString());
            }
        }
    }

    /**
     * Lista os clientes por cpf.
     * 
     * @param cpf do cliente cadastrado
     */
    public void listarClintePorCpf(String cpf) {

        for (int i = 0; i < getClientes().length; i++) {

            Cliente cliente = getClientes()[i];
            if (cliente.getCpf().equals(cpf)) {
                System.out.println(cliente.toString());
            } else {
                System.out.println("Nenhum cliente encontrado com o cpf informado.");
            }
        }
    }

    /**
     * Lista todas as contas cadastradas.
     */
    public void listarTodasContas() {

        if (getContas().length == 0) {
            System.out.println("Não existem contas cadastradas");
        } else {

            for (Conta conta : getContas()) {
                System.out.println(conta.toString());
            }
        }
    }

    /**
     * Lista todas as contas poupanças cadastradas.
     */
    public void listarTodasContasPoupanca() {

        if (getContas().length == 0) {

            System.out.println("Não existem contas poupança cadastradas");

        } else {

            System.out.println("Lista de Contas Poupança");

            for (int i = 0; i < getContas().length; i++) {

                if (getContas()[i] instanceof ContaPoupanca) {

                    System.out.println(getContas()[i].toString());
                }
            }
        }
    }

    /**
     * Lista todas as contas correntes cadastradas.
     */
    public void listarTodasContasCorrente() {

        if (getContas().length == 0) {
            System.out.println("Não existem contas correntes cadastradas");
        } else {

            System.out.println("Lista de Contas Correntes");

            for (int i = 0; i < getContas().length; i++) {

                if (getContas()[i] instanceof ContaCorrente) {

                    System.out.println(getContas()[i].toString());
                }
            }
        }
    }

    /**
     * Listar contas por numero
     *
     * @param numero da conta
     */
    public void listarContaPorNumero(int numero) {

        for (int i = 0; i < getContas().length; i++) {

            Conta conta = getContas()[i];
            if (conta.getNumero() == numero) {
                System.out.println(conta.toString());
            } else {
                System.out.println("Nenhuma conta encontrada com o numero informado.");
            }
        }
    }

    /**
     * Listar contas por cpf
     *
     * @param cpf do cliente
     */
    public void listarContasPorCpf(String cpf) {

        Conta[] contas = getContas();
        List<Conta> contasEncontradas = new ArrayList<>();

        for (Conta conta : contas) {

            if (conta.getCliente().getCpf().equals(cpf)) {
                contasEncontradas.add(conta);
            }
        }

        if (contasEncontradas.isEmpty()) {
            System.out.println("Nao encontrado nenhuma conta com o cpf informado.");
        } else {
            System.out.println("Contas encontradas com cpf: " +
                    cpf + "':");
            for (Conta conta : contasEncontradas) {
                System.out.println(conta.toString());
            }
        }
    }

    /**
     * Cadastrar um novo cliente.
     * * @param cliente
     */

    public void salvarCliente(Cliente novoCliente) {

        boolean clienteRepetido = false;
        for (Cliente cliente : getClientes()) {
            if (cliente.getCpf() == novoCliente.getCpf()) {
                clienteRepetido = true;
                System.out.println("CPF de cliente já cadastrado.");
                break;
            }
        }

        if (!clienteRepetido) {
            clientes.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso.");
        }
    }

    /**
     * Cadastrar uma nova conta.
     * * @param cliente, saldo, tipo de conta
     */

    public void salvarConta(Conta conta) {

        contas.add(conta);
        System.out.println("Conta cadastradoa com sucesso.");
        conta.toString();
    }

    /**
     * Exclui um cliente específico.
     * 
     * @param cpf do cliente
     */

    public void excluirCliente(String cpf) {

        int clienteExclusao = -1;
        for (int i = 0; i < getClientes().length; i++) {

            Cliente cliente = getClientes()[i];
            if (cliente.getCpf().equals(cpf)) {
                clienteExclusao = i;
                break;
            }
        }

        if (clienteExclusao != -1) {
            clientes.remove(clienteExclusao);
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Cliente não existe.");
        }
    }

    /**
     * Exclui um conta específica.
     * 
     * @param numero do conta
     */

    public void excluirConta(int idConta) {

        int contaExclusao = -1;
        for (int i = 0; i < getContas().length; i++) {

            Conta conta = getContas()[i];
            if (conta.getNumero() == idConta) {
                contaExclusao = i;
                break;
            }
        }

        if (contaExclusao != -1) {
            contas.remove(contaExclusao);
            System.out.println("Conta excluída com sucesso.");
        } else {
            System.out.println("Conta não existe.");
        }
    }
}
