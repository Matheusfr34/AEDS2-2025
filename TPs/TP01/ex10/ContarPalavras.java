//package TPs.TP01.ex10;

import java.util.Scanner;

public class ContarPalavras {
    public static int contarPalavras(String frase){
        int contarPalavras = 1;
        for(int i = 0; i < frase.length(); i++){
            char caracter = frase.charAt(i);
            if(caracter == 32){
                contarPalavras++;
            }
        }
        return contarPalavras;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String frase = sc.nextLine();
            if(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'){
                break;
            }
            System.out.println(contarPalavras(frase));
        }
        
        sc.close();
    }
}
