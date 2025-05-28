#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct No {
    char palavra[200];
    struct No *esq, *dir;
} No;

No* novoNo(char *palavra) {
    No* novo = (No*)malloc(sizeof(No));
    strcpy(novo->palavra, palavra);
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}

No* inserir(char* palavra, No* i) {
    if(i == NULL) {
        i = novoNo(palavra);
    } else if(strcmp(palavra, i->palavra) < 0) {
        i->esq = inserir(palavra, i->esq);
    } else if(strcmp(palavra, i->palavra) > 0) {
        i->dir = inserir(palavra, i->dir);
    }
    return i;
}

void caminharCentral(No *i) {
    if(i != NULL) {
        caminharCentral(i->esq);
        printf("%s\n", i->palavra);
        caminharCentral(i->dir);
    }
}

void liberarArvore(No* raiz) {
    if (raiz != NULL) {
        liberarArvore(raiz->esq);
        liberarArvore(raiz->dir);
        free(raiz);
    }
}

int main() {
    char linha[200];
    No* raiz = NULL;
    
    while(fgets(linha, sizeof(linha), stdin)) {
        char palavra[200];
        int pos = 0;
        
        for(int i = 0; linha[i] != '\0'; i++) {
            if (linha[i] >= 'A' && linha[i] <= 'Z') {
                palavra[pos++] = linha[i] + 32;
            } else if(linha[i] >= 'a' && linha[i] <= 'z') {
                palavra[pos++] = linha[i];
            } else {
                if(pos > 0) {
                    palavra[pos] = '\0';
                    raiz = inserir(palavra, raiz);
                    pos = 0;
                }
            }
        }

        if (pos > 0) {
            palavra[pos] = '\0';
            raiz = inserir(palavra, raiz);
        }
    }

    caminharCentral(raiz);
    liberarArvore(raiz);

    return 0;
}