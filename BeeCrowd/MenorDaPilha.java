import java.util.Scanner;
class Pilha {
    int[] array;
    int tam;
    Pilha(){
        array = new int[100];
        tam = 0;
    }

    public void inserir(int x){
        if(tam > array.length){
            System.out.println("ERRO");
        } 

        array[tam] = x;
        tam++;
    }

    public int remover(){
        if(tam == 0){
            System.out.println("ERRO");
        }
        return array[--tam];
    }

    public void pesquisar(){
        int menor = array[0];
        for(int i = 0; i < tam; i++){
            if(menor > array[i + 1]){
                menor = array[1 ];
            }
        }
        System.out.println(menor);
    }
}

public class MenorDaPilha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine();

        String consulta[] = new String[quantidade];
        int valor[] = new int[quantidade];

        Pilha pilha = new Pilha();

        for(int i = 0; i < quantidade; i++){
            String linha = sc.nextLine();
            String partes[] = linha.split(" ");
            if(partes[0].equals("PUSH")){
                consulta[i] = partes[0];
                valor[i] = Integer.parseInt(partes[1]);
                pilha.inserir(valor[i]);
            } else{
                consulta[i] = partes[0];
                if(consulta[i].equals("POP")){
                    pilha.remover();
                } else {
                    pilha.pesquisar();
                    }
                }
            }

        sc.close();
    }
}
