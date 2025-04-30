package TADs;

class Celula {
    public int elemento;
    public Celula prox;

    public Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
}

class Pilha {
    private Celula topo;

    //Construtor para construir a pilha e apontar o topo para null
    public Pilha(){
        topo = null;
    }

    //Método para inserir elemento 
    public void Inserir(int x){
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }
    
    //Método para remover elemento
    public int Remover(){
        if(topo == null){
            throw new RuntimeException("Erro. Não existe elementos para remover."); //Exceção para caso a lista esteja vazia
        }
        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox; 
        tmp.prox = null;
        tmp = null;
        return elemento;
    }
    
    //Método para mostrar elemento
    public void Mostrar(){
        System.out.print("[");
        for(Celula i = topo; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
  
    }

}

public class PilhaFlexivel {
    public static void main(String[] args){
        
        Pilha pilha = new Pilha();
        
        pilha.Inserir(10);
        pilha.Inserir(15);
        pilha.Mostrar();
        pilha.Remover();
        pilha.Mostrar();

    }
}
