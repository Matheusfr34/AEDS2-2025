#include <stdio.h>
#include <string.h>
void combinar(char *str1, char *str2, char *juncao,int pos, int i){
    int tam1 = strlen(str1);
    int tam2 = strlen(str2);

    int maior = tam1 > tam2 ? tam1 : tam2;

    if(i < maior){
    if (i < tam1){
        juncao[pos] = str1[i];
        pos++;
    }
    if (i < tam2) {
        juncao[pos] = str2[i];
        pos++;
    }
    return combinar(str1, str2, juncao, pos, i + 1);
    } 

   juncao[pos] = '\0';
}

int main(){

    char str1[50];
    char str2[50];
    char juncao[100];

    while (scanf("%s %s", str1, str2) != EOF){

        combinar(str1, str2, juncao, 0, 0);

        printf("%s\n", juncao);
    }
    return 0;
}