import java.util.Scanner;

public class FilaDoRecreio {

    public static int ordenarNumeros(int[] valores){
        int mov = 0;
        for(int i = 1; i < valores.length; i++){
            int tmp = valores[i];
            int j = i - 1;

            boolean movimentado = false; 

            while(j >= 0 && valores[j] > tmp){
                valores[j + 1] = valores[j];
                j--;
                movimentado = true;
            }

            if(!movimentado){
                mov++;
            }

            valores[j + 1] = tmp;
        }
        return mov;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casosTeste = sc.nextInt();

        for(int i = 0; i < casosTeste; i++){
            int quantidade = sc.nextInt();
            int[] valores = new int[quantidade];
            for(int j = 0; j < quantidade; j++){
                valores[j] = sc.nextInt();
            }

            System.out.println(ordenarNumeros(valores));

        }

        sc.close();
    }
}
