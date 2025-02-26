import java.util.*;

public class EvenAndOdd {

    //Ordenar os números pares em ordem crescente (Utilizei o Selection Sort)
    public static void ordenarPares(int[] pares, int tamanho){
        for(int i = 0; i < tamanho - 1; i++){
            int menor = i;
            for(int j = i + 1; j < tamanho; j++){
                if(pares[menor] > pares[j]){
                    menor = j;
                }
            }

            int temp = pares[menor];
            pares[menor] = pares[i];
            pares[i] = temp;
        }
    }


    //Ordenar os números pares em ordem decrescente (Utilizei o Selection Sort)
    public static void ordenarImpares(int[] impares, int tamanho){
        for(int i = 0; i < tamanho - 1; i++){
            int menor = i;
            for(int j = i + 1; j < tamanho; j++){
                if(impares[menor] < impares[j]){
                    menor = j;
                }
            }

            int temp = impares[menor];
            impares[menor] = impares[i];
            impares[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();

        int[] valor = new int[quantidade];
        int[] pares = new int[100];
        int[] impares = new int[100];
        int tamPares = 0, tamImpares = 0;

        for(int i = 0; i < quantidade; i++){
            valor[i] = sc.nextInt();
            if(valor[i] % 2 == 0){
                pares[tamPares] = valor[i];
                tamPares++;
            } else {
                impares[tamImpares] = valor[i];
                tamImpares++;
            }
        }

        ordenarPares(pares, tamPares);
        ordenarImpares(impares, tamImpares);

        for(int i = 0; i < tamPares; i++){
            System.out.println(pares[i]);
        }

        for(int i = 0; i < tamImpares; i++){
            System.out.println(impares[i]);
        }


        sc.close();
    
    }
}
