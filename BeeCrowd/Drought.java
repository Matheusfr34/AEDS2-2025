import java.util.Scanner;

class Imovel {
    int quantMoradores;
    int quantConsumo;
    int mediaCasa;

    public Imovel(int quantMoradores, int quantConsumo, int mediaCasa) {
        this.quantMoradores = quantMoradores;
        this.quantConsumo = quantConsumo;
        this.mediaCasa = mediaCasa;
    }
}

public class Drought {
    public static void ordenarImoveis(Imovel imovel[]) {
        for (int i = 1; i < imovel.length; i++) {
            Imovel tmp = imovel[i];
            int j = i - 1;
            while (j >= 0 && compararConsumo(imovel[j], tmp) > 0) {
                imovel[j + 1] = imovel[j];
                j--;
            }
            imovel[j + 1] = tmp;
        }
    }

    public static int compararConsumo(Imovel a, Imovel b) {
        if (a.mediaCasa == b.mediaCasa) {
            return 0;
        } else if (a.mediaCasa > b.mediaCasa) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantCasas = sc.nextInt();
        int contador = 1;

        while (quantCasas != 0) {
            sc.nextLine();

            Imovel imovel[] = new Imovel[quantCasas];

            for (int i = 0; i < quantCasas; i++) {
                int quantMoradores = sc.nextInt();
                int quantConsumo = sc.nextInt();
                sc.nextLine();

                int media = quantConsumo / quantMoradores;

                imovel[i] = new Imovel(quantMoradores, quantConsumo, media);
            }

            ordenarImoveis(imovel);

            // Agrupar imóveis com mesma média
            int consumoTotal = 0, moradoresTotal = 0;
            for (Imovel i : imovel) {
                moradoresTotal += i.quantMoradores;
                consumoTotal += i.quantConsumo;
            }
            
            double mediaTotal = (double) consumoTotal / moradoresTotal;
            mediaTotal = Math.floor(mediaTotal * 100) / 100;

            System.out.println("Cidade# " + contador + ":");
            
            // Imprimir os imóveis agrupados
            if (imovel.length > 0) {
                int currentMoradores = imovel[0].quantMoradores;
                int currentMedia = imovel[0].mediaCasa;
                
                for (int i = 1; i < imovel.length; i++) {
                    if (imovel[i].mediaCasa == currentMedia) {
                        currentMoradores += imovel[i].quantMoradores;
                    } else {
                        System.out.print(currentMoradores + "-" + currentMedia + " ");
                        currentMoradores = imovel[i].quantMoradores;
                        currentMedia = imovel[i].mediaCasa;
                    }
                }
                System.out.print(currentMoradores + "-" + currentMedia);
            }
            
            System.out.println();
            System.out.printf("Consumo medio: %.2f m3.\n", mediaTotal);
            System.out.println();

            quantCasas = sc.nextInt();
            contador++;
        }
        sc.close();
    }
}