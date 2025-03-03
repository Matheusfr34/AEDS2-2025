//package tps.tp01.ex08;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Arquivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String filePath = "numeros.dat";

        RandomAccessFile file = null;
        
        try {
            // Criação do arquivo e escrita dos valores
            file = new RandomAccessFile(filePath, "rw");

            // Lê pela entrada padrão e escreve no arquivo
            for (int i = 0; i < n; i++) {
                double value = sc.nextDouble();
                file.writeDouble(value);
            }
            
            file.close(); // Fecha o arquivo após a escrita

            // Reabre o arquivo para leitura
            file = new RandomAccessFile(filePath, "r");

            long fileSize = file.length();

            // Lê os valores de trás para frente
            for (int j = 0; j < n; j++) {
                file.seek(fileSize - (j + 1) * 8); // Move o ponteiro para o final do arquivo
                double value = file.readDouble(); // Lê o valor
                
                // Verifica se o valor é um número inteiro e imprime adequadamente
                if (Math.floor(value) == value) {
                    System.out.println((int) value); // Imprime como inteiro
                } else {
                    System.out.println(value); // Imprime como double
                }
            }

        } catch (IOException e) {
            e.printStackTrace(); // Trata e imprime a exceção se algo der errado
        } finally {
            // Garante que o arquivo será fechado mesmo se ocorrer uma exceção
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close(); // Fecha o scanner
        }
    }
}
