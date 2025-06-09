
class No {
    int elemento;
    No esq, dir;

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }

    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore {
    No raiz;
    public Arvore() {
        raiz = null;
    }

    boolean pesquisar(int elemento) {
        return pesquisar(elemento, raiz);
    }

    // Método para pesquisar um determinado elemento na árvore
    boolean pesquisar(int elemento, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (elemento == i.elemento) {
            resp = true;
        } else if (elemento < i.elemento) {
            resp = pesquisar(elemento, i.esq);
        } else {
            resp = pesquisar(elemento, i.dir);
        }

        return resp;
    }

    // Método para caminhar e printar a árvore
    void caminharCentral() {
        System.out.print("[ ");
        caminharCentral(raiz);
        System.out.println("]");
    }

    void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    void caminharPre() {
        System.out.print("[ ");
        caminharPre(raiz);
        System.out.println("]");
    }

    void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    void caminharPos() {
        System.out.print("[ ");
        caminharPos(raiz);
        System.out.println("]");
    }

    void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.print(i.elemento + " ");
        }
    }

    // Método para inserir elementos na árvore

    // Método para inserir com retorno de referência
    void inserir(int x) {
        raiz = inserir(x, raiz);
    }

    No inserir(int x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new RuntimeException("Erro.");
        }
        return i;
    }

    // Método para inserir com passagem de pai
    void inserirPai(int x) {
        if (raiz == null) {
            raiz = new No(x);
        } else if (x < raiz.elemento) {
            inserirPai(x, raiz.esq, raiz);
        } else if (x > raiz.elemento) {
            inserirPai(x, raiz.dir, raiz);
        } else {
            throw new RuntimeException("Erro.");
        }
    }

    void inserirPai(int x, No i, No pai) {
        if (i == null) {
            if (x < pai.elemento) {
                pai.esq = new No(x);
            } else {
                pai.dir = new No(x);
            }
        } else if (x < i.elemento) {
            inserirPai(x, i.esq, i);
        } else if (x > i.elemento) {
            inserirPai(x, i.dir, i);
        } else {
            throw new RuntimeException("Erro.");
        }
    }

    // Método para pegar o maior elemento contido na árvore de forma iterativa
    int getMaior() {
        int resp = 0;
        if (raiz != null) {
            No i;
            for (i = raiz; i.dir != null; i = i.dir);
            resp = i.elemento;
        }

        return resp;
    }

    // Método para pegar o maior elemento contido na árvore de forma recursiva
    int getMaiorRecursivo() {
        if (raiz == null) {
            throw new RuntimeException("Erro. Árvore vazia.");
        }
        return getMaiorRecursivo(raiz);
    }

    int getMaiorRecursivo(No i) {
        if (i.dir == null) {
            return i.elemento;
        }
        return getMaiorRecursivo(i.dir);
    }

    // Método para pegar o menor elemento contido na árvore de forma iterativa
    int getMenor() {
        int resp = 0;
        if (raiz != null) {
            No i;
            for (i = raiz; i.esq != null; i = i.esq);
            
            resp = i.elemento;
        }

        return resp;
    }

    // Método para pegar o menor elemento contido na árvore de forma recursiva
    int getMenorRecursivo() {
        if (raiz == null) {
            throw new RuntimeException("Erro. Árvore vazia.");
        }
        return getMenorRecursivo(raiz);
    }

    int getMenorRecursivo(No i) {
        if (i.esq == null) {
            return i.elemento;
        }
        return getMenorRecursivo(i.esq);
    }

    // Método para remover um elemento da árvore
    void remover(int x) {
        if (raiz == null) {
            throw new RuntimeException("Erro. Árvore vazia.");
        }
        raiz = remover(x, raiz);
    }

    No remover(int x, No i) {
        if (i == null) {
            throw new RuntimeException("Erro. Elemento inexistente.");
        } else if (x < i.elemento) {
            i.esq = remover(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = remover(x, i.dir);
        } else if (i.esq == null) {
            i = i.dir;
        } else if (i.dir == null) {
            i = i.esq;
        } else {
            i.esq = maiorEsq(i, i.esq);
        }
        return i;
    }

    No maiorEsq(No i, No j) {
        if (j.dir == null) {
            i.elemento = j.elemento;
            j = j.esq;
        } else {
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

    /* ------ EXERCICIOS ÁRVORE BINÁRIA ------ */

    //Exercício 1 - Método que retorna a altura árvore
    public int getAltura(No i, int altura){
        if(i == null){
            altura--;
        } else {
            int alturaEsq = getAltura(i.esq, altura++);
            int alturaDir = getAltura(i.dir, altura++);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }
        return altura;
    }
    
    //Exercício 2 - Método que retorna a soma dos elementos presentes na árvore
    public int soma(){
        return soma(raiz);
    }

    private int soma(No i){
        int soma = 0;
        if(i != null){
            soma = i.elemento + soma(i.esq) + soma(i.dir);
        }
        return soma;
    }

    //Exercício 3 - Método que retorna o número de elementos pares existente na árvore 
    public int contarPares(){
        return contarPares(raiz);
    }

    private int contarPares(No i){
        int contador = 0;

        if(i != null){
            if(i.elemento % 2 == 0){
                contador++;
            }
            contador += contarPares(i.esq);
            contador += contarPares(i.dir);
        }

        return contador;
    }

    //Exercício 4 - Método que retorna true se a árvore contém algum número divisível por 11
    public boolean contemDiviselOnze() {
        return contemDivisivelOnze(raiz);
    }
    
    private boolean contemDivisivelOnze(No i) {
        if (i == null) {
            return false;
        }
        
        if (i.elemento % 11 == 0) {
            return true;
        }
        
        return contemDivisivelOnze(i.esq) || contemDivisivelOnze(i.dir);
    }

}

public class ArvoreBinaria {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        
        System.out.println("=== TESTE DA ÁRVORE BINÁRIA DE BUSCA ===");
        
        // Teste 1: Árvore vazia
        System.out.println("\n--- Teste 1: Comportamento com árvore vazia ---");
        try {
            System.out.println("Maior elemento: " + arvore.getMaior());
        } catch (Exception e) {
            System.out.println("Erro ao buscar maior: " + e.getMessage());
        }
        
        try {
            System.out.println("Menor elemento: " + arvore.getMenor());
        } catch (Exception e) {
            System.out.println("Erro ao buscar menor: " + e.getMessage());
        }
        
        System.out.println("Pesquisar 10: " + arvore.pesquisar(10));
        arvore.caminharCentral();
        arvore.caminharPre();
        arvore.caminharPos();
        
        // Teste 2: Inserção de elementos
        System.out.println("\n--- Teste 2: Inserção de elementos ---");
        int[] elementos = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 85};
        
        for (int elem : elementos) {
            arvore.inserir(elem);
            System.out.println("Inserido: " + elem);
        }
        
        System.out.println("\nÁrvore após inserções:");
        arvore.caminharCentral();
        
        // Teste 3: Pesquisa de elementos
        System.out.println("\n--- Teste 3: Pesquisa de elementos ---");
        System.out.println("Pesquisar 50 (raiz): " + arvore.pesquisar(50));
        System.out.println("Pesquisar 20 (esquerda): " + arvore.pesquisar(20));
        System.out.println("Pesquisar 80 (direita): " + arvore.pesquisar(80));
        System.out.println("Pesquisar 100 (inexistente): " + arvore.pesquisar(100));
        
        // Teste 4: Caminhamentos
        System.out.println("\n--- Teste 4: Caminhamentos ---");
        System.out.print("Central (ordenado): ");
        arvore.caminharCentral();
        
        System.out.print("Pré-ordem: ");
        arvore.caminharPre();
        
        System.out.print("Pós-ordem: ");
        arvore.caminharPos();
        
        // Teste 5: Maior e menor elementos
        System.out.println("\n--- Teste 5: Maior e menor elementos ---");
        System.out.println("Maior elemento (iterativo): " + arvore.getMaior());
        System.out.println("Maior elemento (recursivo): " + arvore.getMaiorRecursivo());
        System.out.println("Menor elemento (iterativo): " + arvore.getMenor());
        System.out.println("Menor elemento (recursivo): " + arvore.getMenorRecursivo());
        
        // Teste 6: Remoção de elementos
        System.out.println("\n--- Teste 6: Remoção de elementos ---");
        System.out.println("Remover 20 (folha)");
        arvore.remover(20);
        System.out.print("Central após remoção: ");
        arvore.caminharCentral();
        
        System.out.println("Remover 30 (com dois filhos)");
        arvore.remover(30);
        System.out.print("Central após remoção: ");
        arvore.caminharCentral();
        
        System.out.println("Remover 70 (com dois filhos)");
        arvore.remover(70);
        System.out.print("Central após remoção: ");
        arvore.caminharCentral();
        
        System.out.println("Remover 50 (raiz)");
        arvore.remover(50);
        System.out.print("Central após remoção: ");
        arvore.caminharCentral();
        
        // Teste 7: Inserção após remoção
        System.out.println("\n--- Teste 7: Inserção após remoção ---");
        System.out.println("Inserir 90");
        arvore.inserir(90);
        System.out.print("Central após inserção: ");
        arvore.caminharCentral();
        
        System.out.println("Inserir 15");
        arvore.inserir(15);
        System.out.print("Central após inserção: ");
        arvore.caminharCentral();
        
        // Teste 8: Tentativa de remover elemento inexistente
        System.out.println("\n--- Teste 8: Tentativa de remover elemento inexistente ---");
        try {
            arvore.remover(99);
        } catch (RuntimeException e) {
            System.out.println("Erro ao remover 99: " + e.getMessage());
        }
        
        // Teste 9: Tentativa de inserir elemento duplicado
        System.out.println("\n--- Teste 9: Tentativa de inserir elemento duplicado ---");
        try {
            arvore.inserir(60);
            arvore.inserir(60); // Tentativa duplicada
        } catch (RuntimeException e) {
            System.out.println("Erro ao inserir duplicado: " + e.getMessage());
        }
        
        // Teste 10: Estado final da árvore
        System.out.println("\n--- Teste 10: Estado final da árvore ---");
        System.out.print("Central: ");
        arvore.caminharCentral();
        System.out.print("Pré-ordem: ");
        arvore.caminharPre();
        System.out.print("Pós-ordem: ");
        arvore.caminharPos();
        System.out.println("Maior elemento: " + arvore.getMaior());
        System.out.println("Menor elemento: " + arvore.getMenor());

        // Teste 11: Soma dos elementos contidos na árvore
        System.out.println("Soma: " + arvore.soma());
        System.out.println("Quant. de números pares: " + arvore.contarPares());
        System.out.println("Contém divisível por 11: " + arvore.contemDiviselOnze());
    }
}