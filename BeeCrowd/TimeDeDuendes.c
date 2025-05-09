#include <stdio.h>
#include <string.h>

typedef struct{
    char nome[20];
    int idade;
} Duende;

int compDuendes(Duende a, Duende b){
    if(a.idade > b.idade){
        return -1;
    } else if(a.idade < b.idade){
        return 1;
    }

    return strcmp(a.nome, b.nome);
}

void ordenarDuendes(Duende duende[], int tamanho){
    for(int i = 1; i < tamanho; i++){
        Duende tmp = duende[i];
        int j = i - 1;
        while(j >= 0 && compDuendes(duende[j], tmp) > 0){
            duende[j + 1] = duende[j];
            j--;
        }
        duende[j + 1] = tmp;
    }
}

int main(){
    int quantidade;
    scanf("%d", &quantidade);

    Duende duende[quantidade];

    for (int i = 0; i < quantidade; i++){
        scanf("%s %d", duende[i].nome, &duende[i].idade);
    }

    ordenarDuendes(duende, quantidade);

    int times = quantidade / 3; 
    for (int i = 0; i < times; i++){
            printf("Time %d\n", i + 1);
            printf("%s %d\n", duende[i].nome, duende[i].idade);
            printf("%s %d\n", duende[times + i].nome, duende[times + i].idade);
            printf("%s %d\n", duende[2 * times + i].nome, duende[2 * times + i].idade);
            printf("\n");
    }

    return 0;
}