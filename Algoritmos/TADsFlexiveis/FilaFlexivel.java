package TADs;

class Celula {
    
    public int elemento;
    public Celula prox;
    
    // Construtor que cria uma alocação com valor 0 (Café com leite)
    public Celula(){
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
}

class Fila {
    public Celula primeiro, ultimo;
    
    public Fila(){
        primeiro = ultimo = new Celula();
    }

    //Método para inserir um elemento em uma fila (ENQUEUE) - Insere sempre no final 
    public void Inserir(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    //Método para remover um elemento em uma fila (DEQUEUE) - Remove sempre no início 
    public int Remover(){
        if(primeiro == ultimo){
            throw new RuntimeException("Fila vazia.");
        }
        Celula tmp = primeiro.prox;
        int elemento = tmp.elemento;
        primeiro.prox = primeiro.prox.prox;
        if (primeiro.prox == null) { // Se a fila ficou vazia, atualiza o último
            ultimo = primeiro;
        }
        tmp.prox = null;

        return elemento;
    }

    public void Mostrar(){
        System.out.print("[ ");
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        } 
        System.out.println("]");
    }
}

public class FilaFlexivel {
    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.Inserir(10);
        fila.Remover();
        fila.Inserir(15);
        fila.Inserir(20);
        fila.Mostrar();
    }
}
