import java.util.Scanner;

class Aluno {
    String nome;
    String direcao;
    int distancia;

    Aluno(String nome, String direcao, int distancia) {
        this.nome = nome;
        this.direcao = direcao;
        this.distancia = distancia;
    }
}

public class Van {
    public static int compararAlunos(Aluno a, Aluno b) {
        // Primeiro, comparar pela distância
        int distanciaComp;

        if (a.distancia == b.distancia) {
            distanciaComp = 0;
        } else if (a.distancia > b.distancia) {
            distanciaComp = 1; // Retorna 1, porque a é maior
        } else {
            distanciaComp = -1; // Retorna -1, porque a é menor
        }
        if (distanciaComp != 0) {
            return distanciaComp;
        }

        // Segundo, comparar pela região
        int direcaoComp;
        int direcaoA = (int) a.direcao.charAt(0);
        int direcaoB = (int) b.direcao.charAt(0);

        if (direcaoA == direcaoB) {
            direcaoComp = 0;
        } else if (direcaoA > direcaoB) {
            direcaoComp = 1;
        } else {
            direcaoComp = -1;
        }
        if (direcaoComp != 0) {
            return direcaoComp;
        }

        // Terceiro, comparar pelo nome
        int nomeA = (int) a.nome.charAt(0);
        int nomeB = (int) b.nome.charAt(0);

        return (nomeA > nomeB) ? 1 : -1;
    }

    public static void ordenarAlunos(Aluno[] alunos) {
        for (int i = 1; i < alunos.length; i++) {
            Aluno tmp = alunos[i];
            int j = i - 1;
            while (j >= 0 && compararAlunos(alunos[j], tmp) > 0) {
                alunos[j + 1] = alunos[j];
                j--;
            }
            alunos[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Aluno alunos[] = new Aluno[quantidade];
        String entrada[] = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            if (scanner.hasNextLine()) {
                entrada[i] = scanner.nextLine();
                String partes[] = entrada[i].split(" ");
                String nome = partes[0];
                String direcao = partes[1];
                int distancia = Integer.parseInt(partes[2]);

                alunos[i] = new Aluno(nome, direcao, distancia);

            }
        }

        ordenarAlunos(alunos);

        for (Aluno aluno : alunos) {
            System.out.println(aluno.nome);
        }

        scanner.close();
    }
}
