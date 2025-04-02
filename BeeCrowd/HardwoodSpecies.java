import java.util.Scanner;
class Arvore {
    String nome;
    int quantidade; 
    public Arvore(String nome){
        this.nome = nome;
        quantidade = 0;
    }
}
public class HardwoodSpecies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        String especie[] = new String[quantidade];

        int contadorEsp = 0;

        Arvore arvore;

        while(contadorEsp < quantidade){

            especie[contadorEsp] = sc.nextLine();
            if(especie[contadorEsp].charAt(0) == ' '){
                contadorEsp++;
            }

            arvore = new Arvore(especie[contadorEsp]);
        }
        sc.close();
    }
}
