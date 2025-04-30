//Esse código cria uma lista flexível em Java
package TADs;

class Celula {
    public int elemento;
    public Celula prox;

    // Construtor que cria uma alocação com valor 0 (Café com leite)
    public Celula() {
        this.elemento = 0;
        this.prox = null;
    }

    // Construtor que cria uma alocação com valor x
    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Lista {

    /*
     * Criação das referências primeiro e ultimo, as duas começam apontando para a
     * café com leite
     */
    private Celula primeiro, ultimo;
    private int contador;

    // Construtor que cria uma alocação com as referências primeiro e último
    public Lista() {
        primeiro = ultimo = new Celula();
        contador = 0;
    }

    // Esse método retorna o tamanho da lista
    public int tamanho() {
        return contador; // Retorna o número de elementos reais na lista

    }

    // Esse método insere um elemento no fim da lista
    public void inserirFim(int x) {
        ultimo.prox = new Celula(x); // Cria uma alocação para o elemento x e aponta o prox de ultimo para esse
                                     // espaço
        ultimo = ultimo.prox;
        contador++;
    }

    // Esse método insere um elemento no início da lista
    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox; // Aponta o prox de tmp para onde o prox de primeiro aponta
        primeiro.prox = tmp; // Altera o apontador de primeiro para tmp, ao invés de último
        if (primeiro == ultimo) { // Verifica se a lista está vazia
            ultimo = tmp;
        }
        tmp = null; // Questão de organização
        contador++;
    }

    //InserirInicio de tal forma que o novo valor seja inserido no nó cabeça
    public void inserirNoCabeca(int x){
        primeiro.elemento = x;
        Celula novaCabeca = new Celula();
        novaCabeca.prox = primeiro;

        primeiro = novaCabeca;

        if (ultimo == novaCabeca) { // Verifica se a lista está vazia
            ultimo = novaCabeca.prox;
        }

        contador++;
    }

    // Esse método remove um elemento no fim da lista
    public int removerFim() {
        Celula i;
        if (primeiro == ultimo) {
            throw new RuntimeException("A lista está vazia."); // Exceção para caso a lista esteja vazia
        }
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ; // Esse 'for' percorre até a penúltima célula antes da última
        int elemento = ultimo.elemento;
        ultimo = i;
        ultimo.prox = null;
        i = null; // Questão de organização

        contador--;
        return elemento; // Retornar o elemento removido
    }

    /* Esse método remove logicamente um elemento no início da lista, usando a
    lógica de que a célula removida se torna a café com leite */
    public int removerInicio() {
        if (primeiro == ultimo) {
            throw new RuntimeException("A lista está vazia."); // Exceção para caso a lista esteja vazia
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox; // Aponta o primeiro para a próxima célula que passa a ser a nova café com leite
        int elemento = primeiro.elemento; // Pega o novo primeiro elemento que agora é a nova célula café com leite
        tmp.prox = tmp = null; // Remover a alocação do espaço vazio que antes era a célula café com leite

        contador--;
        return elemento;
    }

    // Esse método remove fisicamente um elemento do início da lista
    public int RemoverInicio() {
        if (primeiro == ultimo) {
            throw new RuntimeException("A lista está vazia."); // Exceção para caso a lista esteja vazia
        }
        Celula tmp = primeiro.prox;
        primeiro = primeiro.prox.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;

        contador--;
        return elemento;
    }

    // Esse método insere um elemento em qualquer posição válida
    public void Inserir(int x, int pos) {
        // Esses if conferem se a posição é válida
        if (pos < 0 || pos > tamanho()) {
            throw new RuntimeException("Posição inválida.");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho()) {
            inserirFim(x);
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            i = tmp = null;
            contador++;
        }
    }

    // Esse método remove um elemento em qualquer posição válida
    public int Remover(int pos) {
        int elemento, tamanho = tamanho();
        if (primeiro == ultimo || pos < 0 || pos >= tamanho) {
            throw new RuntimeException("Posição inválida.");
        } else if (pos == 0) {
            return RemoverInicio();
        } else if (pos == tamanho - 1) {
            return removerFim();
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            tmp.prox = null;
            i.prox = tmp.prox;
            i = tmp = null;
        }
        contador--;
        return elemento;

    }

    public void Mostrar() {
        System.out.print("[");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
        System.err.println("Tamanho: " + contador);
    }

    // Exercício
    public void Inverter() {
        if (primeiro == null || primeiro.prox == null) {
            return; // Lista vazia ou com apenas um elemento não precisa ser invertida
        }

        Celula anterior = null;
        Celula atual = primeiro.prox;
        Celula proximo = null;

        while (atual != null) {
            proximo = atual.prox;
            atual.prox = anterior;
            anterior = atual;
            atual = proximo;
        }

        // Atualizar o primeiro e o último após a inversão
        ultimo = primeiro.prox;
        primeiro.prox = anterior;
    }

    /* ------ EXERCICIOS LISTA SIMPLES ------ */

    // Exercício 1 - Remover a segunda posição válida
    public int removerSegunda() {
        Celula tmp = primeiro.prox.prox;
        int elemento = tmp.elemento;
        primeiro.prox.prox = tmp.prox;
        tmp.prox = null;
        contador--;
        return elemento;
    }

    // Exercício 2 - Lista simples sempre ordenada (Utilize o algoritmo de Inserção)
    public void ordenarLista() {
        if (primeiro.prox == null || primeiro.prox.prox == null) {
            return; // Lista vazia ou com um único elemento já está ordenada
        }

        Celula fim = primeiro.prox; // Último nó da lista ordenada

        while (fim.prox != null) {
            Celula atual = fim.prox;
            int elemento = atual.elemento;
            if (fim.elemento <= elemento) {
                fim = fim.prox;
            } else {
                fim.prox = atual.prox;

                Celula pos;
                for (pos = primeiro; pos.prox != null && pos.prox.elemento < elemento; pos = pos.prox)
                    ;

                atual.prox = pos.prox;
                pos.prox = atual;
            }
        }
    }

    /* Exercício 3 - Na lista simples, crie um contador para a quantidade de elementos. */

    /* Exercício 4 - InserirInicio de tal forma que o novo valor seja inserido no nó cabeça */

    

}

public class ListaFlexivel {
    public static void main(String[] args) {

        Lista lista = new Lista();

        lista.inserirNoCabeca(5);
        lista.inserirFim(4);
        lista.inserirFim(3);
        lista.inserirFim(2);
        lista.inserirFim(1);
        lista.Mostrar();
        lista.ordenarLista();
        lista.Mostrar();
    }

}
