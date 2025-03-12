#include <stdio.h> 
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

bool ehPalindromo(char *texto){
        int i = 0;
        int j = strlen(texto) - 1;

        while(i < j){
            if(texto[i] != texto[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

int main(){
    char entrada[100];
    while(!(strcmp(entrada, "FIM") == 0)){
        if(fgets(entrada, sizeof(entrada), stdin) != NULL){
            entrada[strcspn(entrada, "\n")] = '\0';
          
                if(ehPalindromo(entrada)){
                    printf("SIM\n");
                } else {
                    printf("NAO\n");
                }
        }
    }

    return 0;
}