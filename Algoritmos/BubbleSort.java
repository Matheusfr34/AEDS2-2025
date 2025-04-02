import java.util.Scanner;

/*
 * O bubble sort Compara pares de elementos adjacentes e os troca se estiverem na ordem errada.
 * 
 * CUSTO COMPUTACIONAL:
 * Melhor caso (já ordenado): 𝚯(n) se tiver uma otimização que verifica se houve trocas
 * Pior caso (ordenado ao contrário): 𝚯(n2)
 * Algoritmo estável e IN-PLACE
 */

public class BubbleSort {

    //Método do algoritmo de bolha tradicional sem melhorias
    public static void ordenarBubble(int[] array){
        int n = array.length;
        for(int rep = 0; rep < n - 1; rep++){
            for(int b = 0; b < n - 1; b++){
                if(array[b] > array[b + 1]){
                    int tmp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = tmp;
                }
            }
        }
    }

    //Método do algoritmo de bolha com melhorias 
    public static void ordenarBubbleMelhorado(int[] array){
        int n = array.length;
        boolean houveTroca = true;
        for(int rep = 0; rep < n - 1 && houveTroca; rep++){
            houveTroca = false;
            for(int b = 0; b < n - 1 - rep; b++){
                if(array[b] > array[b + 1]){
                    int tmp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = tmp;
                    houveTroca = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int valor[] = {20, 4, 3, 1, 10, 12, 15, 21};

        ordenarBubble(valor);

        System.out.print("[");
        for (int i = 0; i < valor.length; i++) {
            System.out.print(valor[i] + " ");
        }
        System.out.println("]");

        sc.close();
    }
}
