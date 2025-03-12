import java.util.Scanner;

public class Parenteses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String entrada = sc.nextLine();
            int contador = 0;

            for(int i = 0; i < entrada.length(); i++){
                if(entrada.charAt(0) == ')' && contador == 0){
                    contador--;
                    break;
                } else if (contador < 0) {
                    break;
                }else if(entrada.charAt(i) == '('){
                    contador++;
                } else if(entrada.charAt(i) == ')'){
                    contador--;
                }
            }
            
            if(contador == 0){
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
        sc.close();
    }
}
