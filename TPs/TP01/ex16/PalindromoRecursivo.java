import java.util.Scanner;
public class PalindromoRecursivo{
    //Método recursivo para verificar se é palíndromo 
    public static boolean ehPalindromoRecursivo(String texto, int i, int j){
        //Caso os dois sejam iguais, a string foi percorrida por completa
        if(i >= j){
            return true;
        }
        if(texto.charAt(i) != texto.charAt(j)){
            return false;
        }
        return ehPalindromoRecursivo(texto, i + 1, j - 1);
    }

    //Método para verificar se é um palindromo e que retorna o método recursivo
    public static boolean ehPalindromo(String texto){
        int tamanho = texto.length();
        
        return ehPalindromoRecursivo(texto, 0, tamanho - 1);
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