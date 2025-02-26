package Algoritmos;

/* A pesquisa binária faz uma busca sempre no meio do array e vai dividindo o escopo de busca pela metade 
 * a cada iteração. Por esse motivo, acaba sendo um algoritmo de pesquisa eficiente, porém o array precisa
 * estar ordenado para que ele funcione corretamente.
 * CUSTO COMPUTACINAL -
 * No pior caso é Θ(log n). Esse caso acontece quando o elemento procurado não existe ou está na última posição de procura.
 * No melhor caso é Θ(1). Esse caso acontece quando o elemento está no meio do array, ou seja, onde se inicia a busca.
 * Além disso, a operação relevante é a comparação entre os elementos do array.
 */

public class PesquisaBinaria {

    public static boolean pesquisar(int x, int[] valor) {
        boolean resp = false;

        int tamanho = valor.length;
        int dir = tamanho - 1, esq = 0, meio, diferenca; //dir = tam - 1, pois é para pegar o index da última posição e no array

        while (esq <= dir) {
            meio = (esq + dir) / 2;
            diferenca = (x - valor[meio]);
            if (diferenca == 0) {
                resp = true;
                break;
            } else if (diferenca > 0) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }

        return resp;
    }

    public static void main(String[] args) {
        int valor[] = {3, 5, 7, 9, 11, 15, 20, 24};
        if (pesquisar(15, valor)) {
            System.out.println("VALOR EXISTE NO ARRAY");
        } else {
            System.out.println("VALOR NÃO EXISTE NO ARRAY");
        }

    }
}