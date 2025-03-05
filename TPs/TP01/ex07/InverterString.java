import java.util.Scanner;

public class InverterString {

    public static String inverterString(String palavra) {
        int tamanho = palavra.length();
        char caracteresPalavra[] = new char[tamanho];

        for (int i = 0; i < tamanho; i++) {
            caracteresPalavra[i] = palavra.charAt(i);
        }

        for (int i = 0; i < tamanho / 2; i++) {
            char tmp = caracteresPalavra[i];
            caracteresPalavra[i] = caracteresPalavra[tamanho - 1 - i];
            caracteresPalavra[tamanho - 1 - i] = tmp;
        }

        return new String(caracteresPalavra);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String entrada = sc.nextLine();
            if (entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M') {
                break;
            }
            System.out.println(inverterString(entrada));
        }
        sc.close();
    }
}
