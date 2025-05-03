
class Celula {

    int elemento;
    Celula prox;

    //Construtores
    public Celula() {
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class Lista {

    Celula primeiro, ultimo;

    public Lista() {
        primeiro = ultimo = new Celula();
    }

    public int tamanho() {
        int contador = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            contador++;
        }

        return contador;
    }

    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirPos(int x, int pos) {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            System.out.println("Erro. Posição inválida.");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            Celula tmp = new Celula(x);
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            tmp.prox = i.prox;
            i.prox = tmp;
            i = tmp = null;
        }
    }

    public int removerFim() {
        if (primeiro == ultimo) {
            System.out.println("Erro. Lista vazia");
        }
        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox);
        int elemento = ultimo.elemento;
        ultimo = i;
        ultimo.prox = null;
        i = null;

        return elemento;
    }

    public int removerInicio() {
        if (primeiro == ultimo) {
            System.out.println("Erro. Lista vazia.");
        }
        Celula tmp = primeiro.prox;
        int elemento = tmp.elemento;
        primeiro.prox = tmp.prox;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    public int removerPos(int pos) {
        int elemento = 0, tamanho = tamanho();
        if (pos < 0 || pos >= tamanho || primeiro == ultimo) {
            System.out.println("Erro.");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == tamanho - 1) {
            elemento = removerFim();
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            tmp = i = null;
        }
        return elemento;
    }

    public void mostrar() {
        System.out.print("VETOR: [ ");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");

    }

    /* ------ EXERCICIOS LISTA SIMPLES ------ */
    
    //Exercício 1 - Implemente um método que remove a segunda posição válida
    public int remover() {
        int tamanho = tamanho();
        if (primeiro == ultimo || tamanho < 2) {
            System.out.println("Erro.");
            return -1;
        }
        Celula i = primeiro.prox;
        Celula tmp = i.prox;
        int elemento = tmp.elemento;
        i.prox = tmp.prox;
        tmp.prox = null;

        if (tmp == ultimo) {
            ultimo = i;
        }

        i = tmp = null;

        return elemento;
    }

    //Exercício 2 - Implemente um método que retorne a soma dos elementos contidos na mesma 
    public int somar() {
        if (primeiro == ultimo) {
            System.out.println("Lista vazia");
            return 0;
        }
        int soma = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            soma += i.elemento;
        }

        return soma;
    }

    //Exercício 3 - Implemente um método que retorna o maior elemento contido na mesma 
    public int maiorElemento() {
        if (primeiro == ultimo) {
            throw new RuntimeException("Lista vazia - não existe maior elemento");
        }
        int maior = primeiro.prox.elemento;
        for (Celula i = primeiro.prox.prox; i != null; i = i.prox) {
            maior = i.elemento > maior ? i.elemento : maior;
        }

        return maior;
    }

    //Exercício 4 - Implemente um método que retorna o terceiro elemento supondo que o mesmo existe
    public int terceiroElemento() {
        int tamanho = tamanho();
        if (primeiro == ultimo || tamanho < 3) {
            throw new RuntimeException("Lista vazia ou menor que 3.");
        }
        Celula i = primeiro.prox.prox.prox;
        int elemento = i.elemento;

        return elemento;
    }

    //Exercício 5 - Implemente um método que inverte a ordem dos seus elementos
    public void inverter() {

        Celula anterior = null;
        Celula atual = primeiro.prox;
        Celula proximo = null;

        while (atual != null) {
            proximo = atual.prox;
            atual.prox = anterior;
            anterior = atual;
            atual = proximo;
        }

        // Atualizar o primeiro e o último após a inversão
        ultimo = primeiro.prox;
        primeiro.prox = anterior;
    }

    //Exercício 6 - Implemente um método que retorna o número de elementos pares and múltiplis de cinco contidos na mesma
    public int paresAndMultiplos() {
        int contador = 0;

        if (primeiro == ultimo) {
            throw new RuntimeException("Lista vazia.");
        }

        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento % 2 == 0 && i.elemento % 5 == 0) {
                contador++;
            }
        }

        return contador;
    }

    //Exercício 10 - Modifique nossa lista flexível, criando uma lista ordenada.
    public void inserirOrdenado(int x) {
        Celula tmp = new Celula(x);
        if (primeiro == ultimo) {
            primeiro.prox = tmp;
            ultimo = tmp;
            tmp = null;
        } else {
            Celula i;
            int pos;
            for (i = primeiro.prox, pos = 0; i != null && i.elemento < x; i = i.prox, pos++);
            Celula j = primeiro;
            for(int k = 0; k < pos; k++, j = j.prox);
            tmp.prox = j.prox;
            j.prox = tmp;
            tmp = j = null;
        }
    }

}

public class ListaFlexivel {
    public static void main(String[] args) {
        Lista lista = new Lista();
        java.util.Random rand = new java.util.Random();
        
        // Criando array aleatório com 10 elementos entre 0 e 50
        int[] array = new int[10];
        System.out.print("Array original: [ ");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(51); // Números de 0 a 50
            System.out.print(array[i] + " ");
        }
        System.out.println("]");

        // 1. Testando inserirFim()
        System.out.println("\n1. Inserindo elementos no fim:");
        for (int num : array) {
            lista.inserirFim(num);
        }
        lista.mostrar();

        // 2. Testando tamanho()
        System.out.println("\n2. Tamanho da lista: " + lista.tamanho());

        // 3. Testando inserirInicio()
        System.out.println("\n3. Inserindo 100 no início:");
        lista.inserirInicio(100);
        lista.mostrar();

        // 4. Testando inserirPos()
        System.out.println("\n4. Inserindo 200 na posição 5:");
        lista.inserirPos(200, 5);
        lista.mostrar();

        // 5. Testando removerInicio()
        System.out.println("\n5. Removendo início: " + lista.removerInicio());
        lista.mostrar();

        // 6. Testando removerFim()
        System.out.println("\n6. Removendo fim: " + lista.removerFim());
        lista.mostrar();

        // 7. Testando removerPos()
        System.out.println("\n7. Removendo posição 3: " + lista.removerPos(3));
        lista.mostrar();

        // 8. Testando remover() (segundo elemento)
        System.out.println("\n8. Removendo segundo elemento: " + lista.remover());
        lista.mostrar();

        // 9. Testando somar()
        System.out.println("\n9. Soma dos elementos: " + lista.somar());

        // 10. Testando maiorElemento()
        System.out.println("\n10. Maior elemento: " + lista.maiorElemento());

        // 11. Testando terceiroElemento()
        try {
            System.out.println("\n11. Terceiro elemento: " + lista.terceiroElemento());
        } catch (RuntimeException e) {
            System.out.println("\n11. " + e.getMessage());
        }

        // 12. Testando paresAndMultiplos()
        try {
            System.out.println("\n12. Pares e múltiplos de 5: " + lista.paresAndMultiplos());
        } catch (RuntimeException e) {
            System.out.println("\n12. " + e.getMessage());
        }

        // 13. Testando inserirOrdenado()
        System.out.println("\n13. Inserindo 15 ordenadamente:");
        lista.inserirOrdenado(15);
        lista.mostrar();

        // 14. Testando inverter()
        System.out.println("\n14. Invertendo lista:");
        lista.inverter();
        lista.mostrar();

        // 15. Testando todos os métodos após inversão
        System.out.println("\n15. Testes pós-inversão:");
        System.out.println("- Tamanho: " + lista.tamanho());
        System.out.println("- Soma: " + lista.somar());
        System.out.println("- Maior: " + lista.maiorElemento());
        try {
            System.out.println("- Terceiro: " + lista.terceiroElemento());
            System.out.println("- Pares e múltiplos de 5: " + lista.paresAndMultiplos());
        } catch (RuntimeException e) {
            System.out.println("- " + e.getMessage());
        }
    }
}