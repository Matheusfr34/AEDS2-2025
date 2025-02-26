// 2174 - Coleção de Pomekons (05/02/2025)
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(){
    int quantidade, contador = 0, coletados = 0;
    scanf("%d", &quantidade);
    getchar();

    char pomekons[quantidade][100];

    for (int i = 0; i < quantidade; i++){
        fgets(pomekons[i], 100, stdin);
        pomekons[i][strcspn(pomekons[i], "\n")] = 0; // Para remover a quebra de linha e ficar \0
    }

    for (int i = 0; i < quantidade; i++){
        bool unico = true;
        for (int j = 0; j < i; j++){
            if (strcmp(pomekons[i], pomekons[j]) == 0) {
                unico = false;
                break;
            }
        }
        if (unico){
            contador++;
        }
    }

    coletados = 151 - contador;

    printf("Falta(m) %d pomekon(s). ", coletados);

    return 0;
}