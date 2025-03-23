
import java.util.Scanner;

class Pilha {

    int[] array;
    int n;

    public Pilha(int tam) {
        array = new int[tam];
        n = 0;
    }

    public void inserir(int x) {
        if (n >= array.length) {
            System.out.println("ERRO. PILHA CHEIA");
            return;
        }

        array[n] = x;
        n++;
    }

    public int remover() {
        if (n == 1) {
            System.out.println();
            System.out.print("Remaining card: ");
            return array[0];
        }
        return array[--n];
    }

    public void inveter() {
        int tmp = array[n - 1];
        for (int i = n - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = tmp;
    }
}

public class CartasFora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            int entrada = sc.nextInt();
            if (entrada == 0) {
                flag = true;
                break;
            }

            int valores[] = new int[entrada];
            int tam = valores.length;
            Pilha pilha = new Pilha(tam);

            for (int i = entrada - 1, j = 0; i >= 0 && j < entrada; i--, j++) {
                valores[i] = entrada - j;
                pilha.inserir(valores[i]);
            }

            System.out.print("Discarded cards: ");
            boolean primeiro = true;

            for (int i = 0; i < tam - 1; i++) { // Até o penúltimo elemento
                if (!primeiro) {
                    System.out.print(", ");
                }
                System.out.print(pilha.remover());
                primeiro = false;
                pilha.inveter();
            }

            System.out.println(pilha.remover()); // Último elemento da pilha (remaining card)

        }
        sc.close();
    }
}
