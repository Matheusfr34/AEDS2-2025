//2492 - Ilhas Isoladas (04/02/2025)

#include <stdio.h>
#include <string.h>

int main(){
    int quantidade;

    while (scanf("%d", &quantidade) && quantidade != 0) {
        getchar(); // Consumir a quebra de linha restante após o número

        char ilhaOrigem[quantidade][100];
        char ilhaDestino[quantidade][100];

        for (int i = 0; i < quantidade; i++){
            char entrada[200];
            fgets(entrada, sizeof(entrada), stdin); // Para ler a linha de entrada

            entrada[strcspn(entrada, "\n")] = 0; // Para remover a quebra de linha e ficar \0 

            // Separando pelo delimitador " -> "
            char *token = strtok(entrada, " ->");
            if(token != NULL){
                // Copia a origem
                strcpy(ilhaOrigem[i], token);

                // Passa para o próximo token, que deve ser o destino
                token = strtok(NULL, "->");

                if(token != NULL){
                    // Copia o destino
                    strcpy(ilhaDestino[i], token);
                }
            }
        }

        char resultado[20]; 
        strcpy(resultado, "Invertible.");

        for (int i = 0; i < quantidade; i++){
            for(int j = i + 1; j < quantidade; j++ ){
                if(strcmp(ilhaOrigem[i], ilhaOrigem[j]) == 0 && strcmp(ilhaDestino[i], ilhaDestino[j]) != 0){
                     strcpy(resultado, "Not a function.");
                    break;
                } else if(strcmp(ilhaOrigem[i], ilhaOrigem[j]) != 0 && strcmp(ilhaDestino[i], ilhaDestino[j]) == 0){
                    strcpy(resultado, "Not invertible.");
                    break;
                }
            }
        }

        printf("%s\n", resultado);

    }
    return 0;
}
