import java.util.Scanner;

public class Insercao {
    public static void ordenarInsercao(int[] array){
        for(int i = 1; i < array.length; i++){
            int tmp = array[i];
            int j = i -1;
            while(j >= 0 && array[j] > tmp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }

    public static void ordernarInsercaoPesquisaBinaria(int[] array){
        for(int i = 1; i < array.length; i++){
            int tmp = array[i];
            int esq = 0, dir = i - 1;
            
            while(esq < dir){
                int meio = (dir + esq) / 2;
                if(tmp > array[meio]){
                    esq = meio;
                } else {
                    dir = meio;
                }
            }

            if(tmp > esq){
                esq++;
            }

            for(int j = i - 1; j >= esq; j--){
                array[j + 1] = array[j];
            }

            array[esq] = tmp;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        int valor[] = new int[quantidade];

        for(int i = 0; i < quantidade; i++){
            valor[i] = sc.nextInt();
        }

        sc.close();
    }
}
