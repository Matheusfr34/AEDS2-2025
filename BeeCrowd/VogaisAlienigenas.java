// 2150 - Vogais Alienígenas (05/02/2025)

import java.util.*;

public class VogaisAlienigenas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String vogais = sc.nextLine();
            if (!sc.hasNextLine()){
                break; 
            } // Verifica se há uma próxima linha antes de ler
            String frase = sc.nextLine();

            int tamVogais = vogais.length();
            int tamFrase = frase.length();

            int contador = 0;
            for(int i = 0; i < tamVogais; i++){
                for(int j = 0; j < tamFrase; j++){
                    if (vogais.charAt(i) == frase.charAt(j)){
                        contador++;
                    }
                }
            }

            System.out.println(contador);

        }
        sc.close();
    }
}
