import java.util.Scanner;
class Duende{
    String nome; 
    int idade;
    public Duende(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
}
public class TimeDeDuendes {
    public static int compararDuendes(Duende a, Duende b){
        int compIdade; 
        if(a.idade == b.idade){
            compIdade = 0;
        } else if(a.idade > b.idade){
            compIdade = -1;
        } else {
            compIdade = 1;
        }
        if(compIdade != 0){
            return compIdade;
        }

        return a.nome.compareTo(b.nome);
    }

    public static void ordenarInsercao(Duende[] duende){
        for(int i = 1; i < duende.length; i++){
            Duende tmp = duende[i];
            int j = i - 1;
            while(j >= 0 && compararDuendes(duende[j], tmp) > 0){
                duende[j + 1] = duende[j];
                j--;
            }
            duende[j + 1] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();

        Duende duendes[] = new Duende[quantidade];

        for(int i = 0; i < quantidade; i++){
            String nome = sc.next();
            int idade = sc.nextInt();

            duendes[i] = new Duende(nome, idade);
        }

        ordenarInsercao(duendes);

        int times = quantidade / 3;
        Duende lider[] = new Duende[times];
        Duende entregador[] = new Duende[times];
        Duende piloto[] = new Duende[times];

        for(int i = 0; i < times; i++){

            System.out.println("Time " + (i + 1));
            System.out.println(duendes[i].nome + " " + duendes[i].idade); // Líder
            System.out.println(duendes[times + i].nome + " " + duendes[times + i].idade); // Entregador
            System.out.println(duendes[2 * times + i].nome + " " + duendes[2 * times + i].idade); // Piloto
            System.out.println(); // Linha em branco após cada time

        }
        sc.close();
    }
}
