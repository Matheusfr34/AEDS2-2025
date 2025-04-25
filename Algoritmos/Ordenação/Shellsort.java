/*
 * O Shell Sort é uma extensão do Insertion Sort que permite a troca de elementos distantes.
 * Ele divide o array em subarrays menores (gaps) e os ordena progressivamente, reduzindo o gap até 1.
 * 
 * CUSTO COMPUTACIONAL:
 * Conjecturas para o número de comparações:
 * C1 = 𝚯(nˆ1,25)
 * C2 = 𝚯(n(lnn)ˆ2)
 * 
 * VANTAGENS:
 * - Mais eficiente que Insertion Sort para arrays grandes.
 * - In-place (não requer memória adicional significativa).
 * 
 * DESVANTAGENS:
 * - Não é estável (a ordem relativa de elementos iguais pode mudar).
 * - Performance depende criticamente da escolha da sequência de gaps.
 */

public class Shellsort {
    public static void shellsort(int[] array){
        int h = 1;
        int n = array.length;
        do { 
            h = (h * 3) + 1;
        } while(h < n);
        do{
            h /= 3;
            for(int cor = 0; cor < h; cor++){
                insercaoPorCor(cor, h, n, array);
            }
        } while(h != 1);
    }

    public static void insercaoPorCor(int cor, int h, int n, int[] array){
        for(int i = (cor + h); i < n; i += h){
            int tmp = array[i];
            int j = i - h;
            while(j >= 0 && array[j] > tmp){
                array[j + h] = array[j];
                j -= h;
            }
            array[j + h] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array = {12, 4, 8, 2, 14, 17, 6, 18, 10, 16, 15, 5, 13, 9, 1, 11, 7, 3};

        shellsort(array);

        System.out.print("[ ");
        for (int elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }
}
