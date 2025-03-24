#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main() {
    char placa[9];

    // Ler várias entradas até o fim do arquivo (EOF)
    while (fgets(placa, sizeof(placa), stdin)) {
        // Remover o caractere de nova linha, se presente
        placa[strcspn(placa, "\n")] = 0;

        int tam = strlen(placa);
        int contAntiga = 0;
        int contMercosul = 0;

        // Verificar se a placa tem 8 caracteres (modelo antigo)
        if (tam == 8) {
            // Primeiras 3 posições (letras)
            if (placa[0] >= 'A' && placa[0] <= 'Z' && 
                placa[1] >= 'A' && placa[1] <= 'Z' && 
                placa[2] >= 'A' && placa[2] <= 'Z') {
                contAntiga += 3;
            }
            // Posição 4 (deve ser '-')
            if (placa[3] == '-') {
                contAntiga++;
            }
            // Últimas 4 posições (números)
            if (placa[4] >= '0' && placa[4] <= '9' && 
                placa[5] >= '0' && placa[5] <= '9' && 
                placa[6] >= '0' && placa[6] <= '9' && 
                placa[7] >= '0' && placa[7] <= '9') {
                contAntiga += 4;
            }
        } 
        // Verificar se a placa tem 7 caracteres (modelo Mercosul)
        else if (tam == 7) {
            // Primeiras 3 posições (letras)
            if (placa[0] >= 'A' && placa[0] <= 'Z' && 
                placa[1] >= 'A' && placa[1] <= 'Z' && 
                placa[2] >= 'A' && placa[2] <= 'Z') {
                contMercosul += 3;
            }
            // Posição 4 (número)
            if (placa[3] >= '0' && placa[3] <= '9') {
                contMercosul++;
            }
            // Posição 5 (letra)
            if (placa[4] >= 'A' && placa[4] <= 'Z') {
                contMercosul++;
            }
            // Últimas 2 posições (números)
            if (placa[5] >= '0' && placa[5] <= '9' && 
                placa[6] >= '0' && placa[6] <= '9') {
                contMercosul += 2;
            }
        }

        // Verificar se o formato é válido e imprimir o resultado
        if (contAntiga == 8) {
            printf("1\n");
        } else if (contMercosul == 7) {
            printf("2\n");
        } else {
            printf("0\n");
        }
    }

    return 0;
}
