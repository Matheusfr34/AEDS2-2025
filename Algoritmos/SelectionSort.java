package Algoritmos;

/*
 * O selection sort sempre pega o menor elemento do array e coloca ele na posição correta. 
 * Dessa forma, ele sempre percorre todo o array. 
 */
public class SelectionSort {

    public static void ordenarCrescente(int[] array) {
        int tamanho = array.length;
        for (int i = 0; i < tamanho - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            int tmp = array[i];
            array[i] = array[menor];
            array[menor] = tmp;
        }
    }

    public static void ordenarDecrescente(int[] array) {
        int tamanho = array.length;
        for (int i = 0; i < tamanho - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (array[menor] < array[j]) {
                    menor = j;
                }
            }
            int tmp = array[i];
            array[i] = array[menor];
            array[menor] = tmp;
        }

    }

    public static void main(String[] args) {

        int valor[] = {20, 4, 3, 1, 10, 12, 15, 21};

        ordenarCrescente(valor);

        System.out.print("[");
        for (int i = 0; i < valor.length; i++) {
            System.out.print(valor[i] + " ");
        }
        System.out.println("]");

        ordenarDecrescente(valor);

        System.out.print("[");
        for (int i = 0; i < valor.length; i++) {
            System.out.print(valor[i] + " ");
        }
        System.out.print("]");

    }
}
