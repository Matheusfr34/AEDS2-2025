import java.util.Scanner;

class Lista {
    int array[];
    int n;

    //Construtor para criar uma lista com um tamanho fixo de 10
    Lista(){
        array = new int[10];
        n = 0;
    } 
    //Construtor para criar uma lista que recebe do usuário o tamanho 
    Lista(int tamanho){
        array = new int[tamanho];
        n = 0;
    }

    public void inserirInicio(int x){
        if(n >= array.length){
            System.out.println("ERRO. LISTA CHEIA");
            return;
        } 
        for(int i = n; i > 0; i--){
            array[i] = array[i - 1];
        }
        array[0] = x;
        n++;
    }

    public void inserirFim(int x){
        if(n >= array.length){
            System.out.println("ERRO. LISTA CHEIA");
            return;
        }
        array[n] = x;
        n++;
    }

    public void inserirPos(int x, int pos){
        if(n >= array.length || pos < 0 || pos > n){
            System.out.println("ERRO. LISTA CHEIA");
            return;
        }
        for(int i = n; i > pos; i--){
            array[i] = array[i - 1];
        }
        array[pos] = x;
        n++;
    }

    public int removerInicio(){
        if(n == 0){
            System.out.println("ERRO. LISTA CHEIA");
            return 0;
        }

        n--;
        int resp = array[0];

        for(int i = 0; i < n; i++){
            array[i] = array[i + 1];
        }

        return resp;
    }

    public int removerFim(){
        if(n == 0){
            System.out.println("ERRO. LISTA CHEIA");
            return 0;
        }
        return array[--n];
    }

    public int removerPos(int pos){
        if(n == 0 || pos < 0 || pos >= n){
            System.out.println("ERRO. LISTA CHEIA");
            return 0;
        }
        n--; 
        int resp = array[pos];
        for(int i = pos; i < n; i++){
            array[i] = array[i + 1];
        }

        return resp;
    }

    public boolean pesquisar(int x){
        for(int i = 0; i < n; i++){
            if(array[i] == x){
                return true;
            }
        }
        return false;
    }

    public void mostrar(){
        System.out.println();
        System.out.print("[ ");
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    //Exercício 1 - implemente um método que retorna a soma dos elementos contidos na mesma. 
    public int somar(){
        int soma = 0;
        for(int i = 0; i < n; i++){
            soma += array[i];
        }
        return soma;
    }

    //Exercício 2 - implemente um método que retorna o maior elemento contido na mesma. 
    public int maior(){
        int maior = array[0];
        for(int i = 1; i < n; i++){
            if(array[i] > maior){
                maior = array[i];
            }
        }
        return maior;
    }

    //Exercício 3 - implemente um método que inverte a ordem dos seus elementos. 
    public void inverter(){
        for(int i = 0; i < n/2; i++){
            int tmp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = tmp;
        }
    }

    //Exercicio 4 - implemente um método que retorna o número de elementos pares and múltiplos de cinco contidos na mesma.
    public int paresAndMultiplos(){
        int contador = 0;
        for(int i = 0; i < n; i++){
            if(array[i] % 2 == 0 && array[i] % 5 == 0){
                contador++;
            }
        }
        return contador;
    }

    //Exercício 5 - Modifique nossa lista linear, criando uma lista ordenada. 
    public void ordenarInsercao(){
        for(int i = 1; i < n; i++){
            int tmp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > tmp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }

}

public class ListaLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        Lista lista = new Lista(tamanho);

        int valores[] = new int[tamanho];
        for(int i = 0; i < valores.length; i++){
            valores[i] = sc.nextInt();
            lista.inserirFim(valores[i]);
        }

        lista.mostrar();
        System.out.println();
        System.out.println("SOMA DOS NÚMEROS: " + lista.somar());
        System.out.println("MAIOR: " + lista.maior());
        System.out.println("QUANT. PARES E MÚLTIPLOS DE 5: " + lista.paresAndMultiplos());
        if(lista.pesquisar(5)){
            System.out.println("ELEMENTO EXISTE");
        } else {
            System.out.println("ELEMENTO NÃO EXISTE");
        }
        lista.ordenarInsercao();
        lista.mostrar();

        sc.close();
    }
}