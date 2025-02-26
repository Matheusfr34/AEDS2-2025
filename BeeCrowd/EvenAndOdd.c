#include <stdio.h>

// Ordena em ordem crescente
void ordenarPares(int pares[], int tamanho){
for(int i = 0; i < tamanho - 1; i++){
    int menor = i;
    for(int j = i + 1; j < tamanho; j++){
        if(pares[menor] > pares[j]){
            menor = j;
        }
    }

    int temp = pares[menor];
    pares[menor] = pares[i];
    pares[i] = temp;

    }
}

// Ordena em ordem decrescente
void ordenarImpares(int impares[], int tamanho){
for(int i = 0; i < tamanho - 1; i++){
    int menor = i;
    for(int j = i + 1; j < tamanho; j++){
        if(impares[menor] < impares[j]){
            menor = j;
        }
    }

    int temp = impares[menor];
    impares[menor] = impares[i];
    impares[i] = temp;
    
    }
}

int main(){
    int quantidade;
    scanf("%d", &quantidade);

    int valor[quantidade];
    int pares[100], impares[100];
    int tamPares = 0, tamImpares = 0;

    for (int i = 0; i < quantidade; i++){
        scanf("%d", &valor[i]);
        if (valor[i] % 2 == 0){
            pares[tamPares] = valor[i];
            tamPares++;
        }
        else{
            impares[tamImpares] = valor[i];
            tamImpares++;
        }
    }

    ordenarPares(pares, tamPares);
    ordenarImpares(impares, tamImpares);

    for(int i = 0; i < tamPares; i++){
        printf("%d\n", pares[i]);
    }

    for(int i = 0; i < tamImpares; i++){
        printf("%d\n", impares[i]);
    }

    return 0;
}