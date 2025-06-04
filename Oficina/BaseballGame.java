import java.util.Scanner;

class Celula {
    int elemento;
    Celula prox;

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Pilha {
    Celula topo;

    public Pilha() {
        this.topo = null;
    }

    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
    }

    public int remover() {
        if (topo == null) {
            throw new RuntimeException("Pilha vazia.");
        }
        int resp = topo.elemento;
        topo = topo.prox;
        return resp;
    }

    public void soma() {
        if (topo == null || topo.prox == null) {
            throw new RuntimeException("Não há elementos suficientes para somar");
        }
        int primeiro = topo.elemento;
        int segundo = topo.prox.elemento;
        inserir(primeiro + segundo);
    }

    public int somaTotal() {
        int soma = 0;
        for (Celula i = topo; i != null; i = i.prox) {
            soma += i.elemento;
        }
        return soma;
    }

    public void dobrar() {
        if (topo == null) {
            throw new RuntimeException("Nenhum elemento para dobrar");
        }
        inserir(topo.elemento * 2);
    }
}

public class BaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();

        // Remove "ops =" e espaços extras
        if (entrada.contains("=")) {
            entrada = entrada.substring(entrada.indexOf('=') + 1).trim();
        }

        // Remove colchetes e aspas
        entrada = entrada.replaceAll("[\\[\\]\"]", "");

        // Divide os elementos da lista
        String[] operacoes = entrada.split(",");

        Pilha pilha = new Pilha();

        for (String op : operacoes) {
            op = op.trim();
            switch (op) {
                case "C":
                    pilha.remover();
                    break;
                case "D":
                    pilha.dobrar();
                    break;
                case "+":
                    pilha.soma();
                    break;
                default:
                    // Trata número positivo ou negativo
                    pilha.inserir(Integer.parseInt(op));
                    break;
            }
        }

        System.out.println(pilha.somaTotal());
        sc.close();
    }
}
