import java.util.Scanner;

class Brinquedo {
    String nome;
    double peso;
    int quantidade;

    Brinquedo(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }
}

public class Trenos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testes = sc.nextInt();
        int numeroPresentes = sc.nextInt();
        sc.nextLine();

        Brinquedo brinquedos[] = new Brinquedo[50];

            int quantidade;
            double capacidadeTreno = 0.00;
            for (int i = 0; i < testes; i++) {
                for (int j = 0; j < numeroPresentes; j++) {
                    String nome = sc.nextLine();
                    double peso = sc.nextDouble();
                    sc.nextLine();

                    brinquedos[j] = new Brinquedo(nome, peso);
                
                }
            }

            capacidadeTreno = sc.nextDouble();
            sc.nextLine();


            String nomePresentes[] = new String[100];
            int quantidadePresentes[] = new int[100];

            for (int i = 0; ; i++){
                nomePresentes[i] = sc.nextLine();
                quantidadePresentes[i] = sc.nextInt();
                sc.nextLine();
                if(nomePresentes[i].equals("-") && quantidadePresentes[i] == 0){
                    break;
                }
        
                System.out.println(nomePresentes[i] + " " + quantidadePresentes[i]);
            }


            System.out.println(capacidadeTreno);
        
        sc.close();
    }
}
