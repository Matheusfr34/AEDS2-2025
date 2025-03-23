import java.util.Scanner;

public class Combinador{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            
            int tam1 = str1.length();
            int tam2 = str2.length();

            int maior = tam1 > tam2 ? tam1 : tam2;

            StringBuilder str = new StringBuilder();

            for(int i = 0; i < maior; i++){
                if(i < tam1){
                    str.append(str1.charAt(i));
                }
                if(i < tam2){
                    str.append(str2.charAt(i));
                }
            }

            System.out.println(str.toString());
        }
        sc.close();
    }
}