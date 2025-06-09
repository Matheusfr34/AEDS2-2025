class Celula {

    int elemento;
    Celula prox;

    //Construtores
    public Celula() {
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class Lista {

    Celula primeiro, ultimo;

    public Lista() {
        primeiro = ultimo = new Celula();
    }

    public int tamanho() {
        int contador = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            contador++;
        }

        return contador;
    }

    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirPos(int x, int pos) {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            System.out.println("Erro. Posição inválida.");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            Celula tmp = new Celula(x);
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            tmp.prox = i.prox;
            i.prox = tmp;
            i = tmp = null;
        }
    }

    public int removerFim() {
        if (primeiro == ultimo) {
            System.out.println("Erro. Lista vazia");
        }
        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox);
        int elemento = ultimo.elemento;
        ultimo = i;
        ultimo.prox = null;
        i = null;

        return elemento;
    }

    public int removerInicio() {
        if (primeiro == ultimo) {
            System.out.println("Erro. Lista vazia.");
        }
        Celula tmp = primeiro.prox;
        int elemento = tmp.elemento;
        primeiro.prox = tmp.prox;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    public int removerPos(int pos) {
        int elemento = 0, tamanho = tamanho();
        if (pos < 0 || pos >= tamanho || primeiro == ultimo) {
            System.out.println("Erro.");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == tamanho - 1) {
            elemento = removerFim();
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            tmp = i = null;
        }
        return elemento;
    }

    public boolean pesquisar(int x){
        boolean resp = false;
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            if(i.elemento == x){
                resp = true;
            }
        }
        return resp;
    }

    public void mostrar() {
        System.out.print("[ ");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");

    }

}

class Tabela{
    Lista tabela[];

    public Tabela() {
        tabela = new Lista[7];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = new Lista();
        }
    }

    public Tabela(int tam) {
        tabela = new Lista[tam];
        for (int i = 0; i < tam; i++) {
            tabela[i] = new Lista();
        }
    }

    public int hash(int x){
        int tam = tabela.length;
        return x % tam;
    }

    public void inserir(int x){
        int i = hash(x);
        if(tabela[i] == null){
            tabela[i].inserirFim(x);
        } else {
            tabela[i].inserirFim(x);
        }
    }

    public boolean pesquisar(int x){
        int i = hash(x);
        boolean resp = false;

        if(tabela[i] != null && tabela[i].pesquisar(x)){
            resp = true;
        }
        
        return resp;
    }

    public void mostrar(){
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(i + ": ");
            tabela[i].mostrar();
            System.out.println();
        }
    }
}

public class HashComLista {
    public static void main(String[] args) {
        Tabela tabela = new Tabela();

        tabela.inserir(5);
        tabela.inserir(7);
        tabela.inserir(14);
        tabela.inserir(21);
        tabela.inserir(19);
        tabela.inserir(3);
        tabela.mostrar();
        System.out.println(tabela.pesquisar(3));

    }
}
