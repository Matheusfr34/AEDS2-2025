package TADs;

class CelulaDupla {
    public int elemento;
    public CelulaDupla ant, prox;

    public CelulaDupla() {
        this.elemento = 0;
    }

    public CelulaDupla(int x) {
        this.elemento = x;
        this.prox = this.ant = null;
    }
}

class ListaDupla {

    private CelulaDupla primeiro, ultimo;

    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    // Esse método retorna o tamanho da lista
    public int tamanho() {
        int contador = 0;
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            contador++;
        }
        return contador; // Retorna o número de elementos reais na lista
    }

    public void inserirInicio(int x) {
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }

    public void inserirFim(int x) {
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.ant = ultimo;
        ultimo.prox = tmp;
        ultimo = tmp;
        tmp = null;
    }

    public int removerInicio() {
        if (primeiro == ultimo) {
            throw new RuntimeException("Lista vazia.");
        }
        CelulaDupla tmp = primeiro.prox;
        int elemento = tmp.elemento;

        primeiro.prox = tmp.prox;

        // Verifica se a lista ficou vazia após a remoção
        if (primeiro.prox != null) {
            primeiro.prox.ant = primeiro;
        } else {
            ultimo = primeiro; // Atualiza 'ultimo' para 'primeiro' se a lista ficou vazia
        }

        tmp.prox = tmp.ant = null;
        tmp = null;

        return elemento;
    }

    public int removerFim() {

        if (primeiro == ultimo) {
            throw new RuntimeException("Lista vazia.");
        }

        int elemento = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox = null;

        return elemento;
    }

    public void Inserir(int x, int pos) {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            throw new RuntimeException("Posição inválida.");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            CelulaDupla tmp = new CelulaDupla(x);
            tmp.ant = i;
            tmp.prox = i.prox;
            i.prox.ant = tmp; // Ponteiro de anterior ajustado explicitamente
            i.prox = tmp; // Ponteiro de próximo ajustado explicitamente
            tmp = i = null;
        }
    }

    public int Remover(int pos) {
        int elemento, tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            throw new RuntimeException("Posição inválida.");
        } else if (primeiro == ultimo) {
            throw new RuntimeException("Lista vazia.");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == tamanho - 1) {
            elemento = removerFim();
        } else {
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            CelulaDupla tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox.ant = i;
            tmp.prox = tmp.ant = null;
            tmp = null;
        }
        return elemento;
    }

    public void Mostrar() {
        System.out.print("[ ");
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }

    public void Inverter() {
        CelulaDupla i = primeiro.prox, j = ultimo;
        while (i != j && j.prox != i) {
            int tmp = i.elemento;
            i.elemento = j.elemento;
            j.elemento = tmp;
            i = i.prox;
            j = j.ant;
        }
    }

    /* EXERCÍCIO - Implemente o algoritmo de Shellsort na lista dupla. */
    public void shellsort() {
        int tamanho = tamanho(); // Obtém o tamanho da lista
        int h = 1;
    
        // Define o intervalo inicial usando a sequência de Knuth: h = h * 3 + 1
        while (h < tamanho) {
            h = h * 3 + 1;
        }
    
        while (h > 0) {
            // Diminui o intervalo conforme o algoritmo de Shellsort
            h /= 3;
    
            // Realiza a ordenação com base no intervalo h
            for (int i = h; i < tamanho; i++) {
                // Navega até o nó correspondente ao índice i
                CelulaDupla atual = primeiro.prox;
                for (int j = 0; j < i; j++) {
                    atual = atual.prox;
                }
    
                int tmpElemento = atual.elemento;
                CelulaDupla jCelula = atual;
    
                // Executa a ordenação com a lógica do Shellsort
                for (int j = i; j >= h; j -= h) {
                    // Navega até o nó correspondente a (j - h)
                    CelulaDupla anterior = jCelula;
                    for (int k = 0; k < h; k++) {
                        anterior = anterior.ant;
                    }
    
                    if (anterior.elemento <= tmpElemento) {
                        break;
                    }
    
                    // Move o elemento de 'anterior' para 'jCelula'
                    jCelula.elemento = anterior.elemento;
                    jCelula = anterior;
                }
    
                // Coloca o elemento temporário na posição correta
                jCelula.elemento = tmpElemento;
            }
        }
    }
    
}

public class ListaDuplaFlex {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        lista.inserirInicio(6);
        lista.inserirFim(5);
        lista.inserirFim(4);
        lista.inserirFim(3);
        lista.inserirFim(2);
        lista.inserirFim(1);
        lista.Mostrar();
        lista.shellsort();
        lista.Mostrar();
    }
}

