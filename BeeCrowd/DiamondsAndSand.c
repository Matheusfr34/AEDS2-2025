#include <stdio.h>
#include <string.h>

int main(){
    int testes;
    scanf("%d", &testes);
    getchar();

    char entrada[100];

    for(int i = 0; i < testes; i++){
        int abrirChaves = 0, contador = 0;
        
        fgets(entrada, sizeof(entrada), stdin);
        
        for(int j = 0; j < strlen(entrada); j++){
            if(entrada[j] == '<'){
                abrirChaves++;
            } else if(entrada[j] == '>' && abrirChaves > 0){
                contador++;
                abrirChaves--;
            }
        }

        printf("%d\n", contador);
    }

    return 0;
}