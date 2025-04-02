package Algoritmos.Pesquisa;

/* A pesquisa sequencial verifica o array posição por posição para encontrar um determinado elemento
 * para isso, eu criei a função pesquisar para fazer tal verificação. Caso o elemento exista no array,
 * a função retorna true, caso contrário false.
 * 
 * CUSTO COMPUTACINAL -
 * No pior caso é Θ(n). Esse caso acontece quando o elemento procurado não existe ou está no fim do array.
 * No melhor caso é Θ(1). Esse caso acontece quando o elemento está na primeira posição do array.
 * Além disso, a operação relevante é a comparação entre os elementos do array.
 */

public class PesquisaSequencial {

    public static boolean pesquisar(int x, int[] valores) {
        boolean resp = false;
        for (int i = 0; i < valores.length; i++) {
            if(valores[i] == x){
                resp = true;
                break;
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        int valores[] = {2, 8, 3, 10, 15, 20};
        if (pesquisar(3, valores)) {
            System.out.println("VALOR EXISTE NO ARRAY");
        } else {
            System.out.println("VALOR NÃO EXISTE NO ARRAY");
        }
    }
}