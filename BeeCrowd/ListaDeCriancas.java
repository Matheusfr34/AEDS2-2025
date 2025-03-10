import java.util.Scanner;

public class ListaDeCriancas {
    public static void ordenarCriancas(String[] criancas){
        for(int i = 1; i < criancas.length; i++){
            String tmp = criancas[i];
            int j = i - 1;
            while(j >= 0 && criancas[j].compareTo(tmp) > 0){
                criancas[j + 1] = criancas[j];
                j--;
            }
            criancas[j + 1] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine();

        String entrada[] = new String[quantidade];

        for(int i = 0; i < quantidade; i++){
            entrada[i] = sc.nextLine();
        }

        String crianca[] = new String[quantidade];
        int comportadas = 0, naoComportadas = 0;

        for(int j = 0; j < quantidade; j++){
            String partes[] = entrada[j].split(" ");
            if(partes[0].charAt(0) == '+'){
                comportadas++;
                crianca[j] = partes[1];
            } else if(partes[0].charAt(0) == '-'){
                naoComportadas++;
                crianca[j] = partes[1];
            }
        }

        ordenarCriancas(crianca);

        for(String criancas : crianca){
            System.out.println(criancas);
        }
        System.out.print("Se comportaram: " + comportadas + " | Nao se comportaram: " + naoComportadas);

        sc.close();
    }
}
