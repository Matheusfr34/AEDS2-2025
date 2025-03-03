//package TPs.TP01.ex08;
import java.util.Scanner;

public class SomaDigitos {

    public static int Somar(String numero){
        int soma = 0;

        int partes[] = new int[numero.length()];
        for(int i = 0; i < numero.length(); i++){
            char digitoAtual = numero.charAt(i);
            partes[i] = digitoAtual - '0'; //Para obter o valor real e não o valor Unicode da tabela ASCII subtrai o '0'
            soma += partes[i];
        }
        return soma;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String entrada = sc.nextLine();
            if(entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M'){
                break;
            }
            System.out.println(Somar(entrada));
        }
        sc.close();
    }
}
