import java.util.*;

class Fila{
    int[] array;
    int primeiro, ultimo;

    //Construtor que cria a fila circular e aponta os ponteiros primeiro e ultimo para 0
    public Fila(int tam){
        array = new int[tam + 1];
        primeiro = ultimo = 0;
    }

    //Método para inserir um elemento na fila (enqueue ou enfileirar)
    public void enfileirar(int elemento){
        if(((ultimo + 1) % array.length) == primeiro){
            System.out.println("Erro");
            return;
        }

        array[ultimo] = elemento;
        ultimo = (ultimo + 1) % array.length;
    }

    //Método para remover um elemento na fila (dequeue ou desenfileirar)
    public int desenfileirar(){
        if(primeiro == ultimo){
            System.out.println("Erro");
            return 0;
        }

        int resp = array[primeiro];
        primeiro = (primeiro + 1) % array.length;

        return resp;
    }

    //Método para mostrar os elementos presentes na fila 
    public void mostrar(){
        int i = primeiro;
        System.out.print("[ ");
        while(i != ultimo){
            System.out.print(array[i] + " ");
            i = (i + 1) % array.length;
        }
        System.out.println("]");
    }

    //Método recursivo para mostrar os elementos presentes na fila
    public void mostrarRecursivo(int i){
        if(i != ultimo){
            System.out.print(array[i] + " ");
            mostrarRecursivo((i + 1) % array.length);
        }
    }

    //Método para pesquisar se um elemento está presente na fila circular 
    public boolean pesquisar(int elemento){
        int i = primeiro;
        while(i != ultimo){
            if(array[i] == elemento){
                return true;
            }
            i = (i + 1) % array.length;
        }
        return false;
    }

    //Método que verifica se uma fila circular está vazia
    public boolean isVazia(){
        if(primeiro == ultimo){
            return true;
        }
        return false;
    }

    //Método que verifica se uma fila circular está cheia
    public boolean isCheia(){
        if(((ultimo + 1) % array.length) == primeiro){
            return true;
        }
        return false;
    }

    //Método para retornar a posição 
    public int retornarPos(int pos){
        if(primeiro == ultimo || pos < 0 || pos >= ultimo){
            System.out.println("Erro.");
            return 0;
        }
        return array[pos];
    }
}

public class FilaCircular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tam = sc.nextInt();

        Fila fila = new Fila(tam);

        for(int i = 0; i < tam; i++){
            int valor = sc.nextInt();
            fila.enfileirar(valor);
        }

        fila.mostrarRecursivo(0);

        sc.close();
    }
}
