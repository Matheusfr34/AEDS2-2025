import java.util.Scanner;

public class Anagrama {

    public static boolean isAnagram(String[] partes) {
        String palavra1 = partes[0];
        String palavra2 = partes[1];
    
        // Se os tamanhos forem diferentes, não podem ser anagramas
        if (palavra1.length() != palavra2.length()) {
            return false;
        }
    
        int[] contagem1 = new int[128];
        int[] contagem2 = new int[128];
    
        // Contar a frequência dos caracteres de cada palavra, considerando maiúsculas e minúsculas
        for (int i = 0; i < palavra1.length(); i++) {
            char c1 = toLowerCase(palavra1.charAt(i));  
            char c2 = toLowerCase(palavra2.charAt(i));  
    
            // Verifica se os caracteres estão dentro do intervalo ASCII válido
            if (c1 >= 0 && c1 < 128) {
                contagem1[c1]++;
            }
            if (c2 >= 0 && c2 < 128) {
                contagem2[c2]++;
            }
        }
    
        // Comparar as frequências de caracteres
        for (int i = 0; i < 128; i++) {
            if (contagem1[i] != contagem2[i]) {
                return false;
            }
        }
    
        return true;
    }

    public static String[] dividir(String frase) {
        int posicao = -1;
    
        // Encontrar a posição exata do " - " (espaço, hífen, espaço)
        for (int i = 0; i < frase.length() - 2; i++) {
            if (frase.charAt(i) == ' ' && frase.charAt(i + 1) == '-' && frase.charAt(i + 2) == ' ') {
                posicao = i;
                break;
            }
        }
    
        char[] caracteresUm = new char[posicao];
        char[] caracteresDois = new char[frase.length() - posicao - 3]; // "- " ocupa 3 caracteres
    
        // Preencher os caracteres das palavras
        for (int j = 0; j < posicao; j++) {
            caracteresUm[j] = frase.charAt(j);
        }
    
        for (int k = 0; k < caracteresDois.length; k++) {
            caracteresDois[k] = frase.charAt(posicao + 3 + k);
        }
    
        String parte1 = new String(caracteresUm);
        String parte2 = new String(caracteresDois);
    
        return new String[]{parte1, parte2};
    }

    //Método para transformar as letras em maiúscula 
    public static char toUpperCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);  // Esse trecho converte para maiúscula
        }
        return c;  // Se não for uma letra minúscula, retorna o mesmo caractere
    }
    
    //Método para transformar as letras em maiúscula
    public static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);  // Esse trecho converte para minúscula
        }
        return c;  // Se não for uma letra maiúscula, retorna o mesmo caractere
    }    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String entrada = sc.nextLine();
            if (entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M') {
                break;
            }
            String[] resultado = dividir(entrada);
            MyIO.println(isAnagram(resultado) ? "SIM" : "NÃO");
        }
        sc.close();
    }
}
