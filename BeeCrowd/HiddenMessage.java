import java.util.*;

public class HiddenMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantidade; i++) {
            String entrada = sc.nextLine();
            StringBuilder str = new StringBuilder();
            // Dividindo por qualquer sequência de "·" ou espaços
            String[] partes = entrada.split("\\s+");

            // Imprime todas as palavras separadas
            for (String parteAtual : partes) {
                if(!parteAtual.isEmpty()){
                    str.append(parteAtual.charAt(0));
                }
            }
            System.out.println(str); // Pular linha para cada entrada
        }

        sc.close();
    }
}
