import java.util.Scanner;

class Fila {
    int[] array;
    int n;
    //Construtor para criar uma fila 
    public Fila(int tam){
        array = new int[tam];
        n = 0;
    }

    //Método para inserir um elemento em uma fila (enfileirar ou enqueue) - Custo Computacional Θ(1)
    public void enfileirar(int elemento){
        if(n >= array.length){
            throw new IllegalStateException("Array está cheio, não é possível inserir mais elementos.");
        }

        array[n] = elemento;
        n++;
    }

    ////Método para remover um elemento em uma fila (desenfileirar ou dequeue) - Custo Computacional Θ(n)
    public int desenfileirar(){
        if(n == 0){
            throw new IllegalStateException("Array está vazio.");
        }
        n--;
        int resp = array[0];
        for(int i = 0; i < n; i++){
            array[i] = array[i + 1];
        }

        return resp;
    }

    //Método para pesquisar se um elemento existe na fila
    public boolean pesquisar(int elemento){
        for(int i = 0; i < n; i++){
            if(array[i] == elemento){
                return true;
            }
        }
        return false;
    }

    //Método que imprime os elementos da fila, imprime na ordem que são inseridos
    public void mostrar(){
        System.out.print("[ ");
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    //Método que inveter os elementos da fila 
    public void inverter(){
        for(int i = 0; i < n / 2; i++){
            int tmp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = tmp;
        }
    }

    //Método recursivo para mostrar os elementos na ordem que serão removidos
    public void mostrarRecursivo(int i){
        if(i < n){
            System.out.print(array[i] + " ");
            mostrarRecursivo(i + 1);
        }
    }

}

public class FilaLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tam = sc.nextInt();

        Fila fila = new Fila(tam);

        for(int i = 0; i < tam; i++){
            int valor = sc.nextInt();
            fila.enfileirar(valor);
        }

        fila.mostrar();
        fila.mostrarRecursivo(0);

        sc.close();
    }
}
