import java.util.*;

public class AtalhosBloggo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()){
        String frase = sc.nextLine();
        int inicioAtalhos[] = new int[100];
        int fimAtalhos[] = new int[100];
        int quantidadeAtalhos;

        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == '_' || frase.charAt(i) == '*'){
                quantidadeAtalhos++;
                inicioAtalhos = i;
            }
        }
    }

    sc.close();
  }  
}
