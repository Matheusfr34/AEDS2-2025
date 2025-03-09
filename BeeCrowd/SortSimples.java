
import java.util.Scanner;

public class SortSimples {

    public static int[] ordenarNumero(int[] valores) {
        int[] copia = valores.clone();

        for (int i = 1; i < copia.length; i++) {
            int tmp = copia[i];
            int j = i - 1;
            while (j >= 0 && copia[j] > tmp) {
                copia[j + 1] = copia[j];
                j--;
            }
            copia[j + 1] = tmp;
        }
        return copia;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero[] = new int[3];
        numero[0] = sc.nextInt();
        numero[1] = sc.nextInt();
        numero[2] = sc.nextInt();

        int arrayOrdenado[] = ordenarNumero(numero);

        System.out.println(arrayOrdenado[0]);
        System.out.println(arrayOrdenado[1]);
        System.out.println(arrayOrdenado[2]);

        System.out.println();

        System.out.println(numero[0]);
        System.out.println(numero[1]);
        System.out.println(numero[2]);


        sc.close();
    }
}
