//Questão 2722

import java.util.Scanner;

public class Evergreen {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine();

        int tamanho, tamUm, tamDois;
        for(int i = 0; i < quantidade; i++){
            String entrada1 = sc.nextLine();
            String entrada2 = sc.nextLine();
            StringBuilder str = new StringBuilder();

            tamUm = entrada1.length();
            tamDois = entrada2.length();
            tamanho = tamUm + tamDois;

            for(int j = 0, k = 0, l = 0; j < tamanho; j++, k+=2, l+=2){
                if(k < tamUm){
                    str.append(entrada1.charAt(k));
                    if(k + 1 <  tamUm){
                        str.append(entrada1.charAt(k + 1));
                    }
                }
                if(l < tamDois){
                    str.append(entrada2.charAt(l));
                    if(l + 1 < tamDois){
                        str.append(entrada2.charAt(l + 1));
                    }
                }
            }
            System.out.println(str);
        }
        
        sc.close();
    }
}