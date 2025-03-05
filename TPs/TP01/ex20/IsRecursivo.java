
import java.util.Scanner;

public class IsRecursivo {

    //Esse método verifica se uma frase é composta somentes por vogais de forma recurvisa
    public static boolean somenteVogaisRecursivo(String frase, int i, int tamanho) {
        if (i == tamanho) {
            return true;
        }

        char caractere = frase.charAt(i);

        if (caractere != 'A' && caractere != 'a'
                && caractere != 'E' && caractere != 'e'
                && caractere != 'I' && caractere != 'i'
                && caractere != 'O' && caractere != 'o'
                && caractere != 'U' && caractere != 'u') {
            return false;
        }

        return somenteVogaisRecursivo(frase, i + 1, tamanho);
    }

    //Esse método verifica se uma frase é composta somentes por vogais chamando o método somenteVogaisRecursivo
    public static boolean somenteVogais(String frase) {
        int tamanho = frase.length();
        return somenteVogaisRecursivo(frase, 0, tamanho);
    }

    //Método recursivo que verificar se uma palavra é composta somente por consoantes 
    public static boolean somenteConsoantesRecursivo(String frase, int i, int tamanho) {
        if (i == tamanho) {
            return true;
        }

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

        return somenteConsoantesRecursivo(frase, i + 1, tamanho);
    }

    //Esse método verifica se uma frase é composta somentes por consoantes
    public static boolean somenteConsoantes(String frase) {
        int tamanho = frase.length();
        return somenteConsoantesRecursivo(frase, 0, tamanho);
    }

    //Método recursivo para verificar se a entrada é composta somente por números inteiros
    public static boolean numeroInteirosRecursivo(String frase, int i, int tamanho) {
        if (i == tamanho) {
            return true;
        }
        char caractere = frase.charAt(i);
        if (caractere != '0' && caractere != '1' && caractere != '2' && caractere != '3' && caractere != '4' && caractere != '5' && caractere != '6' && caractere != '7' && caractere != '8' && caractere != '9') {
            return false;
        }
        return numeroInteirosRecursivo(frase, i + 1, tamanho);
    }

    //Esse método verifica se uma frase é um número inteiro chamando o método numeroInteirosRecursivo
    public static boolean numeroInteiro(String frase) {
        int tamanho = frase.length();
        return numeroInteirosRecursivo(frase, 0, tamanho);
    }

    //Método recursivo para verificar se a frase é um número real
    public static boolean numeroRealRecursivo(String frase, int i, int tamanho) {
        int contadorSimbolo = 0;
        if (i == tamanho) {
            return contadorSimbolo == 1;
        }
        char caracter = frase.charAt(i);
        if (caracter == '.' || caracter == ',') {
            contadorSimbolo++;
            if (contadorSimbolo > 1) {
                return false;
            }
        } else if (caracter < '0' || caracter > '9') {
            return false;
        }
        return numeroRealRecursivo(frase, i + 1, tamanho);
    }

    //Esse método verifica se uma frase é um número real chamando o método recursivo numeroRealRecursivo
    public static boolean numeroReal(String frase) {
        int tamanho = frase.length();
        return numeroRealRecursivo(frase, 0, tamanho);
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
