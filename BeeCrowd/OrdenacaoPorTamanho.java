import java.util.Scanner;

public class OrdenacaoPorTamanho {
    public static void ordenarInsercao(String[] valores){
        for(int i = 1; i < valores.length; i++){
            String tmp = valores[i];
            int j = i - 1;
            while(j >= 0 && valores[j].length() < tmp.length()){
                valores[j + 1] = valores[j];
                j--;
            }
            valores[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < quantidade; i++){
            String entrada = sc.nextLine();
            String partes[] = entrada.split(" ");
            
            ordenarInsercao(partes);

            for(String ordenado : partes){
                System.out.print(ordenado + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
