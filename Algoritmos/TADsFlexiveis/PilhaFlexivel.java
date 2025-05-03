class Celula{
    int elemento;
    Celula prox;

    //Construtores
    public Celula(){
        this.elemento = 0;
        this.prox = null;
    }
    
    public Celula(int elemento){
        this.elemento = elemento;
        this.prox = null;
    }
}

class Pilha{
    Celula topo; 

    //Contrutores
    public Pilha(){
        topo = null;
    }

    //Método para inserir um elemento (empilhar ou push)
    public void inserir(int x){
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    //Método para remover um elemento (desempilhar ou pop)
    public int remover(){
        if(topo == null){
            throw new RuntimeException("Pilha vazia.");
        }
        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    //Método para mostrar os elementos presentes na pilha
    public void mostrar(){
        System.out.print("[ ");
        for(Celula i = topo; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }

}

public class PilhaFlexivel {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        java.util.Random rand = new java.util.Random();
        
        // 1. Testando pilha vazia
        System.out.println("1. Mostrar pilha vazia:");
        pilha.mostrar();  // Deve mostrar []

        // 2. Criando array aleatório com 5 elementos entre 1 e 100
        int[] array = new int[5];
        System.out.print("\n2. Array aleatório: [ ");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100) + 1; // Números de 1 a 100
            System.out.print(array[i] + " ");
        }
        System.out.println("]");

        // 3. Testando inserir (empilhar)
        System.out.println("\n3. Empilhando elementos:");
        for (int num : array) {
            System.out.println("Inserindo " + num);
            pilha.inserir(num);
            pilha.mostrar();
        }

        // 4. Teste adicional com operações mistas
        System.out.println("\n4. Teste com operações mistas:");
        pilha.inserir(10);
        pilha.inserir(20);
        System.out.print("Pilha após inserir 10 e 20: ");
        pilha.mostrar();
        
        System.out.println("Removido: " + pilha.remover());
        pilha.inserir(30);
        System.out.print("Pilha após remover e inserir 30: ");
        pilha.mostrar();
        
        System.out.println("Removido: " + pilha.remover());
        System.out.println("Removido: " + pilha.remover());
        System.out.print("Pilha final: ");
        pilha.mostrar();
    }
}
