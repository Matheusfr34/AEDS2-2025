
class Celula {

    int elemento;
    Celula prox, ant;

    public Celula() {
        this.elemento = 0;
        this.prox = null;
        this.ant = null;
    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
        this.ant = null;
    }
}

class ListaDupla {

    Celula primeiro, ultimo;

    public ListaDupla() {
        primeiro = ultimo = new Celula();
    }

    public int tamanho() {
        int contador = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            contador++;
        }
        return contador;
    }

    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        tmp.ant = primeiro;

        if (primeiro == ultimo) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }

        tmp = null;
    }

    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

    public void inserir(int x, int pos) {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            throw new RuntimeException("Posição inválida.");
        } else if (primeiro == ultimo) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            Celula tmp = new Celula(x);
            Celula i = primeiro.prox;
            for (int j = 0; j < pos; j++, i = i.prox);
            tmp.ant = i.ant;
            tmp.prox = i;
            i.ant.prox = tmp;
            i.ant = tmp;

            tmp = null;
        }
    }

    public int removerInicio() {
        if (primeiro == ultimo) {
            throw new RuntimeException("Lista vazia.");
        }
    
        Celula tmp = primeiro.prox;
        int elemento = tmp.elemento;
        
        primeiro.prox = tmp.prox;
        
        if (tmp.prox != null) {
            tmp.prox.ant = primeiro;
        } else {
            ultimo = primeiro;
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
        ultimo.prox.ant = null;
        ultimo.prox = null;

        return elemento;
    }

    public int remover(int pos) {
        int tamanho = tamanho(), elemento = 0;
        if (primeiro == ultimo) {
            throw new RuntimeException("Lista vazia.");
        } else if (pos < 0 || pos >= tamanho) {
            throw new RuntimeException("Posição inválida.");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == tamanho - 1) {
            elemento = removerFim();
        } else {
            Celula i = primeiro.prox;
            for (int j = 0; j < pos; j++, i = i.prox);

            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            elemento = i.elemento;
            i.prox = i.ant = null;
            i = null;

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

public class ListaDuplaFlexivel {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        
        System.out.println("=== TESTANDO LISTA DUPLAMENTE ENCADEADA ===");
        
        // Teste 1: Inserção no início
        System.out.println("\n1. Inserindo no início:");
        lista.inserirInicio(10);
        lista.inserirInicio(20);
        lista.inserirInicio(30);
        lista.mostrar(); // [30 20 10]
        
        // Teste 2: Inserção no fim
        System.out.println("\n2. Inserindo no fim:");
        lista.inserirFim(40);
        lista.inserirFim(50);
        lista.mostrar(); // [30 20 10 40 50]
        
        // Teste 3: Inserção em posição específica
        System.out.println("\n3. Inserindo em posições específicas:");
        lista.inserir(100, 2); // entre 20 e 10
        lista.inserir(200, 0); // no início
        lista.inserir(300, lista.tamanho()); // no fim
        lista.mostrar(); // [200 30 20 100 10 40 50 300]
        
        // Teste 4: Remoção no início
        System.out.println("\n4. Removendo do início:");
        int removido = lista.removerInicio();
        System.out.println("Removido: " + removido); // 200
        lista.mostrar(); // [30 20 100 10 40 50 300]
        
        // Teste 5: Remoção no fim
        System.out.println("\n5. Removendo do fim:");
        removido = lista.removerFim();
        System.out.println("Removido: " + removido); // 300
        lista.mostrar(); // [30 20 100 10 40 50]
        
        // Teste 6: Remoção em posição específica
        System.out.println("\n6. Removendo de posições específicas:");
        removido = lista.remover(2); // remove 100
        System.out.println("Removido posição 2: " + removido);
        removido = lista.remover(0); // remove 30
        System.out.println("Removido posição 0: " + removido);
        removido = lista.remover(lista.tamanho()-1); // remove 50
        System.out.println("Removido última posição: " + removido);
        lista.mostrar(); // [20 10 40]
        
        // Teste 7: Tamanho da lista
        System.out.println("\n7. Tamanho da lista:");
        System.out.println("Tamanho: " + lista.tamanho()); // 3
        
        // Teste 8: Tentativas de erro
        System.out.println("\n8. Testando tratamentos de erro:");
        try {
            lista.remover(-1); // Posição inválida
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        
        try {
            lista.remover(10); // Posição inválida
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        
        try {
            lista.inserir(99, -1); // Posição inválida
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        
        // Teste 9: Removendo todos os elementos
        System.out.println("\n9. Removendo todos elementos:");
        while (lista.tamanho() > 0) {
            System.out.println("Removido: " + lista.remover(0));
            lista.mostrar();
        }
        
        // Teste 10: Tentativa de remoção com lista vazia
        try {
            lista.removerInicio(); // Lista vazia
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        
        System.out.println("\n=== TESTES CONCLUÍDOS ===");
    }
}
