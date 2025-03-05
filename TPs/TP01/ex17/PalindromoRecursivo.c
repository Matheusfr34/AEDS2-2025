#include <stdio.h> 
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

//Método recursivo para verificar se é palíndromo 
bool ehPalindromoRecursivo(char *texto, int i, int j){
    //Caso os dois sejam iguais, a string foi percorrida por completa
    if(i >= j){
        return true;
    } 
    if(texto[i] != texto[j]){
        return false;
    }
    return ehPalindromoRecursivo(texto, i + 1, j -1);
}

//Método para verificar se é um palindromo e que retorna o método recursivo
bool ehPalindromo(char *texto){
        int tamanho = strlen(texto);
        return ehPalindromoRecursivo(texto, 0, tamanho - 1);
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