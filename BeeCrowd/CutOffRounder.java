import java.util.Scanner;

public class CutOffRounder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String num = sc.nextLine();
            String cutOffRounder = sc.nextLine();

            String partes[] = num.split("\\.");

            double parteInteira;
            double parteDecimal;

            if(partes.length == 1){
                parteInteira = Double.parseDouble(partes[0]);
                parteDecimal = 0.0;
            } else if(partes.length == 2){
                parteInteira = (partes[0].isEmpty()) ? 0.0 : (Double.parseDouble(partes[0]));
                parteDecimal = Double.parseDouble("0." + partes[1]);
            } else {
                continue;
            }

            double cutOff = Double.parseDouble(cutOffRounder);

            int resultado;
            if(parteDecimal > cutOff){
                resultado = (int) parteInteira + 1;
            } else {
                resultado = (int) parteInteira;
            }

            System.out.println(resultado);

        }
        sc.close();
    }
}
