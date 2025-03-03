import java.util.Scanner;

public class Is {

    //Esse método verifica se uma frase é composta somentes por vogais
    public static boolean somenteVogais(String frase) {
        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            if (caractere != 'A' && caractere != 'a'
                    && caractere != 'E' && caractere != 'e'
                    && caractere != 'I' && caractere != 'i'
                    && caractere != 'O' && caractere != 'o'
                    && caractere != 'U' && caractere != 'u') {
                return false;
            }
        }
        return true;
    }

    //Esse método verifica se uma frase é composta somentes por consoantes
    public static boolean somenteConsoantes(String frase) {
        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            if (caractere == 'A' || caractere == 'a'
                    || caractere == 'E' || caractere == 'e'
                    || caractere == 'I' || caractere == 'i'
                    || caractere == 'O' || caractere == 'o'
                    || caractere == 'U' || caractere == 'u'
                    || caractere >= 'A' || caractere <= 'Z') {
                return false;
            }

            if (!(caractere >= 'A' && caractere <= 'Z') && !(caractere >= 'a' && caractere <= 'z')) {
                return false; 
            }
        }
        return true;
    }

    //Esse método verifica se uma frase é um número inteiro
    public static boolean numeroInteiro(String frase) {
        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            if (caractere != '0' && caractere != '1' && caractere != '2' && caractere != '3' && caractere != '4' && caractere != '5' && caractere != '6' && caractere != '7' && caractere != '8' && caractere != '9') {
                return false;
            }
        }
        return true;
    }

    //Esse método verifica se uma frase é um número real
    public static boolean numeroReal(String frase) {
        boolean simbolo = false;
        int contadorSimbolo = 0;
        for(int i = 0; i < frase.length(); i++){
            char caracter = frase.charAt(i);
            if(caracter == '.' || caracter == ','){
                contadorSimbolo++;
                if(contadorSimbolo > 1){
                    return false;
                }
            }
            else if(caracter < '0' || caracter > '9'){
                return false;
            }
        }
        return contadorSimbolo == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String entrada = sc.nextLine();
            if (entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M') {
                break;
            }
            System.out.print(somenteVogais(entrada) ? "SIM " : "NAO ");
            System.out.print(somenteConsoantes(entrada) ? "SIM " : "NAO ");
            System.out.print(numeroInteiro(entrada) ? "SIM " : "NAO ");
            System.out.print(numeroReal(entrada) ? "SIM " : "NAO");
            System.out.println();
        }
        sc.close();
    }
}
