#include <stdio.h>
#include <string.h>

int main(){

    char str1[50];
    char str2[50];
    char juncao[100];

    while (scanf("%s %s", str1, str2) != EOF){
        int tam1 = strlen(str1);
        int tam2 = strlen(str2);
        
        int maior = tam1 > tam2 ? tam1 : tam2;
        int menor = tam1 < tam2 ? tam1 : tam2;

        for (int i = 0, j = 1; i < maior; i++, j++){
            if(j < menor){
            juncao[i] = str1[i];
            juncao[j] = str2[i];
            } else {
                juncao[i] = str1[i];
            }
        }

        printf("%s\n", juncao);

    }
    return 0;
}