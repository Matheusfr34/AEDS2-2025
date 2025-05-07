public class Main {

    static class Celula {
        int elemento;
        Celula prox;

        public Celula(int x) {
            this.elemento = x;
            this.prox = null;
        }
    }

    static class Lista {
        Celula inicio, fim;

        public void inserirFim(int x) {
            if (inicio == null) {
                Celula tmp = new Celula(x);
                inicio = tmp;
                fim = inicio;
            } else {
                fim.prox = new Celula(x);
                fim = fim.prox;
            }
        }

        public void meiose() {
            int contador = 0;

            for (Celula i = inicio; i != null; i = i.prox, contador++);

            int valorMeiose[] = new int[contador];
            Celula tmp = inicio;

            for (int i = 0; i < contador; i++) {
                valorMeiose[i] = tmp.elemento / 2;
                tmp = tmp.prox;
            }

            for (int i = 0; i < contador; i++) {
                inserirFim(valorMeiose[i]);
                inserirFim(valorMeiose[i]);
            }
        }

        public void mostrar() {
            System.out.print("MEIOSE: [ ");
            for (Celula i = inicio; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        // Inserir os elementos iniciais: 8, 5, 6, 1
        lista.inserirFim(8);
        lista.inserirFim(5);
        lista.inserirFim(6);
        lista.inserirFim(1);

        // Mostrar antes da meiose
        System.out.print("ANTES : [ ");
        for (Celula i = lista.inicio; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");

        // Aplicar meiose
        lista.meiose();

        // Mostrar resultado
        lista.mostrar();
    }
}
