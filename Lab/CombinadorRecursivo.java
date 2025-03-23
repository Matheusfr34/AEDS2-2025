import java.util.Scanner;

public class CombinadorRecursivo {
    public static String combinar(String str1, String str2, StringBuilder str, int pos, int i){
        int tam1 = str1.length();
        int tam2 = str2.length();

        int maior = tam1 > tam2 ? tam1 : tam2;
        if(i < maior){
            if(i < tam1){
                str.append(str1.charAt(i));
                pos++;
            }
            if(i < tam2){
                str.append(str2.charAt(i));
                pos++;
            }
            return combinar(str1, str2, str, pos, i + 1);
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();

            StringBuilder juncao = new StringBuilder();

            System.out.println(combinar(str1, str2, juncao, 0, 0));
        }
        sc.close();
    }
}
