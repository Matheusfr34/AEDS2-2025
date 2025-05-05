
import java.util.Scanner;

class Celula {

    int elemento;
    Celula esq, dir, sup, inf;

    public Celula() {
        this.elemento = 0;
        this.esq = null;
        this.dir = null;
        this.sup = null;
        this.inf = null;
    }

    public Celula(int x) {
        this.elemento = x;
        this.esq = null;
        this.dir = null;
        this.sup = null;
        this.inf = null;
    }
}

class Matriz {

    Celula inicio;
    int linha, coluna;

    public Matriz() {
        this.linha = 4;
        this.coluna = 4;

        construirMatriz();
    }

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;

        construirMatriz();
    }

    public void construirMatriz() {
        inicio = new Celula();

        Celula auxLinha, auxColuna;
        auxLinha = auxColuna = inicio;

        // Esse for é utilizado para preencher a primeira linha da matriz, ou seja, a
        // quantidade de colunas
        for (int i = 1; i < coluna; i++) {
            Celula tmp = new Celula();
            auxColuna.dir = tmp;
            tmp.esq = auxColuna;
            auxColuna = tmp;
            tmp = null;
        }

        // Esse for é utilizado para preencher as próximas linhas da matriz
        for (int i = 1; i < linha; i++) {
            Celula tmp = new Celula();
            auxLinha.inf = tmp;
            tmp.sup = auxLinha;
            auxLinha = tmp;

            auxColuna = auxLinha;

            for (int j = 1; j < coluna; j++) {
                auxColuna.dir = new Celula();
                auxColuna.dir.esq = auxColuna;
                auxColuna = auxColuna.dir;
                auxColuna.sup = auxColuna.esq.sup.dir;
                auxColuna.sup.inf = auxColuna;
            }
        }

    }

    public void inserir(int[] elemento) {
        Celula auxColuna, auxLinha;
        auxLinha = inicio;
        int contador = 0;

        for (int i = 0; i < linha; i++) {
            auxColuna = auxLinha;
            for (int j = 0; j < coluna; j++) {
                auxColuna.elemento = elemento[contador++];
                auxColuna = auxColuna.dir;
            }

            auxLinha = auxLinha.inf;
        }
    }

    public void mostrar() {
        Celula auxLinha = inicio;

        for (int i = 0; i < linha; i++) {
            Celula auxColuna = auxLinha;
            System.out.print("[ ");

            for (int j = 0; j < coluna; j++) {
                System.out.print(auxColuna.elemento + " ");
                auxColuna = auxColuna.dir;
            }

            System.out.println("]");
            auxLinha = auxLinha.inf;
        }
    }

    /* ------ EXERCICIOS MATRIZ FLEXÍVEL ------ */

    // Exercício 1 - Método que retorna as somas dos elementos
    public int somarElementos() {
        Celula auxLinha = inicio, auxColuna;
        int soma = 0;

        for (int i = 0; i < linha; i++) {
            auxColuna = auxLinha;

            for (int j = 0; j < coluna; j++) {
                soma += auxColuna.elemento;
                auxColuna = auxColuna.dir;
            }

            auxLinha = auxLinha.inf;
        }

        return soma;
    }

    // Exercício 2 - Método que retorna o produto dos elementos
    public int multiplicarElementos() {
        Celula auxLinha = inicio, auxColuna;
        int produto = 1;

        for (int i = 0; i < linha; i++) {
            auxColuna = auxLinha;

            for (int j = 0; j < coluna; j++) {
                produto *= auxColuna.elemento;
                auxColuna = auxColuna.dir;
            }

            auxLinha = auxLinha.inf;
        }

        return produto;
    }

    // Exercício 3 - Método que remove a última coluna da matriz
    public void removerUltimaColuna() {
        Celula aux;

        for (aux = inicio; aux.dir != null; aux = aux.dir);

        for (int i = 0; i < linha; i++) {
            Celula celulaAbaixo = aux.inf;

            // Desconecta a célula da esquerda
            if (aux.esq != null) {
                aux.esq.dir = null;
                aux.esq = null;
            }

            // Desconecta a célula de cima da de baixo
            if (celulaAbaixo != null) {
                celulaAbaixo.sup = null;
                aux.inf = null;
            }

            // Move para a célula abaixo (se existir)
            aux = celulaAbaixo;

        }
    }

    // Exercício 4 - Método que imprime os elementos da diagonal principal
    public void getDiagonalPrincipal() {
        if (coluna != linha) {
            System.out.println("Não é uma matriz quadrada.");
            return;
        }

        Celula aux = inicio;
        System.out.println("Elementos da diagonal principal:");

        for (int i = 0; i < linha; i++) {
            System.out.print(aux.elemento + " ");

            // Verifica se pode mover para a próxima célula da diagonal
            if (i < linha - 1) { // Se não é o último elemento
                if (aux.dir == null || aux.dir.inf == null) {
                    System.out.println("\nErro: Estrutura da matriz inconsistente!");
                    return;
                }
                aux = aux.dir.inf;
            }
        }
        System.out.println();
    }

    // Exercício 5 - Método que imprime os elementos da diagonal principal

}

public class MatrizFlexivel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a quantidade de linhas: ");
        int quantLinhas = sc.nextInt();
        System.out.println("Informe a quantidade de colunas: ");
        int quantColunas = sc.nextInt();

        Matriz matriz = new Matriz(quantLinhas, quantColunas);

        int vetor[] = new int[quantColunas * quantLinhas];

        for (int i = 0; i < quantLinhas * quantColunas; i++) {
            System.out.println("Digite o número " + (i + 1) + ":");
            vetor[i] = sc.nextInt();
        }

        matriz.inserir(vetor);
        matriz.mostrar();
        System.out.println("SOMA: " + matriz.somarElementos());
        System.out.println("MULTIPLICAÇÃO: " + matriz.multiplicarElementos());
        matriz.getDiagonalPrincipal();

        sc.close();
    }
}
