import java.util.Scanner;

/*
 * Essa versão deu Time limit exceeded no BeeCrowd
 */

public class CutOffRounder1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            double numero = sc.nextDouble();
            double corte = sc.nextDouble();

            String num = String.format("%.8f", numero);
            String cutOff = String.format("%.4f", corte);


            String[] partesNum = num.split("\\.");
            String[] partesCutOff = cutOff.split("\\.");

            int parteDecimal = Integer.parseInt(partesNum[0]);
            int parteFracionaria = Integer.parseInt(partesNum[1]);
            int cutOffFracionario = Integer.parseInt(partesCutOff[1]);
            

            if(parteFracionaria > cutOffFracionario){
                parteDecimal++;
            }

            System.out.println(parteDecimal);
        }
        sc.close();
    }
}
