import java.util.Scanner;

class Jogadores{
    String nome;
    String foto;
    String data;
    int id;
    String times;

    public Jogadores(String nome, String foto, String data, int id, String times){
        this.nome = nome;
        this.foto = foto;
        this.data = data;
        this.id = id;
        this.times = times;
    }
}

public class JogadoresDeFutebol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        Jogadores jogador[] = new Jogadores[1000];
        int contador = 0;

        while(!entrada.equals("FIM")){
            String[] partes = entrada.split(",");
            String nome = partes[1];
            String foto = partes[2];
            String nascimento = partes[3];
            int id = Integer.parseInt(partes[5]);
            
            int inicio = 0, fim = 0, quant = 1;
            for(int i = 0; i < entrada.length(); i++){
                if(entrada.charAt(i) == '['){
                    inicio = i;
                }
                if(entrada.charAt(i) == ']'){
                    fim = i;
                }
                if(entrada.charAt(i) == ','){
                    quant++;
                }
            }

            StringBuilder str = new StringBuilder();
            for(int i = inicio + 1; i < fim; i++){
                str.append(entrada.charAt(i));
            }

            String timeString = str.toString();

            jogador[contador++] = new Jogadores(nome, foto, nascimento, id, timeString);

            entrada = sc.nextLine();
        }

        for(int i = 0; i < contador; i++){
            System.out.println(jogador[i].id + " " + jogador[i].nome + " " + jogador[i].data + " " + jogador[i].foto + " " + "(" + jogador[i].times + ")");
        }

        sc.close();
    }
}
