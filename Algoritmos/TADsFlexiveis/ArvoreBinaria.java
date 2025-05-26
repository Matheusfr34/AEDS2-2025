class No{
    int elemento;
    No esq, dir;

    public No(int elemento){
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }

    public No(int elemento, No esq, No dir){
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore{
    No raiz;

    public Arvore(){
        raiz = null;
    }

    boolean pesquisar(int elemento){
        return pesquisar(elemento, raiz);
    }

    //Método para pesquisar um determinado elemento na árvore
    boolean pesquisar(int elemento, No i){
        boolean resp;
        if(i == null){
            resp = false;
        } else if(elemento == i.elemento){
            resp = true;
        } else if(elemento < i.elemento){
            resp = pesquisar(elemento, i.esq);
        } else {
            resp = pesquisar(elemento, i.dir);
        }

        return resp;
    }

    //Método para caminhar e printar a árvore
    void caminharCentral(){
        System.out.print("[ ");
        caminharCentral(raiz);
        System.out.println("]");
    }

    void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    void caminharPre(){
        System.out.print("[ ");
        caminharPre(raiz);
        System.out.println("]");
    }

    void caminharPre(No i){
        if(i != null){
            System.out.print(i.elemento + " ");
            caminharPre(i.esq);
            caminharCentral(i.dir);
        }
    }

    void caminharPos(){
        System.out.print("[ ");
        caminharPos(raiz);
        System.out.println("]");
    }

    void caminharPos(No i){
        caminharPos(i.esq);
        caminharPos(i.dir);
        System.out.print(i.elemento + " ");
    }
}

public class ArvoreBinaria{
    public static void main(String[] args){

    }
}