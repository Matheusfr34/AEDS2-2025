//package TPs.TP01.ex12;

import java.util.Scanner;

public class ValidarSenha {

    public static boolean validarSenha(String senha) {
        boolean senhaValida = false;

        int contadorMaiusculas = 0, contadorMinusculas = 0, contadorNumeros = 0, contadorCaracteres = 0;
        if (senha.length() >= 8) {
            for (int i = 0; i < senha.length(); i++) {
                char caracter = senha.charAt(i);
                if (caracter >= 'A' && caracter <= 'Z') {
                    contadorMaiusculas++;
                } else if (caracter >= 'a' && caracter <= 'z') {
                    contadorMinusculas++;
                } else if (caracter >= '0' && caracter <= '9') {
                    contadorNumeros++;
                } else if ((caracter >= 33 && caracter <= 47)
                        || (caracter >= 58 && caracter <= 64)
                        || (caracter >= 91 && caracter <= 96)
                        || (caracter >= 123 && caracter <= 126)) {
                    contadorCaracteres++;
                }
            }
        }

        return (contadorMaiusculas > 0 && contadorMinusculas > 0 && contadorNumeros > 0 && contadorCaracteres > 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String senha = sc.nextLine();
            if (senha.charAt(0) == 'F' && senha.charAt(1) == 'I' && senha.charAt(2) == 'M') {
                break;
            }
            System.out.println(validarSenha(senha) ? "SIM" : "NÃO");
        }

        sc.close();
    }
}
