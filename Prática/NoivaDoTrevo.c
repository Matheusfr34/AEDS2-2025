#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 1000

typedef struct {
    int minutos;      // minutos relativos à meia-noite
    int ordem;        // ordem de entrada
    char nome[101];   // nome do morador
} Relato;

// Função para converter horário no formato HH:MM para minutos relativos à meia-noite
int converter_para_minutos(char* horario) {
    int hora, minuto;
    sscanf(horario, "%d:%d", &hora, &minuto);

    if (hora == 0) {
        return minuto; // depois da meia-noite
    } else {
        return -((60 - minuto) + (23 - hora) * 60); // antes da meia-noite
    }
}

// Função de comparação para qsort
int comparar(const void* a, const void* b) {
    Relato* r1 = (Relato*)a;
    Relato* r2 = (Relato*)b;

    if (r1->minutos != r2->minutos)
        return r1->minutos - r2->minutos; // ordena pelo horário
    return r1->ordem - r2->ordem;         // desempate pela ordem de entrada
}

int main() {
    int P, Q;
    scanf("%d %d", &P, &Q);

    Relato relatos[MAX];
    int validos = 0;
    char horario[6], nome[101];

    for (int i = 0; i < Q; i++) {
        scanf("%s %s", horario, nome);
        int minutos = converter_para_minutos(horario);
        if (minutos >= -P && minutos <= P) {
            relatos[validos].minutos = minutos;
            relatos[validos].ordem = i;
            strcpy(relatos[validos].nome, nome);
            validos++;
        }
    }

    qsort(relatos, validos, sizeof(Relato), comparar);

    for (int i = 0; i < validos; i++) {
        printf("%s\n", relatos[i].nome);
    }

    return 0;
}
