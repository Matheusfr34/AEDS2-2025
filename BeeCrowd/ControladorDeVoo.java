import java.util.Scanner;

class Voo {
    String identificador;
    int direcao;

    public Voo(String identificador, int direcao) {
        this.identificador = identificador;
        this.direcao = direcao;
    }
}

public class ControladorDeVoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Voo[] todosVoos = new Voo[1000];
        int totalVoos = 0;

        int direcaoAtual = 0;

        while (true) {
            String entrada = sc.next();

            if (entrada.equals("0")) {
                break;
            }

            if (entrada.startsWith("-")) {
                direcaoAtual = Integer.parseInt(entrada);
            } else {
                todosVoos[totalVoos++] = new Voo(entrada, direcaoAtual);
            }
        }

        // Fila por direção
        Voo[] filaOeste = new Voo[1000];
        Voo[] filaNorte = new Voo[1000];
        Voo[] filaSul = new Voo[1000];
        Voo[] filaLeste = new Voo[1000];
        int qtdOeste = 0, qtdNorte = 0, qtdSul = 0, qtdLeste = 0;

        for (int i = 0; i < totalVoos; i++) {
            switch (todosVoos[i].direcao) {
                case -1:
                    filaOeste[qtdOeste++] = todosVoos[i];
                    break;
                case -2:
                    filaSul[qtdSul++] = todosVoos[i];
                    break;
                case -3:
                    filaNorte[qtdNorte++] = todosVoos[i];
                    break;
                case -4:
                    filaLeste[qtdLeste++] = todosVoos[i];
                    break;
            }
        }

        // Índices de leitura
        int idxOeste = 0, idxNorte = 0, idxSul = 0, idxLeste = 0;
        int voosImpressos = 0;

        while (voosImpressos < totalVoos) {
            if (idxOeste < qtdOeste) {
                System.out.print(filaOeste[idxOeste++].identificador);
                voosImpressos++;
                if (voosImpressos < totalVoos) System.out.print(" ");
            }
            if (idxNorte < qtdNorte) {
                System.out.print(filaNorte[idxNorte++].identificador);
                voosImpressos++;
                if (voosImpressos < totalVoos) System.out.print(" ");
            }
            if (idxSul < qtdSul) {
                System.out.print(filaSul[idxSul++].identificador);
                voosImpressos++;
                if (voosImpressos < totalVoos) System.out.print(" ");
            }
            if (idxLeste < qtdLeste) {
                System.out.print(filaLeste[idxLeste++].identificador);
                voosImpressos++;
                if (voosImpressos < totalVoos) System.out.print(" ");
            }
        }

        System.out.println();
        sc.close();
    }
}
