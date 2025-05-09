#include <stdio.h> 
#include <string.h> 

typedef struct{
    char nome[100];
    int poder;
    int morteMatada;
    int morteMorrida;
} Godofor;

int compGodofor(Godofor a, Godofor b){
    //Ordenar pelo poder (Descendente)
    int compPoder;
    if(a.poder > b.poder){
        compPoder = -1;
    } else if(a.poder < b.poder){
        compPoder = 1;
    } else {
        compPoder = 0;
    }
    if(compPoder != 0){
        return compPoder;
    }

    //Ordenar pelo quantidade de pessoas que matou (Descendente)
    int compMorteMatada;
    if(a.morteMatada > b.morteMatada){
        compMorteMatada = -1;
    } else if(a.morteMatada < b.morteMatada){
        compMorteMatada = 1;
    } else {
        compMorteMatada = 0;
    }
    if(compMorteMatada != 0){
        return compMorteMatada;
    }

    //Ordenar pela quantidade de vezes que morreu (Crescente)
    int compMorteMorrida;
    if(a.morteMorrida > b.morteMorrida){
        compMorteMorrida = 1;
    } else if(a.morteMorrida < b.morteMorrida){
        compMorteMorrida = -1;
    } else {
        compMorteMorrida = 0;
    }
    if(compMorteMorrida != 0){
        return compMorteMorrida;
    }

    //Ordenar pelo nome em ordem alfabética
    return strcmp(a.nome, b.nome);
}

void ordenarGodofor(Godofor godofor[], int tam){
    for(int i = 1; i < tam; i++){
        Godofor tmp = godofor[i];
        int j = i - 1;
        while(j >= 0 && compGodofor(godofor[j], tmp) > 0){
            godofor[j + 1] = godofor[j];
            j--;
        }
        godofor[j + 1] = tmp;
    }
}

int main(){
    int quantidade;
    scanf("%d", &quantidade);

    Godofor godofor[quantidade];

    for(int i = 0; i < quantidade; i++){
        scanf("%s %d %d %d", godofor[i].nome, &godofor[i].poder, &godofor[i].morteMatada, &godofor[i].morteMorrida);
    }

    ordenarGodofor(godofor, quantidade);

    printf("%s\n", godofor[0].nome);

    return 0;
}