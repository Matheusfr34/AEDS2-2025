//Questão prova prática 2 - Classe Jogadores

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Date {
    String dia;
    String mes;
    String ano;
}

class Jogadores {
    public String nome;
    public String foto;
    public Date nascimento;
    public int id;
    public int[] times;

    public void imprimir() {
        System.out.print(this.id + " " + this.nome + " " + this.nascimento.dia + "/" +
                this.nascimento.mes + "/" + this.nascimento.ano + " " + this.foto + " " + "(");
        for (int i = 0; i < times.length - 1; i++) {
            System.out.print(times[i] + ", ");
        }
        System.out.println(times[times.length - 1] + ")");
    }

    public void ler(String input) {
        int i = 0;
        String index = separar(input, i, ',');
        i += index.length() + 1;
        this.nome = separar(input, i, ',');
        i += nome.length() + 1;
        this.foto = separar(input, i, ',');
        i += foto.length() + 1;
        this.nascimento = new Date();
        this.nascimento.dia = separar(input, i, '/');
        i += nascimento.dia.length() + 1;
        this.nascimento.mes = separar(input, i, '/');
        i += nascimento.mes.length() + 1;
        this.nascimento.ano = separar(input, i, ',');
        i += nascimento.ano.length() + 1;
        index = separar(input, i, ',');
        i += index.length() + 1;
        String idString = separar(input, i, ',');
        this.id = Integer.parseInt(idString);
        i += idString.length() + 1;
        int n = contarTimes(input, i);
        if (input.charAt(i) == '"') i += 2;
        else i++;
        this.times = new int[n];
        for (int j = 0; j < n - 1; j++) {
            String timeString = separar(input, i, ',');
            this.times[j] = Integer.parseInt(timeString);
            i += timeString.length() + 2;
        }
        String timeString = separar(input, i, ']');
        this.times[n - 1] = Integer.parseInt(timeString);
    }

    public String separar(String input, int i, char delimiter) {
        String stringer = "";
        while (i < input.length() && input.charAt(i) != delimiter) {
            stringer += input.charAt(i);
            i++;
        }
        return stringer;
    }

    public int contarTimes(String input, int i) {
        int times = 1;
        while (i < input.length() && input.charAt(i) != ']') {
            if (input.charAt(i) == ',') {
                times++;
            }
            i++;
        }
        return times;
    }
}

public class PesquisaBinaria {
    public static void main(String[] args) {
        List<Jogadores> jogadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Ler jogadores até encontrar "FIM"
        while (true) {
            String linha = scanner.nextLine();
            if (linha.equals("FIM")) {
                break;
            }
            Jogadores jogador = new Jogadores();
            jogador.ler(linha);
            jogadores.add(jogador);
        }

        // Ler nomes para busca até encontrar "FIM"
        while (true) {
            String nome = scanner.nextLine();
            if (nome.equals("FIM")) {
                break;
            }
            boolean encontrado = buscaBinaria(jogadores, nome);
            System.out.println(encontrado ? "SIM" : "NAO");
        }
    }

    public static boolean buscaBinaria(List<Jogadores> jogadores, String nome) {
        int esquerda = 0;
        int direita = jogadores.size() - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            int comparacao = jogadores.get(meio).nome.compareTo(nome);

            if (comparacao == 0) {
                return true;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return false;
    }
}