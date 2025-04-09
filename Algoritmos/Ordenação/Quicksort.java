/*
 * O selection sort sempre pega o menor elemento do array e coloca ele na posição correta. 
 * Dessa forma, ele sempre percorre todo o array. 
 * 
 * CUSTO COMPUTACIONAL:
 * 
 * VANTAGENS:
 * O número de movimentações é linear e isso é interessante para uma grande quantidade de registros
 * 
 * DESVANTAGENS:
 * 𝚯(n2) comparações
 * Não há melhor caso, pois sempre percorre todo array
 * Algoritmo não estável e IN-PLACE
 */

public class Quicksort {
    public static void ordenarQuicksort(int[] array, int esq, int dir){
        int i = esq, j = dir, pivo = array[(esq + dir)/2];
        while(i <= j){
            //Esse while percorre a parte inferior do array e busca um elemento maior que o pivô
            while(array[i] < pivo){
                i++;
            }
            //Esse while percorre a parte superior do array e busca um elemento menor que o pivô
            while(array[j] > pivo){
                j--;
            }
            //Esse if realiza o swap dos elementos nas posições erradas
            if(i <= j){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        //Chamada recursiva para a parte inferior do array
        if(esq < j){
            ordenarQuicksort(array, esq, j);
        }
        //Chamada recursiva para a parte superior do array
        if(i < dir){
            ordenarQuicksort(array, i, dir);
        }
    }
    public static void main(String[] args) {
        int array[] = {0, 1, 5, 3, 15, 16, 9, 10, 4, 3, 30, 5, 20, 48, 71, 82};

        ordenarQuicksort(array, 0, array.length - 1);
        System.out.print("[ ");
        for(int valor : array){
            System.out.print(valor + " ");
        }
        System.out.println("]");
    }
}
