// 3358 - Sobrenome não é fácil (05/02/2025)

#include <stdio.h>
#include <string.h>
#include <stdbool.h> 

int main(){
    int quantidade;
    scanf("%d", &quantidade);
    getchar();

    char sobrenomes[quantidade][100];
    for(int i = 0; i < quantidade; i++){
        fgets(sobrenomes[i], 100, stdin);
        sobrenomes[i][strcspn(sobrenomes[i], "\n")] = 0;
    }

    char caracterAtual;

    for(int i = 0; i < quantidade; i++){
        int contador = 0;
        bool ehFacil = true;

        for(int j = 0; j < strlen(sobrenomes[i]); j++){
            caracterAtual = sobrenomes[i][j];

            if(!strchr("AEIOUaeiou", caracterAtual)){
                contador++;
                if(contador > 2){
                    printf("%s nao eh facil\n", sobrenomes[i]);
                    ehFacil = false;
                    break;
                } 
            } else {
                contador = 0;
            }
          }
        
        if (ehFacil) {
            printf("%s eh facil\n", sobrenomes[i]);
        }
        }

    return 0;
}