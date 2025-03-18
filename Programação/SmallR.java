
import java.util.Scanner;

public class SmallR {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        sc.nextLine(); //consumir quebra de linha 

        float razao = (1 - (float) a / (float) b) * (1 - (float) c / (float) d);
        float valor = 1 - (razao / (1 - razao));

        System.out.println(valor);
    
        sc.close();
    }
}
