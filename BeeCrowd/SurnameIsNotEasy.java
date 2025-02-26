// 3358 - Sobrenome não é fácil (05/02/2025)

import java.util.Scanner;

public class SurnameIsNotEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        String sobrenomes[] = new String[quantidade];
        for(int i = 0; i < quantidade; i++){
            sobrenomes[i] = sc.next();
        }
        
        char caracterAtual;
        String vogais = "AEIOUaeiou";

        for(int i = 0; i < quantidade; i++){
            int contador = 0;
            boolean ehFacil = true;

            for(int j = 0; j < sobrenomes[i].length(); j++){
                caracterAtual = sobrenomes[i].charAt(j);
                if(!vogais.contains(String.valueOf(caracterAtual))){
                    contador++;
                    if(contador > 2){
                        System.out.println(sobrenomes[i] + " nao eh facil");
                        ehFacil = false;
                        break;
                    }
                } else {
                    contador = 0;
                }
            }
            if(ehFacil){
                System.out.println(sobrenomes[i] + " eh facil");
            }
        }
        sc.close();
    }
}
