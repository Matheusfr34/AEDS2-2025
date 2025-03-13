import java.util.Scanner;

public class DiamondsAndSand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testes = sc.nextInt();
        sc.nextLine();
    
        for(int i = 0; i < testes; i++){
            int contadorMaior = 0;
            int  contadorMenor = 0;
            String entrada = sc.nextLine();

            for(int j = 0; j < entrada.length(); j++){
                if (entrada.charAt(j) == '<'){
                    contadorMenor++;
                } else if((entrada.charAt(j) == '>')){
                    contadorMaior++;
                }
            }
            
            int maior, menor;
            maior = contadorMaior > contadorMenor ? contadorMaior : contadorMenor;
            menor = contadorMenor < contadorMaior ? contadorMenor : contadorMaior;
            if(maior != 0 && menor != 0){
                System.out.println(menor);
            } else {
                System.out.println(0);
            }
        }

        sc.close();
    }
}
