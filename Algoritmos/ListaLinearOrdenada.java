class ListaOrdenada {
    int[] array;
    int n;
    public ListaOrdenada(int tam){
        array = new int[tam];
        n = 0;
    }
    
    public void inserirOrdenado(int x){
        for(int i = 1; i < n; i++){
            int tmp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > tmp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
}

public class ListaLinearOrdenada {
    public static void main(String[] args) {
        
    }
}
