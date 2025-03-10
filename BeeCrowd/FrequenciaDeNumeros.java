import java.util.Scanner;

public class FrequenciaDeNumeros {
    public static void ordenarNumeros(int[] valores){
        for(int i = 1; i < valores.length; i++){
            int tmp = valores[i];
            int j = i -1;
            while(j >= 0 && valores[j] > tmp){
                valores[j + 1] = valores[j];
                j--;
            }
            valores[j + 1] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        int entrada[] = new int[quantidade];
        
        for(int i = 0; i < quantidade; i++){
            entrada[i] = sc.nextInt();
        }

        ordenarNumeros(entrada);

        for(int i = 0; i < entrada.length; i++){
            int contador = 1;
            for(int j = i + 1; j < entrada.length; j++){
                if(entrada[i] == entrada[j]){
                    contador++;
                    i = j;
                }
            }
            System.out.println(entrada[i] + " aparece " + contador + " vez(es)");
        }


        sc.close();
    }
}
