package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

public class ExceptionCustomizada_1 {
    public static void main(String[] args) {
        // Solicita ao usuário o nome do arquivo a ser exibido
        String nomeDoArquivo = JOptionPane.showInputDialog("Nome do arquivo a ser exibido: ");

        // Chama o método para imprimir o conteúdo do arquivo no console
        imprimirArquivoNoConsole(nomeDoArquivo);
        System.out.println("\nCom exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) {
        try {
            // Lê o arquivo e obtém um BufferedReader
            BufferedReader br = lerArquivo(nomeDoArquivo);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // Lê e escreve cada linha do arquivo no console
            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            } while (line != null);
            bw.flush();
            br.close();
        } catch (ImpossivelAberturaDeArquivoException e) {
            // Trata a exceção personalizada e exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (IOException ex) {
            // Trata outras exceções de I/O e exibe uma mensagem de erro genérica
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro não esperado, por favor, fale com o suporte." + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static BufferedReader lerArquivo(String nomeDoArquivo) throws ImpossivelAberturaDeArquivoException {
        File file = new File(nomeDoArquivo);
        try {
            // Tenta abrir o arquivo e retorna um BufferedReader
            return new BufferedReader(new FileReader(nomeDoArquivo));
        } catch (FileNotFoundException e) {
            // Lança uma exceção personalizada se o arquivo não for encontrado
            throw new ImpossivelAberturaDeArquivoException(file.getName(), file.getPath());
        }
    }
}

// Classe de exceção personalizada para tratar arquivos não encontrados
class ImpossivelAberturaDeArquivoException extends Exception {
    private String nomeDoArquivo;
    private String diretorio;

    public ImpossivelAberturaDeArquivoException(String nomeDoArquivo, String diretorio) {
        super("O arquivo " + nomeDoArquivo + " não foi encontrado no diretório " + diretorio);
        this.nomeDoArquivo = nomeDoArquivo;
        this.diretorio = diretorio;
    }

    /*
     * @Override
     * public String toString() {
     * return "ImpossivelAberturaDeArquivoException{" +
     * "nomeDoArquivo='" + nomeDoArquivo + '\'' +
     * ", diretorio='" + diretorio + '\'' +
     * '}';
     * }
     */
}
