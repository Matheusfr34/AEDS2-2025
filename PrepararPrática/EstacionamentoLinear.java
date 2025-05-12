import java.util.Scanner;

class Motorista {
    int chegada;
    int saida;
    public Motorista(int chegada, int saida) {
        this.chegada = chegada;
        this.saida = saida;
    }
}

class Pilha {
    int[] array;
    int tam;
    public Pilha(int capacidade) {
        this.array = new int[capacidade];
        this.tam = 0;
    }

    public void inserir(int x) {
        if (tam >= array.length) {
            return; // Estacionamento cheio
        }
        array[tam++] = x;
    }

    public int remover() {
        if (tam == 0) {
            return -1; // Pilha vazia
        }
        return array[--tam];
    }

    public int verificarTopo() {
        if (tam == 0) {
            return -1;
        }
        return array[tam - 1];
    }
}

public class EstacionamentoLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numMotoristas = sc.nextInt();
        int capacidade = sc.nextInt();

        while (numMotoristas != 0 || capacidade != 0) {
            Motorista[] motoristas = new Motorista[numMotoristas];
            for (int i = 0; i < numMotoristas; i++) {
                int chegada = sc.nextInt();
                int saida = sc.nextInt();
                motoristas[i] = new Motorista(chegada, saida);
            }

            Pilha estacionamento = new Pilha(capacidade);
            boolean possivel = true;

            for (int i = 0; i < numMotoristas && possivel; i++) {
                int chegadaAtual = motoristas[i].chegada;
                int saidaAtual = motoristas[i].saida;

                // Remove carros que já saíram antes da chegada atual
                while (estacionamento.tam > 0 && estacionamento.verificarTopo() <= chegadaAtual) {
                    estacionamento.remover();
                }

                // Verifica se o estacionamento está cheio
                if (estacionamento.tam == capacidade) {
                    possivel = false;
                    break;
                }

                // Verifica se a saída do carro atual é válida (deve ser a menor no topo)
                if (estacionamento.tam > 0 && saidaAtual > estacionamento.verificarTopo()) {
                    possivel = false;
                    break;
                }

                estacionamento.inserir(saidaAtual);
            }

            System.out.println(possivel ? "Sim" : "Nao");
            numMotoristas = sc.nextInt();
            capacidade = sc.nextInt();
        }
        sc.close();
    }
}