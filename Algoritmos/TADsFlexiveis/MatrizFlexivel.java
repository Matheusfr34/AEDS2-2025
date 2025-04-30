package TADs;

class CelulaMatriz {
    public int elemento;
    public CelulaMatriz esq, dir, sup, inf;

    // Construtor que inicializa o elemento com 0 e as referências nulas
    public CelulaMatriz() {
        this(0);
        /*
         * this.elemento = 0;
         * this.esq = this.dir = this.sup =
         * this.inf = null;
         */
    }

    public CelulaMatriz(int x) {
        this.elemento = x;
        this.esq = this.dir = this.sup = this.inf = null;
    }

    public CelulaMatriz(int x, CelulaMatriz esq, CelulaMatriz dir, CelulaMatriz sup, CelulaMatriz inf) {
        this.elemento = x;
        this.esq = esq;
        this.dir = dir;
        this.sup = sup;
        this.inf = inf;
    }
}

class Matriz {
    private CelulaMatriz inicio;
    private int linhas, colunas;

    // Construtores
    public Matriz() {
        this.inicio = null;
        this.linhas = 0;
        this.colunas = 0;
    }

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.inicio = new CelulaMatriz();

        CelulaMatriz al = inicio;
        CelulaMatriz ac;

        for (int j = 1; j < colunas; j++) {
            CelulaMatriz novaCelula = new CelulaMatriz();
            al.dir = novaCelula;
            novaCelula.esq = al;
            al = novaCelula;
        }

        al = inicio;

        for (int i = 1; i < linhas; i++) {
            CelulaMatriz novaLinha = new CelulaMatriz();
            al.inf = novaLinha;
            novaLinha.sup = al;
            ac = novaLinha;

            for (int j = 1; j < colunas; j++) {
                CelulaMatriz novaCelula = new CelulaMatriz();
                ac.dir = novaCelula;
                novaCelula.esq = ac;
                ac = novaCelula;

                if (al.dir != null) {
                    al = al.dir;
                    al.inf = ac;
                    ac.sup = al;
                }
            }

            al = novaLinha;
        }
    }

    // Método para exibir a matriz
    public void mostrar() {
        CelulaMatriz linhaAtual = inicio;
        while (linhaAtual != null) {
            CelulaMatriz colunaAtual = linhaAtual;
            while (colunaAtual != null) {
                System.out.print(colunaAtual.elemento + " ");
                colunaAtual = colunaAtual.dir;
            }
            System.out.println();
            linhaAtual = linhaAtual.inf;
        }
    }

    // Método para inserir no início
    public void inserirInicio(int x) {
        inicio.elemento = x;
    }

    // Método para inserir no fim
    public void inserirFim(int x) {
        CelulaMatriz linhaAtual = inicio;
        while (linhaAtual.inf != null) {
            linhaAtual = linhaAtual.inf;
        }
        CelulaMatriz colunaAtual = linhaAtual;
        while (colunaAtual.dir != null) {
            colunaAtual = colunaAtual.dir;
        }
        colunaAtual.elemento = x;
    }

    // Método para inserir em uma posição específica
    public void inserirPosicao(int linha, int coluna, int x) {
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas) {
            throw new IndexOutOfBoundsException("Posição fora dos limites da matriz.");
        }

        CelulaMatriz temp = inicio;
        for (int i = 0; i < linha; i++) {
            temp = temp.inf;
        }
        for (int j = 0; j < coluna; j++) {
            temp = temp.dir;
        }
        temp.elemento = x;
    }

    // Método para remover do início
    public void removerInicio() {
        inicio.elemento = 0;
    }

    // Método para remover do fim
    public void removerFim() {
        CelulaMatriz linhaAtual = inicio;
        while (linhaAtual.inf != null) {
            linhaAtual = linhaAtual.inf;
        }
        CelulaMatriz colunaAtual = linhaAtual;
        while (colunaAtual.dir != null) {
            colunaAtual = colunaAtual.dir;
        }
        colunaAtual.elemento = 0;
    }

    // Método para remover em uma posição específica
    public void removerPosicao(int linha, int coluna) {
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas) {
            throw new IndexOutOfBoundsException("Posição fora dos limites da matriz.");
        }

        CelulaMatriz temp = inicio;
        for (int i = 0; i < linha; i++) {
            temp = temp.inf;
        }
        for (int j = 0; j < coluna; j++) {
            temp = temp.dir;
        }
        temp.elemento = 0;
    }
}

public class MatrizFlexivel {
    public static void main(String[] args) {
        // Cria uma matriz 
        Matriz matriz = new Matriz(20, 9);

        // Insere valores na matriz
        matriz.inserirInicio(1); // Insere 1 no início
        matriz.inserirFim(9);    // Insere 9 no fim
        matriz.inserirPosicao(1, 1, 5); // Insere 5 na posição (1,1)
        
        // Exibe a matriz após as inserções
        System.out.println("Matriz após inserções:");
        matriz.mostrar();

        // Remove valores da matriz
        matriz.removerInicio(); // Remove o valor do início
        matriz.removerFim();    // Remove o valor do fim
        matriz.removerPosicao(1, 1); // Remove o valor na posição (1,1)
        
        // Exibe a matriz após as remoções
        System.out.println("\nMatriz após remoções:");
        matriz.mostrar();
    }

}
