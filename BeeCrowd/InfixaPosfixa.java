import java.util.Scanner;

class Pilha {
    char array[];
    int topo;

    public Pilha(int tam) {
        array = new char[tam];
        topo = -1;
    }

    public void empilhar(char caracter) {
        if (topo >= array.length - 1) {
            throw new IllegalStateException("Array está cheio, não é possível inserir mais elementos.");
        }

        array[++topo] = caracter;
    }

    public char desempilhar() {
        if (topo == -1) {
            throw new IllegalStateException("Array está vazio.");
        }

        return array[topo--];
    }

    public char verTopo() {
        if (topo == -1) {
            return '\0'; // Retorna caractere nulo se a pilha estiver vazia
        }

        return array[topo];
    }
}

public class InfixaPosfixa {

    public static String posfixar(String infixa) {
        Pilha pilha = new Pilha(infixa.length());
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < infixa.length(); i++) {
            char caracterAtual = infixa.charAt(i);

            // Primeiro caso: o caracter é alfanúmerico, ele deve ser adicionado a saída
            if (caracterAtual >= '0' && caracterAtual <= '9' ||
                    caracterAtual >= 'A' && caracterAtual <= 'Z' ||
                    caracterAtual >= 'a' && caracterAtual <= 'z') {
                str.append(caracterAtual);
            }
            
            // Segundo caso: verificar se o caracter é "("
            else if (caracterAtual == '(') {
                pilha.empilhar(caracterAtual);
            }

            // Terceiro caso: verificar se o caracter é ")"
            else if (caracterAtual == ')') {
                while (pilha.verTopo() != '(' && pilha.topo != -1) {
                    str.append(pilha.desempilhar());
                }
                if (pilha.verTopo() == '(') {
                    pilha.desempilhar(); // Remove o '(' da pilha sem adicionar à saída
                }
            }

            // Quarto caso: verificar os operadores e a ordem de precedência
            else if (caracterAtual == '^' || caracterAtual == '*' || caracterAtual == '/' || caracterAtual == '+' || caracterAtual == '-') {
                while (pilha.topo != -1 && pilha.verTopo() != '(' && precedencia(pilha.verTopo()) <= precedencia(caracterAtual)) {
                    str.append(pilha.desempilhar());
                }
                pilha.empilhar(caracterAtual);
            }
        }

        // Adicionar os elementos restantes
        while (pilha.topo != -1) {
            str.append(pilha.desempilhar());
        }

        return str.toString();
    }

    public static int precedencia(char operador) {
        if (operador == '^') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        } else if (operador == '+' || operador == '-') {
            return 3;
        } else {
            return 4; // Para '(' e outros caracteres
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantidade; i++) {
            String entrada = sc.nextLine();
            System.out.println(posfixar(entrada));
        }

        sc.close();
    }
}