// 2150 - Vogais Alienígenas (05/02/2025)

#include <stdio.h>
#include <string.h>

int main(){
    char vogais[100];
    char frase[100];

    while(fgets(vogais, 100, stdin) != NULL){
        vogais [strcspn(vogais, "\n")] = 0;
        
        if (fgets(frase, 100, stdin) == NULL) {
            break;  // Evita erro caso a entrada termine de forma inesperada
        }

        frase [strcspn(frase, "\n")] = 0;

        int contador = 0;
        int tamVogais = strlen(vogais);
        int tamFrase = strlen(frase);
        for(int j = 0; j < tamVogais; j++){
            for(int k = 0; k < tamFrase; k++){
                if(frase[k] == vogais[j]){
                    contador++;
                }
            }
        }

        printf("%d\n", contador);

    }
    return 0;
}