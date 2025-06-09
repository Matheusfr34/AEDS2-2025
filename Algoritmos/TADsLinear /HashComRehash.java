//Implementação Hashtable direta com área de reserva (overflow) 

class Tabela{
    Integer tabela[];

    public Tabela(){
        tabela = new Integer[7];
    }

    public Tabela(int tam){
        this.tabela = new Integer[tam];
    }

    public int hash(int x){
        int tam = tabela.length;
        return x % tam;
    }

    public int rehash(int x){
        int tam = tabela.length;
        return ++x % tam;
    }

    public void inserir(int x){

        int i = hash(x);

        if(tabela[i] == null){
            tabela[i] = x;
        } else {
            i = rehash(x);
            if(tabela[i] == null){
                tabela[i] = x;
            } else {
                System.out.println("Colisão em ambas as posições. Elemento " + x + " não inserido.");
            }
        }

    }

    public void remover(int x){
        int i = hash(x);

        if(tabela[i] != null && tabela[i].equals(x)){
            tabela[i] = null;
        } else {
            i = rehash(x);
            if(tabela[i] != null && tabela[i].equals(x)){
                tabela[i] = null;
            }
        }
    }

    public boolean pesquisar(int x){
        boolean resp = false;
        int i = hash(x);
        if(tabela[i] != null && tabela[i].equals(x)){
            resp = true;
        } else {
            i = rehash(x);
            if(tabela[i] != null && tabela[i].equals(x)){
                resp = true;
            }
        }

        return resp;
    }

    public void mostrar() {
        System.out.println("Tabela principal:");
        for (int i = 0; i < tabela.length; i++) {
            System.out.println(i + ": " + tabela[i]);
        }
    }

}

public class HashComRehash {
    public static void main(String[] args) {
        Tabela tabela = new Tabela();

        tabela.inserir(5);
        tabela.inserir(7);
        tabela.inserir(14);
        tabela.inserir(21);
        tabela.inserir(19);
        tabela.inserir(1);
        tabela.mostrar();
        System.out.println(tabela.pesquisar(5));

    }
}
