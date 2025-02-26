//2492 - Ilhas Isoladas (04/02/2025)
/*Se todas as ilhas de origem tiverem ilhas de destino diferentes -> Invertible
 *Se as ilhas de origem tiverem a mesma ilha de destino -> Not invertible
 *Se as mesmas ilhas de origem tiverem a ilha de destino diferente -> Not a function
*/
import java.util.Scanner;
public class IsolatedIslands{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int quantidade;

        while((quantidade = sc.nextInt()) != 0){
            sc.nextLine();
            
            String entrada[] = new String[quantidade];
            String ilhaOrigem[] = new String[quantidade];
            String ilhaDestino[] = new String[quantidade];

            for(int i = 0; i < quantidade; i++){
                entrada[i] = sc.nextLine();
                String partes[] = entrada[i].split(" -> ");
                
                ilhaOrigem[i] = partes[0];
                ilhaDestino[i] = partes[1];

            }

            // Variável de controle para decidir o resultado
            String resultado = "Invertible.";

            for(int i = 0; i < quantidade; i++){
                for(int j = i + 1; j < quantidade; j++){
                    if(ilhaOrigem[i].equals(ilhaOrigem[j]) && !ilhaDestino[i].equals(ilhaDestino[j])){
                        resultado = "Not a function.";
                        break;
                    } else if(!ilhaOrigem[i].equals(ilhaOrigem[j]) && ilhaDestino[i].equals(ilhaDestino[j])){
                        resultado = "Not invertible.";
                        break;
                    }
                }
            }

            System.out.println(resultado);

        }
        sc.close();
    }
}