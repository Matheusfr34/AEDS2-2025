import java.util.Scanner;
class Medalhas {
    String nome;
    int ouro;
    int prata;
    int bronze;
    public Medalhas(String nome, int ouro, int prata, int bronze){
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
}
public class QuadroDeMedalhas {
    //Método para comparar as medalhas
    public static int compararMedalhas(Medalhas a, Medalhas b){
        //Condição para verificar a quantidade de ouro
        int compOuro;
        if(a.ouro == b.ouro){
            compOuro = 0;
        } else if(a.ouro > b.ouro){
            compOuro = -1; //Porque a distancia a é maior
        } else {
            compOuro = 1; //Porque a distancia b é menor 
        }
        if(compOuro != 0){
            return compOuro;
        }

        int compPrata;
        if(a.prata == b.prata){
            compPrata = 0;
        } else if(a.prata > b.prata){
            compPrata = -1;
        } else {
            compPrata = 1;
        }
        if(compPrata != 0){
            return compPrata;
        }

        int compBronze;
        if(a.bronze == b.bronze){
            compBronze = 0;
        } else if(a.bronze > b.bronze){
            compBronze = -1;
        } else {
            compBronze = 1;
        }
        if(compBronze != 0){
            return compBronze;
        }

        return a.nome.compareTo(b.nome);
    }

    public static void ordenarInsercao(Medalhas[] pais){
        for(int i = 1; i < pais.length; i++){
            Medalhas tmp = pais[i];
            int j = i - 1;
            while(j >= 0 && compararMedalhas(pais[j], tmp) > 0){
                pais[j + 1] = pais[j];
                j--;
            }
            pais[j + 1] = tmp;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine(); //Consumir quebra de linha

        Medalhas pais[] = new Medalhas[quantidade];

        for(int i = 0; i < quantidade; i++){
            String nome = sc.next();
            int ouro = sc.nextInt();
            int prata = sc.nextInt();
            int bronze = sc.nextInt();

            pais[i] = new Medalhas(nome, ouro, prata, bronze);
        }

        ordenarInsercao(pais);

        for(Medalhas ordenado : pais){
            System.out.println(ordenado.nome + " " + ordenado.ouro + " " + ordenado.prata + " " + ordenado.bronze);
        }

        sc.close();
    }
}
