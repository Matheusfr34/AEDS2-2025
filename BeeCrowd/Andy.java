import java.util.Scanner;

class No {
    String palavra;
    No esq, dir;

    public No(String palavra) {
        this.palavra = palavra;
        this.esq = null;
        this.dir = null;
    }

    public No(String palavra, No esq, No dir) {
        this.palavra = palavra;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore {
    No raiz;

    public Arvore() {
        raiz = null;
    }

    // Método para inserir na árvore
    void inserir(String palavra) {
        raiz = inserir(palavra, raiz);
    }

    No inserir(String x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (x.compareTo(i.palavra) < 0) {
            i.esq = inserir(x, i.esq);
        } else if (x.compareTo(i.palavra) > 0) {
            i.dir = inserir(x, i.dir);
        }
        return i;
    }

    // Método para imprimir ordenado (Caminhamento Central ou em Ordem)
    void caminharCentral() {
        caminharCentral(raiz);
    }

    void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.println(i.palavra);
            caminharCentral(i.dir);
        }
    }

}

public class Andy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Arvore arvore = new Arvore();

        while (sc.hasNext()) {
            String input = sc.next();
            String entrada = input.toLowerCase();

            StringBuilder str = new StringBuilder();

            for (int i = 0; i < entrada.length(); i++) {
                char caracter = entrada.charAt(i);
                if (caracter >= 'a' && caracter <= 'z') {
                    str.append(caracter);
                } else {
                    if (str.length() > 0) {
                        String palavra = str.toString();
                        arvore.inserir(palavra);
                        str.setLength(0);
                    }
                }
            }

            if (str.length() > 0) {
                String palavra = str.toString();
                arvore.inserir(palavra);
                str.setLength(0);
            }
        }

        arvore.caminharCentral();
        sc.close();
    }
}
