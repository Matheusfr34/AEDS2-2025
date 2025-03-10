import java.util.Scanner;

public class BibliotecaSeverino {
    public static void ordenar(String[] entrada){
        for(int i = 1; i < entrada.length; i++){
            String tmp = entrada[i];
            int j = i - 1;
            while(j >= 0 && entrada[j].compareTo(tmp) > 0){
                entrada[j + 1] = entrada[j];
                j--;
            }
            entrada[j + 1] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextLine()){
            int quantidade = sc.nextInt();
            sc.nextLine();
            String entrada[] = new String[quantidade];

            for(int i = 0; i < quantidade; i++){
                entrada[i] = sc.nextLine();
            }

            ordenar(entrada);
            
            for(String valores : entrada){
                System.out.println(valores);
            }
        }


        sc.close();
    }
}
