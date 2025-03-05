
import java.util.Scanner;

public class AtalhosBloggo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String entrada = sc.nextLine();
            StringBuilder str = new StringBuilder();

            boolean abreFechaItalico = true;
            boolean abreFechaNegrito = true;

            for (int i = 0; i < entrada.length(); i++) {

                char caracterAtual = entrada.charAt(i);

                if (caracterAtual == '_') {
                    if (abreFechaItalico) {
                        str.append("<i>");
                    } else {
                        str.append("</i>");
                    }

                    abreFechaItalico = !abreFechaItalico;

                } else if (caracterAtual == '*') {
                    if (abreFechaNegrito) {
                        str.append("<b>");
                    } else {
                        str.append("</b>");
                    }

                    abreFechaNegrito = !abreFechaNegrito;

                } else {
                    str.append(caracterAtual);
                }
            }

            System.out.println(str.toString());

        }
        sc.close();
    }
}
