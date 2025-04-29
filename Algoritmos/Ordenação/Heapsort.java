public class Heapsort {
    public static void swap(int a, int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void heapsort(int[] array) {
        int n = array.length;

        // Construção do heap máximo (ajustado para indexação 0)
        for (int tam = 1; tam < n; tam++) {
            construir(tam, array);
        }

        // Extrai elementos do heap e reconstrói
        int tam = n - 1; // índice do último elemento
        while (tam > 0) {
            swap(0, tam--, array); // Move a raiz (maior elemento) para o final
            reconstruir(tam, array); // Reconstrói o heap reduzido
        }
    }

    // Constrói o heap máximo (subindo)
    public static void construir(int tam, int[] array) {
        int i = tam;
        while (i > 0 && array[i] > array[(i - 1) / 2]) { // Compara com o pai
            swap(i, (i - 1) / 2, array);
            i = (i - 1) / 2;
        }
    }

    // Reconstrói o heap máximo (descendo)
    public static void reconstruir(int tam, int[] array) {
        int i = 0;
        while (hasFilho(i, tam)) {
            int filho = getMaiorFilho(i, tam, array);
            if (array[i] < array[filho]) {
                swap(i, filho, array);
                i = filho;
            } else {
                break; // Se não precisa trocar, o heap está correto
            }
        }
    }

    // Retorna o índice do maior filho
    public static int getMaiorFilho(int i, int tam, int[] array) {
        int filhoEsq = 2 * i + 1;
        int filhoDir = 2 * i + 2;

        if (filhoDir > tam || array[filhoEsq] > array[filhoDir]) {
            return filhoEsq;
        } else {
            return filhoDir;
        }
    }

    // Verifica se o nó tem pelo menos um filho
    public static boolean hasFilho(int i, int tam) {
        return (2 * i + 1) <= tam;
    }

    public static void main(String[] args) {
        int[] array = {12, 4, 8, 2, 14, 17, 6, 18, 10, 16, 15, 5, 13, 9, 1, 11, 7, 3};

        heapsort(array);

        System.out.print("[ ");
        for (int elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }
}