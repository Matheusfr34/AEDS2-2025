import java.util.Scanner;

public class DiamondsAndSand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testes = sc.nextInt();
        sc.nextLine();
    
        for(int i = 0; i < testes; i++){
            int contador = 0;
            int abrirChaves = 0;
            String entrada = sc.nextLine();

            for(int j = 0; j < entrada.length(); j++){
                 if (entrada.charAt(j) == '<'){
                    abrirChaves++;
                }else if((entrada.charAt(j) == '>' && abrirChaves > 0)){
                    contador++;
                    abrirChaves--;
                }
            }
            
            if(contador > 0){
                System.out.println(contador);
            } else {
                System.out.println(0);
            }
        }

        sc.close();
    }
}
