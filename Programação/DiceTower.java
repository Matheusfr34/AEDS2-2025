
import java.util.Scanner;

public class DiceTower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int favourite = sc.nextInt();
        long values[] = new long[favourite];
        for (int i = 0; i < favourite; i++) {
            values[i] = sc.nextLong();
        }

        for (int i = 0; i < favourite; i++) {
            if (values[i] >= 15 && values[i] % 14 != 0) {
                if (values[i] % 14 <= 6) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
                
                sc.close();
            }
    }
