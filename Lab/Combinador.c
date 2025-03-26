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

        int pos = 0;

        for (int i = 0; i < maior; i++) {
            if (i < tam1){
                juncao[pos] = str1[i];
                pos++;
            }
            if (i < tam2){
                juncao[pos] = str2[i];
                pos++;
            }
        }

        juncao[pos] = '\0';

        printf("%s\n", juncao);
    }
    return 0;
}