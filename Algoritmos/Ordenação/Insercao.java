/*
 * O Insertion Sort percorre o array e insere cada elemento na posição correta dentro da parte já ordenada.
 * É eficiente para conjuntos de dados pequenos ou quase ordenados.
 * 
 * CUSTO COMPUTACIONAL:
 * - Pior caso: 𝚯(n²) (array em ordem inversa)
 * - Melhor caso: 𝚯(n) (array já ordenado)
 * - Caso médio: 𝚯(n²)
 * 
 * VANTAGENS:
 * - Simples de implementar e eficiente para pequenos conjuntos de dados.
 * - Estável (mantém a ordem relativa de elementos iguais).
 * - In-place (baixo uso de memória adicional).
 * - Adaptável: performance melhora com arrays parcialmente ordenados.
 * 
 * DESVANTAGENS:
 * - Ineficiente para grandes volumes de dados (complexidade quadrática).
 * - Número elevado de comparações e trocas no pior caso.
 */

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
