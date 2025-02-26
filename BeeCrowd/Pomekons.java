// 2174 - Coleção de Pomekons (05/02/2025)
import java.util.*;

public class Pomekons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantidade = sc.nextInt();

        String pomekons[] = new String[quantidade];
        for(int i = 0; i < quantidade; i++){
            pomekons[i] = sc.next();
        }

        int contador = 0, colecionados = 0;;

        for(int i = 0; i < quantidade; i++){
            boolean unico = true;
            for(int j = 0; j < i; j++){
                if(pomekons[i].equals(pomekons[j])){
                    unico = false;
                    break;
                }
            }
            if(unico){
                contador++;
            }
        }

        colecionados = 151 - contador;

        System.out.print("Falta(m) " + colecionados + " pomekon(s).");

        sc.close();
    }
}
