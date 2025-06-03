import java.util.Scanner;

public class MarkAndToys{
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

    public static int maximumToys(int[] prices, int budget){
        int tam = prices.length;
        int contador = 0;

        for(int i = 0; i < tam; i++){
            if(prices[i] <= budget){
                budget -= prices[i];
                contador++;
            }
        }

        return contador;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int toys[] = new int[n];

        for(int i = 0; i < n; i++){
            toys[i] = sc.nextInt();
        }

        ordenarQuicksort(toys, 0, toys.length - 1);

        System.out.println(maximumToys(toys, k));

        sc.close();
    }
}