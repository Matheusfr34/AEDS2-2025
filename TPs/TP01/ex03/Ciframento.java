import java.util.Scanner;

public class Ciframento {

    //Método utilizado para cifrar as palavras
    public static String cifrar(String fraseOriginal){
        char[] fraseCifrada = new char[fraseOriginal.length()];

        for(int i = 0; i < fraseOriginal.length(); i++){
            char caracterOriginal = fraseOriginal.charAt(i);

            if(caracterOriginal >= 32 && caracterOriginal <= 126){
                char caracterCifrado = (char) (caracterOriginal + 3);

                fraseCifrada[i] = caracterCifrado;
            } else {
                fraseCifrada[i] = caracterOriginal;
            }
        }

        return new String(fraseCifrada);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String palavra = sc.nextLine();
            if(palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
                break;
            }
            String palavraCifrada = cifrar(palavra);
            System.out.println(palavraCifrada);
        }

        sc.close();
    }
}
