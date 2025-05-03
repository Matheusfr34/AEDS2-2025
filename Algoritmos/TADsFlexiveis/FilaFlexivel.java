class Celula {
    int elemento;
    Celula prox;

    public Celula(){
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int elemento){
        this.elemento = elemento;
        this.prox = null;
    }
}

class Fila{
    Celula primeiro, ultimo;

    public Fila(){
        primeiro = ultimo = new Celula();
    }

    public void inserir(int x){
        Celula tmp = new Celula(x);
        if(primeiro == ultimo){
            primeiro.prox = tmp;
            ultimo = tmp;
            tmp = null;
        } else {
            ultimo.prox = tmp;
            ultimo = tmp;
            tmp = null;
        }
    }

    public int remover(){

        if(primeiro == ultimo){
            throw new RuntimeException("Fila vazia.");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        
        return elemento;
    }

    public void mostrar(){
        System.out.print("[ ");
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }

}

public class FilaFlexivel {
    public static void main(String[] args) {
        Fila fila = new Fila();
        java.util.Random rand = new java.util.Random();
        
        // 1. Testando fila vazia
        System.out.println("1. Testando fila vazia:");
        try {
            fila.remover();
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // 2. Criando array aleatório com 5 elementos entre 1 e 100
        int[] array = new int[5];
        System.out.print("\n2. Array aleatório: [ ");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100) + 1; // Números de 1 a 100
            System.out.print(array[i] + " ");
        }
        System.out.println("]");

        // 3. Testando inserir
        System.out.println("\n3. Inserindo elementos na fila:");
        for (int num : array) {
            System.out.println("Inserindo " + num);
            fila.inserir(num);
            fila.mostrar();
        }

        // 4. Testando remover
        System.out.println("\n4. Removendo elementos da fila:");
        while (true) {
            try {
                int elemento = fila.remover();
                System.out.println("Removido: " + elemento);
                System.out.print("Fila atual: ");
                fila.mostrar();
            } catch (RuntimeException e) {
                System.out.println("Fila vazia - fim dos testes");
                break;
            }
        }

        // 5. Teste adicional com operações mistas
        System.out.println("\n5. Teste com operações mistas:");
        fila.inserir(10);
        fila.inserir(20);
        System.out.print("Fila após inserir 10 e 20: ");
        fila.mostrar();
        
        System.out.println("Removido: " + fila.remover());
        fila.inserir(30);
        System.out.print("Fila após remover e inserir 30: ");
        fila.mostrar();
        
        System.out.println("Removido: " + fila.remover());
        System.out.println("Removido: " + fila.remover());
        System.out.print("Fila final: ");
        fila.mostrar();
    }
}
