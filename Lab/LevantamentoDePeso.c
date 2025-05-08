#include <stdio.h>
#include <string.h> 

typedef struct {
    char nome[100];
    int peso;
} Atleta;

int compAtletas(Atleta a, Atleta b){
    int compAtletas = 0;
    if(a.peso > b.peso ){
        compAtletas = -1;
    } else if(a.peso < b.peso){
        compAtletas = 1;
    } else {
        compAtletas = 0 ;
    }
    if(compAtletas != 0){
        return compAtletas;
    }

    return strcmp(a.nome, b.nome);
}

void ordenarInsercao(Atleta atleta[], int tamanho){
    for(int i = 1; i < tamanho; i++){
        Atleta tmp = atleta[i];
        int j = i - 1;
        while(j >= 0 && compAtletas(atleta[j], tmp) > 0){
            atleta[j + 1] = atleta[j];
            j--;
        }
        atleta[j + 1] = tmp;
    }
}

int main(){

    Atleta atleta[500];
    int contador = 0;

    while(scanf("%s %d", atleta[contador].nome, &atleta[contador].peso) != EOF){
        contador++;
    }

    ordenarInsercao(atleta, contador);

    for(int i = 0; i < contador; i++){
        printf("%s %d\n", atleta[i].nome, atleta[i].peso);
    }

    return 0;
}
