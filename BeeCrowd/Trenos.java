import java.util.ArrayList;
import java.util.Scanner;

class Brinquedo {
    String nome;
    double peso;

    Brinquedo(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }
}

public class Trenos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantTestes = sc.nextInt();
        sc.nextLine(); // Consome a quebra de linha após o número de testes

        for (int teste = 0; teste < quantTestes; teste++) {
            // Leitura do número de presentes do lote atual
            int quantPresentes = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha

            // Lista para armazenar os brinquedos do lote atual
            ArrayList<Brinquedo> brinquedos = new ArrayList<>();

            // Leitura dos dados de cada presente
            for (int i = 0; i < quantPresentes; i++) {
                String nome = sc.nextLine(); // Lê o nome (pode ter espaços)
                double peso = sc.nextDouble();
                sc.nextLine(); // Consome a quebra de linha após o peso
                brinquedos.add(new Brinquedo(nome, peso));
            }

            // Leitura da capacidade do trenó
            double capacidadeTreno = sc.nextDouble();
            sc.nextLine(); // Consome a quebra de linha

            // Leitura dos pedidos até encontrar "-" e 0
            double pesoTotal = 0.0;
            while (true) {
                String nomePedido = sc.nextLine(); // Lê o nome do pedido
                if (nomePedido.equals("-")) { // Verifica se é o fim da lista
                    int qtdZero = sc.nextInt(); // Deve ser 0
                    sc.nextLine(); // Consome a quebra de linha
                    break;
                }

                int quantidade = sc.nextInt();
                sc.nextLine(); // Consome a quebra de linha após a quantidade

                // Procura o brinquedo na lista
                boolean encontrado = false;
                for (Brinquedo b : brinquedos) {
                    if (b.nome.equals(nomePedido)) {
                        pesoTotal += b.peso * quantidade;
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("NAO LISTADO: " + nomePedido);
                }
            }

            // Cálculo do número de trenós necessários
            int trenosNecessarios = (int) Math.ceil(pesoTotal / capacidadeTreno);

            // Saída conforme especificação
            System.out.printf("%.2f\n", pesoTotal);
            System.out.println(trenosNecessarios);
            System.out.println(); // Linha em branco após cada teste
        }

        sc.close();
    }
}