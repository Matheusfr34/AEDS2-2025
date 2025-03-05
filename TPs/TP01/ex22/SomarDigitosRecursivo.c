#include <stdio.h>
#include <string.h>
#include <stdbool.h>

//Método recursivo para somar os digitos 
int somarDigitosRecursivo(char* numero, int soma, int tamanho){
    //Quando o tamanho é igual a zero, significa que todos os digitos já foram somados
    if(tamanho == 0){
        return soma;
    }
    //Subtrai o '0' para pegar o real valor do char para int, não a posição da tabela ASCII
    soma += numero[tamanho - 1] - '0';
    return somarDigitosRecursivo(numero, soma, tamanho - 1);
}

//Método para realizar a soma dos dígitos
int somarDigitos(char* numero){
    int tamanho = strlen(numero);

    return somarDigitosRecursivo(numero, 0, tamanho);
}

int main(){
    char entrada[5];
    bool flag = false;
    while(!flag){
        if(fgets(entrada, sizeof(entrada), stdin) !=  NULL){
            entrada[strcspn(entrada, "\n")] = '\0';
            if(strcmp(entrada, "FIM") == 0){
                flag = true;
            } else {
                int resultado = somarDigitos(entrada);
                printf("%d\n", resultado);
            }
        }
    }
    return 0;
}