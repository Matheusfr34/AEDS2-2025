import java.util.Scanner;

class PilhaLinear {
    int[] array;
    int n;

    //construtor que cria a pilha e armazena tam elementos.
    public PilhaLinear(int tam){
        array = new int[tam];
        n = 0;
    }

    //Método para inserir um elemento no fim (empilhar ou push) - Custo Computacional Θ(1)
    public void empilhar(int elemento){
        if(n >= array.length){
            throw new IllegalStateException("Array está cheio, não é possível inserir mais elementos.");
        }

        array[n] = elemento;
        n++;
    }

    //Método para remover um elemento no fim (desempilhar ou pop) - Custo Computacional Θ(1)
    public int desempilhar(){
        if(n == 0){
            throw new IllegalStateException("Array está vazio.");
        }

        return array[--n];
    }

    //Método para pesquisar se um elemento está presente na pilha - Custo Computacional Θ(n)
    public boolean pesquisar(int elemento){
        for(int i = 0; i < n; i++){
            if(array[i] == elemento){
                return true;
            }
        }
        return false;
    }

    //Método que imprime os elementos da pilha, imprime na ordem que são removidos
    public void mostrar(){
        System.out.print("[ ");
        for(int i = n - 1; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    //Método que imprime os elementos da pilha de forma recursiva, imprime na ordem que são removidos
    public void mostrarRecursivo(int i){
        if(i < n){
            System.out.print(array[n - i - 1] + " ");
            mostrarRecursivo(i + 1);
        }
    }
    
}
public class Pilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tam = sc.nextInt();

        //Criando a instância de pilha 
        PilhaLinear pilha = new PilhaLinear(tam);

        for(int i = 0; i < tam; i++){
            int valor = sc.nextInt();
            pilha.empilhar(valor);
        }

        pilha.mostrarRecursivo(0);

        sc.close();
    }
}
