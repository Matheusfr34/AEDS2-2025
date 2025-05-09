#include <stdio.h>
#include <string.h>

typedef struct{
    char nome[500];
    int ouro;
    int prata;
    int bronze;
} Pais;

int compMedalhas(Pais a, Pais b){
    //Critérios de desempate 
    int compOuro;
    if(a.ouro > b.ouro){
        compOuro = -1;
    } else if(a.ouro < b.ouro){
        compOuro = 1;
    } else {
        compOuro = 0;
    }
    if(compOuro != 0){
        return compOuro;
    }

    int compPrata;
    if(a.prata > b.prata){
        compPrata = -1;
    } else if(a.prata < b.prata){
        compPrata = 1;
    } else {
        compPrata = 0;
    }
    if(compPrata != 0){
        return compPrata;
    }

    int compBronze;
    if(a.bronze > b.bronze){
        compBronze = -1;
    } else if(a.bronze < b.bronze){
        compBronze = 1;
    } else {
        compBronze = 0;
    } 
    if(compBronze != 0){
        return compBronze;
    }

    return strcmp(a.nome, b.nome);
}

void ordenarInsercao(Pais pais[], int tamanho){
    for(int i = 1; i < tamanho; i++){
        Pais tmp = pais[i];
        int j = i - 1;
        while(j >= 0 && compMedalhas(pais[j], tmp) > 0){
            pais[j + 1] = pais[j];
            j--;
        }
        pais[j + 1] = tmp;
    }
}

int main(){
    int quantidade;
    scanf("%d", &quantidade);

    Pais pais[quantidade];

    for(int i = 0; i < quantidade; i++){
        scanf("%s %d %d %d", pais[i].nome, &pais[i].ouro, &pais[i].prata, &pais[i].bronze);
    }

    ordenarInsercao(pais, quantidade);

    for(int i = 0; i < quantidade; i++){
        printf("%s %d %d %d\n", pais[i].nome, pais[i].ouro, pais[i].prata, pais[i].bronze);
    }

    return 0;
}

