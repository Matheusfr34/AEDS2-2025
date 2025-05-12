#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char identificador[1000];
    int direcao;
} Voo;

int main() {
    Voo todosVoos[1000];
    int totalVoos = 0;

    int direcaoAtual;
    char entrada[20];

    // Leitura da entrada
    while (1) {
        scanf("%s", entrada);

        if (entrada[0] == '0') {
            break;
        }

        if (entrada[0] == '-') {
            direcaoAtual = atoi(entrada);
        } else {
            strcpy(todosVoos[totalVoos].identificador, entrada);
            todosVoos[totalVoos].direcao = direcaoAtual;
            totalVoos++;
        }
    }

    // Separar voos por direção
    Voo filaOeste[1000], filaNorte[1000], filaSul[1000], filaLeste[1000];
    int qtdOeste = 0, qtdNorte = 0, qtdSul = 0, qtdLeste = 0;

    for (int i = 0; i < totalVoos; i++) {
        switch (todosVoos[i].direcao) {
            case -1:
                filaOeste[qtdOeste++] = todosVoos[i];
                break;
            case -2:
                filaSul[qtdSul++] = todosVoos[i];
                break;
            case -3:
                filaNorte[qtdNorte++] = todosVoos[i];
                break;
            case -4:
                filaLeste[qtdLeste++] = todosVoos[i];
                break;
        }
    }

    // Índices de controle de cada fila
    int idxOeste = 0, idxNorte = 0, idxSul = 0, idxLeste = 0;
    int voosImpressos = 0;

    // Impressão da fila final, respeitando o protocolo
    while (voosImpressos < totalVoos) {
        if (idxOeste < qtdOeste) {
            printf("%s", filaOeste[idxOeste++].identificador);
            voosImpressos++;
            if (voosImpressos < totalVoos) printf(" ");
        }
        if (idxNorte < qtdNorte) {
            printf("%s", filaNorte[idxNorte++].identificador);
            voosImpressos++;
            if (voosImpressos < totalVoos) printf(" ");
        }
        if (idxSul < qtdSul) {
            printf("%s", filaSul[idxSul++].identificador);
            voosImpressos++;
            if (voosImpressos < totalVoos) printf(" ");
        }
        if (idxLeste < qtdLeste) {
            printf("%s", filaLeste[idxLeste++].identificador);
            voosImpressos++;
            if (voosImpressos < totalVoos) printf(" ");
        }
    }

    printf("\n");
    return 0;
}
