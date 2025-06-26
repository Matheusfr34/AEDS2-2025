import java.util.Scanner;

class Carro {
    String placa, modelo, tipo, chassi;

    void ler(String linha) {
        String[] partes = linha.split(",");
        placa = partes[0];
        modelo = partes[1];
        tipo = partes[2];
        chassi = partes[3];
    }

    void imprimir() {
        System.out.println(placa + " " + modelo + " " + tipo + " " + chassi);
    }
}

class No {
    Carro carro;
    No esq, dir;

    No(Carro carro) {
        this.carro = carro;
        esq = dir = null;
    }
}

class ArvoreCarros {
    private No raiz;

    public void inserir(Carro carro) {
        raiz = inserir(raiz, carro);
    }

    private No inserir(No no, Carro carro) {
        if (no == null) {
            return new No(carro);
        }
        if (carro.placa.compareTo(no.carro.placa) < 0) {
            no.esq = inserir(no.esq, carro);
        } else {
            no.dir = inserir(no.dir, carro);
        }
        return no;
    }

    public void buscar(String placa) {
        buscar(raiz, placa, 0);
    }

    private void buscar(No no, String placa, int nivel) {
        if (no == null) {
            System.out.println("PLACA NAO ENCONTRADA");
            return;
        }

        int cmp = placa.compareTo(no.carro.placa);

        if (cmp == 0) {
            System.out.print(no.carro.placa + " " + no.carro.modelo + " " + no.carro.tipo + " " + no.carro.chassi);
            System.out.println(" (Nivel " + nivel + ")");
        } else if (cmp < 0) {
            buscar(no.esq, placa, nivel + 1);
        } else {
            buscar(no.dir, placa, nivel + 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreCarros arvore = new ArvoreCarros();

        // Leitura e inserção dos veículos
        while (true) {
            String linha = sc.nextLine();
            if (linha.equals("FIM")) break;

            Carro carro = new Carro();
            carro.ler(linha);
            arvore.inserir(carro);
        }

        // Leitura e busca das placas
        while (true) {
            String placa = sc.nextLine();
            if (placa.equals("FIM_BUSCA")) break;

            arvore.buscar(placa);
        }

        sc.close();
    }
}
