#include <stdio.h>
#include <string.h>

typedef struct{
    int inicio;
    int fim;
} Sorveteiro;

int compDistancia(Sorveteiro a, Sorveteiro b){
    if(a.inicio > b.inicio){
        return 1;
    } else if(a.inicio < b.inicio){
        return -1;
    } else {
        return 0;
    }
}

void ordenarSorveteiro(Sorveteiro sorveteiro[], int tam){
    for(int i = 1; i < tam; i++){
        Sorveteiro tmp = sorveteiro[i];
        int j = i - 1;
        while(j >= 0 && compDistancia(sorveteiro[j], tmp) > 0){
            sorveteiro[j + 1] = sorveteiro[j];
            j--;
        }
        sorveteiro[j + 1] = tmp;
    }
}

int main(){
    int contador = 0;

    int tamanho, quantSorveteiros;
    scanf("%d %d", &tamanho, &quantSorveteiros);

    while(tamanho != 0 && quantSorveteiros != 0){

        Sorveteiro sorveteiro[5000];

        for(int i = 0; i < quantSorveteiros; i++){
            scanf("%d %d\n", &sorveteiro[i].inicio, &sorveteiro[i].fim);
        }
        
        ordenarSorveteiro(sorveteiro, quantSorveteiros);

        int inicioAtual = sorveteiro[0].inicio;
        int fimAtual = sorveteiro[0].fim;

        printf("Teste %d\n", (contador + 1));
        
        for(int i = 1; i < quantSorveteiros; i++){
            if(sorveteiro[i].inicio <= fimAtual){
                if(sorveteiro[i].fim > fimAtual){
                    fimAtual = sorveteiro[i].fim;
                }
            } else {
                printf("%d %d\n", inicioAtual, fimAtual);
                inicioAtual = sorveteiro[i].inicio;
                fimAtual = sorveteiro[i].fim;
            }
        }

        printf("%d %d\n", inicioAtual, fimAtual);
        printf("\n");

        scanf("%d %d", &tamanho, &quantSorveteiros);
        contador++;

    }

    return 0;
}