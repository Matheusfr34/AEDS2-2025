import java.util.Scanner;

public class Lanternas {
    public static void ordenarQuicksort(int[] array, int esq, int dir){
        int i = esq, j = dir, pivo = array[(esq + dir)/2];
        while(i <= j){
            while(array[i] < pivo){
                i++;
            }
            while(array[j] > pivo){
                j--;
            }
            if(i <= j){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        if(esq < j){
            ordenarQuicksort(array, esq, j);
        }
        if(i < dir){
            ordenarQuicksort(array, i, dir);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int length = sc.nextInt();

        int distancia[] = new int[number];

        for(int i = 0; i < number; i++){
            distancia[i] = sc.nextInt();
        }

        ordenarQuicksort(distancia, 0, number - 1);

        int maiorDistancia = 0;
        for(int i = 0; i < number - 1; i++){
            int distanciaAtual  = distancia[i + 1] - distancia[i];
            maiorDistancia = maiorDistancia > distanciaAtual ? maiorDistancia : distanciaAtual;
        }

        System.out.println(maiorDistancia);
        float raio = (float) maiorDistancia /2;

        System.out.printf("%.10f", raio);
        sc.close();
    }
}
