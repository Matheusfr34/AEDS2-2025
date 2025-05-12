import java.util.Scanner;

class Cargo {
    String cargo;
    int comissao;
    public Cargo(String palavra, int comissao) {
        this.cargo = palavra;
        this.comissao = comissao;
    }
}

public class PontosDeFeno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int palavrasDicionario = sc.nextInt();
            int quantDescricoes = sc.nextInt();
            sc.nextLine();

            Cargo cargo[] = new Cargo[palavrasDicionario];

            for (int i = 0; i < palavrasDicionario; i++) {
                String entrada = sc.next();
                int valor = sc.nextInt();
                sc.nextLine();
                cargo[i] = new Cargo(entrada, valor);
            }

            for (int i = 0; i < quantDescricoes; i++) {
                StringBuilder str = new StringBuilder();
                String linha;

                while (true) {
                    linha = sc.nextLine();
                    if (linha.equals(".")) {
                        break;
                    }
                    str.append(linha).append(" ");
                }

                String strToString = str.toString();
                String partes[] = strToString.split(" ");

                int valorPago = 0;
                for (String palavra : partes) {
                    for (Cargo c : cargo) {
                        if (c.cargo.equals(palavra)) {
                            valorPago += c.comissao;
                        }
                    }
                }

                System.out.println(valorPago);
            }
        }
        sc.close();
    }
}