/**
 * A classe CheckedException demonstra o tratamento de exceções verificadas (Checked Exceptions) em Java.
 * Checked Exceptions são exceções que o compilador força o programador a tratar, seja com um bloco try-catch
 * ou declarando a exceção na assinatura do método com a palavra-chave throws.
 * 
 * Neste exemplo, o método main tenta ler o conteúdo de um arquivo e imprimir no console. Se o arquivo não for encontrado,
 * uma FileNotFoundException é lançada e tratada. Outras exceções de I/O são tratadas por um bloco catch separado.
 * O bloco finally é sempre executado, independentemente de uma exceção ter sido lançada ou não.
 */
package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

// Classe principal para tratar exceções verificadas (Checked Exceptions)
public class CheckedException {
    public static void main(String[] args) {
        String nomeDoArquivo = "romance-blake-crouch.txt";

        try {
            // Tenta imprimir o conteúdo do arquivo no console
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e) {
            // Trata a exceção caso o arquivo não seja encontrado
            JOptionPane.showMessageDialog(null,
                    "Revise o nome do arquivo que você deseja imprimir! " + e.getCause());
            e.printStackTrace();
        } catch (IOException e) {
            // Trata outras exceções de I/O
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado! Entre em contato com o suporte! " + e.getCause());
        } finally {
            // Bloco que sempre será executado, independentemente de exceções
            System.out.println("Chegou no finally!");
        }

        // Mensagem indicando que o programa continua executando
        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    // Método para imprimir o conteúdo de um arquivo no console
    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        // Cria um BufferedReader para ler o arquivo
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        // Cria um BufferedWriter para escrever no console
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Lê e escreve cada linha do arquivo no console
        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (line != null);
        bw.flush();
        br.close();
    }
}
