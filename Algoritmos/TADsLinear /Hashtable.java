//Implementação Hashtable direta com área de reserva (overflow) 

class Tabela {
    private Integer[] tabela;
    private int tamTabela;
    private int tamReserva;
    private int contadorReserva;

    public Tabela() {
        tamTabela = 7;
        tamReserva = 3;
        contadorReserva = 0;
        tabela = new Integer[tamTabela + tamReserva];
    }

    public Tabela(int tamTabela, int tamReserva){
        this.tamTabela = tamTabela;
        this.tamReserva = tamReserva;
        contadorReserva = 0;
        tabela = new Integer[tamTabela + tamReserva];
    }

    private int hash(Integer x) {
        return Math.abs(x % tamTabela);
    }

    public void inserir(int x) {

        int i = hash(x);

        if (tabela[i] == null) {
            tabela[i] = x;
        } else if (contadorReserva < tamReserva) {
            tabela[tamTabela + contadorReserva] = x;
            contadorReserva++;
        } else {
            System.out.println("Área de reserva cheia. Elemento " + x + " não inserido.");
        }
    }

    public void remover(int x) {
        int i = hash(x);
        if (tabela[i] != null && tabela[i].equals(x)) {
            tabela[i] = null;
        } else {
            for (int j = 0; j < contadorReserva; j++) {
                int index = tamTabela + j;
                if (tabela[index] != null && tabela[index].equals(x)) {
                    tabela[index] = null;
                    break;
                }
            }
        }
    }

    public boolean pesquisar(int x) {
        boolean resp = false;
        int i = hash(x);
        if (tabela[i] != null && tabela[i].equals(x)) {
            resp = true;
        } else {
            for (int j = 0; j < contadorReserva; j++) {
                int index = tamTabela + j;
                if (tabela[index] != null && tabela[index].equals(x)) {
                    resp = true;
                    contadorReserva--;
                    break;
                }
            }
        }

        return resp;
    }

    public void mostrar() {
        System.out.println("Tabela principal:");
        for (int i = 0; i < tamTabela; i++) {
            System.out.println(i + ": " + tabela[i]);
        }
        System.out.println("Área de reserva:");
        for (int i = tamTabela; i < tamTabela + tamReserva; i++) {
            System.out.println(i + ": " + tabela[i]);
        }
    }

}

public class Hashtable {
    public static void main(String[] args) {
        Tabela tabela = new Tabela();

        tabela.inserir(5);
        tabela.inserir(7);
        tabela.inserir(14);
        tabela.inserir(21);
        tabela.inserir(19);
        tabela.remover(5);
        tabela.mostrar();
    }
    
}
