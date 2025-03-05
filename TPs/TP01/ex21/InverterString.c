#include <stdio.h>
#include <stdbool.h>
#include <string.h>

//função recursiva que inverte a string 
void inverterStringRecursivo(char* texto, int i, int tamanho){
    //tamanho é dividido por 2, porque sempre troca o inicio e o fim, então a iteração é tamanho / 2
    if (i >= tamanho / 2) {
        return;
    }

    char tmp = texto[i];
    texto[i] = texto[tamanho - 1 - i];
    texto[tamanho - 1 - i] = tmp;

    //chamada recursiva
    return inverterStringRecursivo(texto, i + 1, tamanho);
}

//função principal que irá chamar a recursão 
void inverterString(char* texto){
    int tamanho = strlen(texto);

    return inverterStringRecursivo(texto, 0, tamanho);
}

int main(){
    char entrada[100];
    while (fgets(entrada, sizeof(entrada), stdin) != NULL){
        entrada[strcspn(entrada, "\n")] = '\0';
        if (strcmp(entrada, "FIM") == 0){
            break;
        }
        else{
            inverterString(entrada);
            printf("%s\n", entrada);
        }
    }
    return 0;
}