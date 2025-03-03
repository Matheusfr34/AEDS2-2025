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
    bool flag = false;
    while(!flag){
        if(fgets(entrada, sizeof(entrada), stdin) != NULL){
            entrada[strcspn(entrada, "\n")] = '\0';
            if(strlen(entrada) == 3 && entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M'){
                flag = true;
            } else {
                if(ehPalindromo(entrada)){
                    printf("SIM\n");
                } else {
                    printf("NAO\n");
                }
            }
        }
    }

    return 0;
}