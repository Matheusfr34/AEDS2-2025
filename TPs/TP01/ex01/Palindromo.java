package TPs.TP01.ex01;

import java.util.Scanner;
public class Palindromo{
    public static boolean ehPalindromo(String texto){
        int i = 0;
        int j = texto.length() - 1;

        while(i < j){
            if(texto.charAt(i) != texto.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while(!flag){
            String entrada = sc.nextLine();
            if(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M'){
                flag = true;
            } else {
                if(ehPalindromo(entrada)){
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        }
        
        sc.close();
    }
}