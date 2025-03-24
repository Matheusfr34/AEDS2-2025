import java.util.Scanner;

public class SequenciaEspelho {
    public static String inverter(String[] valores, StringBuilder str){
        for(int i = 0; i < valores.length; i++){
            int tam = valores[i].length();
            for(int j = 0; j < tam; j++){
                str.append(valores[i].charAt(tam - 1 - j));
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            int valores1[] = new int[num2 - num1 + 1];
            int valores2[] = new int[num2 - num1 + 1];
            StringBuilder str = new StringBuilder();

            for(int i = 0; i < valores1.length; i++){
                valores1[i] = num1 + i;
                str.append(valores1[i]);
            }

            for(int j = 0; j < valores2.length; j++){
                valores2[j] = num2 - j;
            }

            String valores[] = new String[num2 - num1 + 1];
            for(int i = 0; i < valores.length; i++){
                valores[i] = Integer.toString(valores2[i]);
            }

            System.out.println(inverter(valores, str));
        }
        sc.close();
    }
}
