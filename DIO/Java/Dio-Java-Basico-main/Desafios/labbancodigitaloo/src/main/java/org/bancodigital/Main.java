package org.bancodigital;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static DataBase dataBase = new DataBase();

    /**
     * Classe do Java para manipular entradas via teclado.
     */
    private static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    /**
     * Método utilitário para inicializar a aplicação.
     */
    public static void main(String[] args) {

        System.out.println("Bem vindo.");

        String opcao = "";
        System.out.println("");

        while (true) {

            System.out.println("Selecione uma opção:");
            System.out.println("");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("");
            System.out.println("5 - Cadastrar Cliente");
            System.out.println("6 - Excluir Cliente");
            System.out.println("");
            System.out.println("7 - Cadastrar Conta");
            System.out.println("8 - Excluir Conta");
            System.out.println("");
            System.out.println("9 - Listar Todos Clientes");
            System.out.println("10 - Consultar Cliente por CPF");
            System.out.println("");
            System.out.println("11 - Listar Todas  Contas");
            System.out.println("12 - Listar Contas Poupança");
            System.out.println("13 - Listar Contas Correntes");
            System.out.println("14 - Consultar Conta por Numero");
            System.out.println("15 - Consultar Conta por Cpf");
            System.out.println("");
            System.out.println("20 - Sair");

            opcao = lerDado();

            switch (opcao) {
                case "1": // Depositar
                    depositar();
                    break;
                case "2": // Sacar
                    sacar();
                    break;
                case "3": // Transferir
                    transferir();
                    break;
                case "5": // Cadastrar Cliente
                    Cliente cliente = lerCliente();
                    dataBase.salvarCliente(cliente);
                    break;
                case "6": // Excluir Cliente
                    System.out.println("Digite o cpf do cliente");
                    String cpfCliente = lerDado();
                    dataBase.excluirCliente(cpfCliente);
                    break;
                case "7": // Cadastrar Conta
                    Conta conta = lerConta();
                    dataBase.salvarConta(conta);
                    break;
                case "8": // Excluir Conta
                    System.out.println("Digite o numero da conta");
                    String codigoConta = lerDado();
                    dataBase.excluirConta(Integer.parseInt(codigoConta));
                    break;
                case "9": // Listar clientes
                    System.out.println("Lista de cliente:");
                    dataBase.listarTodosClientes();
                    break;
                case "10":// Consultar cliente por cpf
                    System.out.println("Digite o cpf do cliente.");
                    cpfCliente = lerDado();
                    dataBase.listarClintePorCpf(cpfCliente);
                    break;
                case "11": // Listar contas
                    System.out.println("Lista de contas:");
                    dataBase.listarTodasContas();
                    break;
                case "12": // Listar contas poupanca
                    System.out.println("Lista de contas poupança:");
                    dataBase.listarTodasContasPoupanca();
                    break;
                case "13": // Listar contas correntes
                    System.out.println("Lista de contas correntes:");
                    dataBase.listarTodasContasCorrente();
                    break;
                case "14":// Consultar conta por numero
                    System.out.println("Digite numero da conta.");
                    codigoConta = lerDado();
                    dataBase.listarContaPorNumero(Integer.parseInt(codigoConta));
                    break;
                case "15": // Consultar conta por cpf
                    System.out.println("Digite cpf dp titular da conta.");
                    cpfCliente = lerDado();
                    dataBase.listarContasPorCpf(cpfCliente);
                    break;
                case "20":
                    System.out.println("Aplicação encerrada.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }
    }

    // Métodos auxiliares

    /**
     * Ler um dado específico
     */
    public static String lerDado() {

        String texto = scanner.nextLine();

        return texto.toUpperCase();
    }

    /**
     * Ler os dados do cliente a ser cadastrado.
     * 
     * @return Um cliente a partir dos dados de entrada
     */
    public static Cliente lerCliente() {

        System.out.println("Cadastrando novo cliente...");
        Cliente cliente = new Cliente();

        System.out.println("Digite o nome");
        String nome = lerDado();
        cliente.setNome(nome.toUpperCase());

        System.out.println("Digite o CPF");
        String cpf = lerDado();
        cliente.setCpf(cpf.toUpperCase());

        System.out.println("Digite o telefone");
        String telefone = lerDado();
        cliente.setTelefone(telefone.toUpperCase());

        System.out.println("Digite a data de nascimento");
        String nascimento = lerDado();
        cliente.setNascimento(nascimento.toUpperCase());

        return cliente;
    }

    /**
     * Ler os dados do cliente a ser cadastrado.
     * 
     * @return Um cliente a partir dos dados de entrada
     */
    public static Conta lerConta() {

        Conta conta = null;
        Cliente cliente = null;

        System.out.println("Cadastrando nova conta...");

        while (cliente == null) {
            System.out.println("Digite o cpf do cliente");
            String cpf = lerDado();

            cliente = buscarClienteCpf(cpf);
            if (cliente == null) {
                System.out.println("Não existe nenhum cliente com esse cpf.");
            }
        }

        System.out.println("Digite P para conta poupança ou C para conta corrente.");
        String tipoConta = lerDado().toUpperCase();

        if (tipoConta.equals("P")) {
            ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);

            System.out.println("Digite o valor do saldo inicial da conta");
            String saldoInicialConta = lerDado();

            contaPoupanca.depositar(Double.parseDouble(saldoInicialConta));

            conta = contaPoupanca;

        } else {
            ContaCorrente contaCorrente = new ContaCorrente(cliente);

            System.out.println("Digite o valor do saldo inicial da conta");
            String saldoInicialConta = lerDado();

            contaCorrente.depositar(Double.parseDouble(saldoInicialConta));

            conta = contaCorrente;
        }
        return conta;
    }

    /**
     * Método que lê os dados e realiza o deposito
     */
    public static void depositar() {
        Conta conta = null;

        while (conta == null) {
            System.out.println("Digite o numero da conta");
            int numeroConta = Integer.parseInt(lerDado());

            conta = buscarContaPorNumero(numeroConta);
            if (conta == null) {
                System.out.println("Não existe nenhuma conta com numero informado.");
            }
        }

        System.out.println("Digite valor que deseja depositar.");
        Double valorDepositar = Double.parseDouble(lerDado());
        conta.depositar(valorDepositar);

        System.out.println("Depósito realizado com sucesso.");
        System.out.println(conta.toString());
    }

    /**
     * Método que lê os dados e realiza o saque
     */
    public static void sacar() {
        Conta conta = null;

        while (conta == null) {
            System.out.println("Digite o numero da conta");
            int numeroConta = Integer.parseInt(lerDado());

            conta = buscarContaPorNumero(numeroConta);
            if (conta == null) {
                System.out.println("Não existe nenhuma conta com numero informado.");
            }
        }

        System.out.println("Digite valor que deseja sacar.");
        Double valorSacar = Double.parseDouble(lerDado());
        conta.sacar(valorSacar);

        System.out.println("Saque realizado com sucesso.");
        System.out.println(conta.toString());
    }

    /**
     * Método que lê os dados e realiza o transferencia
     */
    public static void transferir() {
        Conta contaOrigem = null;
        Conta contaDestino = null;

        while ((contaOrigem == null) || (contaDestino == null)) {
            System.out.println("Digite o numero da conta de origem");
            int numeroContaOrigem = Integer.parseInt(lerDado());

            System.out.println("Digite o numero da conta de destino");
            int numeroContaDestino = Integer.parseInt(lerDado());

            contaOrigem = buscarContaPorNumero(numeroContaOrigem);
            if (contaOrigem == null) {
                System.out.println("Conta de origem informada não existe.");
            }

            contaDestino = buscarContaPorNumero(numeroContaDestino);
            if (contaDestino == null) {
                System.out.println("Conta de destino informada não existe.");
            }
        }

        System.out.println("Digite valor que deseja transferir.");
        Double valorTransferir = Double.parseDouble(lerDado());
        contaOrigem.transferir(valorTransferir, contaDestino);

        System.out.println("Transferencia realizada com sucesso.");
    }

    /**
     * @param cpf
     * @return Cliente
     */
    private static Cliente buscarClienteCpf(String cpf) {

        Cliente cliente = null;

        for (int i = 0; i < dataBase.getClientes().length; i++) {

            Cliente clienteTemporario = dataBase.getClientes()[i];
            if (clienteTemporario.getCpf().equals(cpf)) {
                cliente = clienteTemporario;
                break;
            }
        }
        return cliente;
    }

    /**
     * @param numero
     * @return Conta
     */
    private static Conta buscarContaPorNumero(int numero) {

        Conta conta = null;

        for (int i = 0; i < dataBase.getContas().length; i++) {

            Conta contaTemporaria = dataBase.getContas()[i];
            if (contaTemporaria.getNumero() == numero) {
                conta = contaTemporaria;
                break;
            }
        }
        return conta;
    }
}