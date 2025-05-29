import java.util.Scanner;

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
        this.raiz = null;
    }

    public void inserir(int x){
        raiz = inserir(raiz, x);
    }

    private No inserir(No i, int x){
        if(i == null){
            i = new No(x);
        } else if(x < i.elemento){
            i.esq = inserir(i.esq, x);
        } else if(x > i.elemento){
            i.dir = inserir(i.dir, x);
        } else {
            throw new RuntimeException("Erro.");
        }

        return i;
    }

    public void prefixo(){
        System.out.print("Pre.: ");
        prefixo(raiz);
        System.out.println();
    }

    private void prefixo(No i){
        if(i != null){
            System.out.print(i.elemento + " ");
            prefixo(i.esq);
            prefixo(i.dir);
        }
    }

    public void infixo(){
        System.out.print("In..: ");
        infixo(raiz);
        System.out.println();
    }

    private void infixo(No i){
        if(i != null){
            infixo(i.esq);
            System.out.print(i.elemento + " ");
            infixo(i.dir);
        }
    }

    public void posfixo(){
        System.out.print("Post: ");
        posfixo(raiz);
        System.out.println();
    }

    private void posfixo(No i){
        if(i != null){
            posfixo(i.esq);
            posfixo(i.dir);
            System.out.print(i.elemento + " ");
        }
    }
}

public class ArvoreBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testes = sc.nextInt();

        for (int i = 0; i < testes; i++) {
            Arvore arvore = new Arvore();
            int quantElementos = sc.nextInt();
            int elemento[] = new int[quantElementos];
            for (int j = 0; j < quantElementos; j++) {
                elemento[j] = sc.nextInt();
                arvore.inserir(elemento[j]);
            }

            System.out.println("Case " + (i + 1) + ":");
            arvore.prefixo();
            arvore.infixo();
            arvore.posfixo();
            
            System.out.println();
        }

        sc.close();
    }
}
