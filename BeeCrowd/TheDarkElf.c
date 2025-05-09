#include <stdio.h>
#include <string.h>

typedef struct{
    char nome[100];
    double peso;
    double idade;
    double altura;
} Rena;

int compRenas(Rena a, Rena b){
    //Comparar pelo peso (Descendente)
    int compPeso;
    if(a.peso > b.peso){
        compPeso = -1;
    } else if(a.peso < b.peso){
        compPeso = 1;
    } else {
        compPeso = 0;
    }
    if(compPeso != 0){
        return compPeso;
    }

    //Comparar pela idade (Ascendente)
    int compIdade;
    if(a.idade > b.idade){
        compIdade = 1;
    } else if(a.idade < b.idade){
        compIdade = -1;
    } else {
        compIdade = 0;
    }
    if(compIdade != 0){
        return compIdade;
    }

    //Comparar pela altura (Ascendente)
    int compAltura;
    if(a.altura > b.altura){
        compAltura = 1;
    } else if(a.altura < b.altura){
        compAltura = -1;
    } else {
        compAltura = 0;
    }
    if(compAltura != 0){
        return compAltura;
    }

    return strcmp(a.nome, b.nome);
}

void ordenarRenas(Rena rena[], int tamanho){
    for(int i = 1; i < tamanho; i++){
        Rena tmp = rena[i];
        int j = i - 1;
        while(j >= 0 && compRenas(rena[j], tmp) > 0){
            rena[j + 1] = rena[j];
            j--;
        }
        rena[j + 1] = tmp;
    }
}

int main(){
    int quantidade;
    scanf("%d", &quantidade);

    for (int j = 0; j < quantidade; j++){
        int totalRenas, renasUsadas;
        scanf("%d %d", &totalRenas, &renasUsadas);

        Rena rena[totalRenas];

        for (int i = 0; i < totalRenas; i++){
            scanf("%s %lf %lf %lf", rena[i].nome, &rena[i].peso, &rena[i].idade, &rena[i].altura);
        }

       ordenarRenas(rena, totalRenas);
       printf("CENARIO {%d}\n", (j + 1));

       for (int i = 0; i < renasUsadas; i++){
         printf("%d - %s\n", (i + 1), rena[i].nome);
        }

    }

    return 0;
}