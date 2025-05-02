class Celula {
    int elemento;
    Celula prox;

    //Construtores
    public Celula(){
        this.elemento = 0;
        this.prox = null;
    }
    public Celula(int elemento){
        this.elemento = elemento;
        this.prox = null;
    }
}

class Lista {
    Celula primeiro, ultimo;

    public Lista(){
        primeiro = ultimo = new Celula();
    }

    public int tamanho(){
        int contador = 0;
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            contador++;
        }

        return contador;
    }

    public void inserirFim(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public void inserirInicio(int x){
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox; 
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirPos(int x, int pos){
        int tamanho = tamanho();
        if(pos < 0 || pos > tamanho){
            System.out.println("Erro. Posição inválida.");
        } else if(pos == 0){
            inserirInicio(x);
        } else if(pos == tamanho){
            inserirFim(x);
        } else {
            Celula tmp = new Celula(x);
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = primeiro.prox);
            tmp.prox = i.prox;
            i.prox = tmp;
            i = tmp = null;
        }
    }

    public int removerFim(){
        if(primeiro == ultimo){
            System.out.println("Erro. Lista vazia");
        }
        int elemento = ultimo.elemento;
        Celula i;
        for(i = primeiro.prox; i != null; i = i.prox);
        ultimo = i;
        ultimo.prox = null;
        i = null;

        return elemento;
    }

    public int removerInicio(){
        if(primeiro == ultimo){
            System.out.println("Erro. Lista vazia.");
        }
        Celula tmp = primeiro.prox;
        int elemento = tmp.elemento;
        primeiro.prox = tmp.prox;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    public int removerPos(int pos){
        int elemento = 0, tamanho = tamanho();
        if(pos < 0 || pos >= tamanho || primeiro == ultimo){
            System.out.println("Erro.");
        } else if(pos == 0){
            elemento = removerInicio();
        } else if(pos == tamanho - 1){
            elemento = removerFim();
        } else {
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            tmp = i = null;
        }
        return elemento;
    }

    public void mostrar(){
        System.out.print("[ ");
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }

}

public class ListaFlexivel {

    public static void main(String[] args) {
        
    }
}
