//package TPs.TP01.ex03;

import java.util.Scanner;

public class CiframentoRecursivo {

    public static void cifrarRecursivo(char[] fraseCifrada, String fraseOriginal, int i, int tamanho) {
        if (i == tamanho) {
            return; // Caso base: atingimos o final da string
        }

        char caracterOriginal = fraseOriginal.charAt(i);

        // Verifica se está dentro da faixa de caracteres imprimíveis e aplica a cifra
        if (caracterOriginal >= 32 && caracterOriginal <= 126) {
            fraseCifrada[i] = (char) (caracterOriginal + 3);
        } else {
            fraseCifrada[i] = caracterOriginal;
        }

        // Chamada recursiva para o próximo caractere
        cifrarRecursivo(fraseCifrada, fraseOriginal, i + 1, tamanho);
    }

    // Método principal que inicia a cifra
    public static String cifrar(String fraseOriginal) {
        int tamanho = fraseOriginal.length();
        char[] fraseCifrada = new char[tamanho];

        cifrarRecursivo(fraseCifrada, fraseOriginal, 0, tamanho);

        return new String(fraseCifrada);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String palavra = sc.nextLine();
            if (palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M') {
                break;
            }
            String palavraCifrada = cifrar(palavra);
            System.out.println(palavraCifrada);
        }

        sc.close();
    }
}
