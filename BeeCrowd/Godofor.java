
import java.util.Scanner;

class Deus {

    String nome;
    int poder;
    int quantidadeDePessoas;
    int morte;

    Deus(String nome, int poder, int quantidadeDePessoas, int morte) {
        this.nome = nome;
        this.poder = poder;
        this.quantidadeDePessoas = quantidadeDePessoas;
        this.morte = morte;
    }
}

public class Godofor {

    public static void ordenarGodofor(Deus[] godofor) {
        for(int i = 1; i < godofor.length; i++){
            Deus tmp = godofor[i];
            int j = i - 1;
            while(j >= 0 && compararPoder(godofor[j], tmp) > 0){
                godofor[j + 1] = godofor[j];
                j--;
            }
            godofor[j + 1] = tmp;
        }
    }

    public static int compararPoder(Deus a, Deus b) {
        //Primeiro critério é comparar pelo poder
        int compPoder;
        if (a.poder == b.poder) {
            compPoder = 0;
        } else if (a.poder > b.poder) {
            compPoder = -1;
        } else {
            compPoder = 1;
        }
        if (compPoder != 0) {
            return compPoder;
        }

        //Segundo critério é comparar por quem mais matou
        int quantidadeDePessoas;
        if (a.quantidadeDePessoas == b.quantidadeDePessoas) {
            quantidadeDePessoas = 0;
        } else if (a.quantidadeDePessoas > b.quantidadeDePessoas) {
            quantidadeDePessoas = -1;
        } else {
            quantidadeDePessoas = 1;
        }
        if (quantidadeDePessoas != 0) {
            return quantidadeDePessoas;
        }

        //Terceiro critério é pela quantidade de vezes que morreu
        int compMorte;
        if (a.morte == b.morte) {
            compMorte = 0;
        } else if (a.morte > b.morte) {
            compMorte = -1;
        } else {
            compMorte = 1;
        }
        if (compMorte != 0) {
            return compMorte;
        }

        return a.nome.compareTo(b.nome);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine();

        Deus godofor[] = new Deus[quantidade];


        for (int i = 0; i < quantidade; i++) {
            String entrada = sc.nextLine();
            String partes[] = entrada.split(" ");

            String nome = partes[0]; //partes[0] guarda o nome
            int poder = Integer.parseInt(partes[1]); //partes[1] guarda o poder 
            int quantidadeDePessoas = Integer.parseInt(partes[2]); //partes[2] guarda a quantidade de Deuses que ele matou
            int morte = Integer.parseInt(partes[3]); //partes[3] guarda a quantidade de vezes que ele morreu

            godofor[i] = new Deus(nome, poder, quantidadeDePessoas, morte);
        }

        ordenarGodofor(godofor);

        System.out.println(godofor[0].nome);

        sc.close();
    }
}
