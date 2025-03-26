import java.util.Scanner;

public class Trilhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho;

        // Loop principal para ler as entradas
        while (true) {
            // Lê o tamanho da sequência
            tamanho = sc.nextInt();

            // Se o tamanho for 0, encerra o programa
            if (tamanho == 0) {
                break;
            }

            // Loop para ler as sequências
            while (true) {
                int[] permutacoes = new int[tamanho];
                boolean fimSequencia = false;

                // Lê a sequência atual
                for (int i = 0; i < tamanho; i++) {
                    permutacoes[i] = sc.nextInt();

                    // Verifica se encontrou um 0 que indica o fim da sequência
                    if (permutacoes[i] == 0) {
                        fimSequencia = true;
                        break;
                    }
                }

                // Se encontrou um 0, sai do loop interno
                if (fimSequencia) {
                    break;
                }

                // Processa a sequência (aqui você pode adicionar a lógica do problema)
                for (int valor : permutacoes) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}