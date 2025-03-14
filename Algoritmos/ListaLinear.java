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
        
    }

    public int removerFim(){
        if(n == 0){
            System.out.println("ERRO. LISTA CHEIA");
            return 0;
        }
        return array[--n];
    }
}

public class ListaLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        Lista lista = new Lista(tamanho);

        lista.inserirInicio(3);
        lista.inserirInicio(4);
        lista.inserirInicio(5);
        lista.inserirInicio(7);

        sc.close();
    }
}