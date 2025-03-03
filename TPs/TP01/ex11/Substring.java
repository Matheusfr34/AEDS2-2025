//package TPs.TP01.ex11;
import java.util.*;

public class Substring {
    public static int substringMaisLonga(String palavra){
        int contador = 0, maisLonga = 0, inicio = 0;

        for(int i = 0; i < palavra.length(); i++){
            //Esse segundo for é usado para verificar se o caracter já apareceu dentro da substring
            for(int j = inicio; j < i; j++){
                if(palavra.charAt(i) == palavra.charAt(j)){
                    inicio = j + 1;
                    contador = i - inicio; //Para reiniciar a contagem da substring válida
                    break;
                }
            }
            contador++;
            if(contador > maisLonga){
                maisLonga = contador;
            }
        }
        return maisLonga;
    }
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()){
        String entrada = sc.nextLine();
        if(entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M'){
            break;
        }
        System.out.println(substringMaisLonga(entrada));
    }
    sc.close();
   } 
}
