/* Elas devem ser ordenadas primeiramente de forma decrescente por peso. Caso duas ou mais apresentarem o mesmo peso 
elas devem ser ordenadas de forma ascendente pela idade, após pela altura e caso ainda persista empate, pelo nome. */

import java.util.*;

class Rena {
    String nome;
    int peso;
    int idade;
    double altura;
    Rena(String nome, int peso, int idade, double altura){
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;
    }
}

public class TheDarkElf {
    public static double compararRenas(Rena a, Rena b){
        //Primeiro, ordenar de forma decrescente pelo peso
        int pesoComp;
        if(a.peso == b.peso){
            pesoComp = 0;
        } else if(a.peso > b.peso){
            pesoComp = -1;
        } else {
            pesoComp = 1;
        } 
        if(pesoComp != 0){
            return pesoComp;
        }

         //Segundo, ordenar de forma crescente pela idade
         int idadeComp;
         if(a.idade == b.idade){
            idadeComp = 0;
         } else if(a.idade > b.idade){
            idadeComp = 1;
         } else {
            idadeComp = -1;
         } 
         if(idadeComp != 0){
            return idadeComp;
         }

         //Terceiro, ordenar de forma crescente pela altura
         double alturaComp;
         if(a.altura == b.altura){
            alturaComp = 0;
         } else if(a.altura > b.altura){
            alturaComp = 1;
         } else {
            alturaComp = -1;
         } 
         if(alturaComp != 0){
            return alturaComp;
         }

          //Quarto, ordenar pelo nome
          int nomeA = (int) a.nome.charAt(0);
          int nomeB = (int) b.nome.charAt(0);

         return (nomeA > nomeB) ? 1 : -1;

    }

    public static void ordenarRenas(Rena renas[]){
        for(int i = 1; i < renas.length; i++){
            Rena tmp = renas[i];
            int j = i - 1;
            while(j >= 0 && compararRenas(renas[j], tmp) > 0){
                renas[j + 1] = renas[j];
                j--;
            }
            renas[j + 1] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testes = sc.nextInt();
        int quantidadeRenas = sc.nextInt();
        int renasUsadas = sc.nextInt();
        sc.nextLine();

        Rena renas[] = new Rena[quantidadeRenas];
        String entrada[] = new String[quantidadeRenas];
        
        for(int i = 0; i < testes; i++){
            for(int j = 0; j < quantidadeRenas; j++){
                entrada[j] = sc.nextLine();
                String partes[] = entrada[j].split(" ");
                String nome = partes[0];
                int peso = Integer.parseInt(partes[1]);
                int idade = Integer.parseInt(partes[2]);
                double altura = Double.parseDouble(partes[3]);
    
                renas[j] = new Rena(nome, peso, idade, altura);
    
            }
        }

        ordenarRenas(renas);
        
        for(int i = 1; i <= testes; i++){
            System.out.println("CENARIO {" + i + "}");
        }
        
        for(int i = 0; i < renasUsadas; i++){
            System.out.println(i + 1 + " - " + renas[i].nome);
        }

        sc.close();
    }
}
