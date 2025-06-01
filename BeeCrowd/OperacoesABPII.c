#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#include <stdbool.h>

typedef struct No{
    int elemento;
    struct No *esq, *dir;
} No;

No* novoNo(int elemento){
    No* novo = (No*)malloc(sizeof(No));
    novo->elemento = elemento;
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}

No* inserir(No* i, int x){
    if(i == NULL){
        i = novoNo(x);
    } else if(x < i->elemento){
        i->esq = inserir(i->esq, x);
    } else if(x > i->elemento){
        i->dir = inserir(i->dir, x);
    }
    return i;
}

No* maiorEsq(No* i, No* j){
    if(j->dir == NULL){
        i->elemento = j->elemento;
        No* temp = j;
        j = j->esq;
        free(temp);
    } else {
        j->dir = maiorEsq(i, j->dir);
    }
    return j;
}

No* remover(No* i, int x) {
    if (i == NULL) {
        return NULL;
    } else if (x < i->elemento) {
        i->esq = remover(i->esq, x);  // corrigido
    } else if (x > i->elemento) {
        i->dir = remover(i->dir, x);  // corrigido
    } else {
        if (i->esq == NULL) {
            No* temp = i->dir;
            free(i);
            return temp;
        } else if (i->dir == NULL) {
            No* temp = i->esq;
            free(i);
            return temp;
        } else {
            i->esq = maiorEsq(i, i->esq);
            return i;
        }
    }
    return i;
}


bool pesquisar(No* i, int x){
    bool resp = false;
    if(i == NULL){
        return false;
    } else if(i->elemento == x){
        resp = true;
    } else if(x < i->elemento){
        resp = pesquisar(i->esq, x);
    } else {
        resp = pesquisar(i->dir, x);
    }
    return resp;
}

void prefixo(No* i, bool* primeiro){
    if(i != NULL){
        if(*primeiro){
            printf("%d", i->elemento);
            *primeiro = false;
        } else {
            printf(" %d", i->elemento);
        }
        prefixo(i->esq, primeiro);
        prefixo(i->dir, primeiro);
    }
}

void infixo(No* i, bool* primeiro){
    if(i != NULL){
        infixo(i->esq, primeiro);
        if(*primeiro){
            printf("%d", i->elemento);
            *primeiro = false;
        } else {
            printf(" %d", i->elemento);
        }
        infixo(i->dir, primeiro);
    }
}

void posfixo(No* i, bool* primeiro){
    if(i != NULL){
        posfixo(i->esq, primeiro);
        posfixo(i->dir, primeiro);
        if(*primeiro){
            printf("%d", i->elemento);
            *primeiro = false;
        } else {
            printf(" %d", i->elemento);
        }
    }
}

void liberarArvore(No* raiz){
    if(raiz != NULL){
        liberarArvore(raiz->esq);
        liberarArvore(raiz->dir);
        free(raiz);
    }
}

int main(){
    char linha[10];
    No* raiz = NULL;

    while(scanf("%s", linha) != EOF){
        if(linha[0] == 'I' && linha[1] == '\0'){
            int x;
            scanf("%d", &x);
            raiz = inserir(raiz, x);
        } else if(linha[0] == 'R' && linha[1] == '\0'){
            int x;
            scanf("%d", &x);
            raiz = remover(raiz, x);
        } else if(linha[0] == 'P' && linha[1] == '\0'){
            int x;
            scanf("%d", &x);
            if(pesquisar(raiz, x)){
                printf("%d existe\n", x);
            } else {
                printf("%d nao existe\n", x);
            }
        } else if(strcmp(linha, "INFIXA") == 0){
            bool primeiro = true;
            infixo(raiz, &primeiro);
            printf("\n");
        } else if(strcmp(linha, "PREFIXA") == 0){
            bool primeiro = true;
            prefixo(raiz, &primeiro);
            printf("\n");
        } else if(strcmp(linha, "POSFIXA") == 0){
            bool primeiro = true;
            posfixo(raiz, &primeiro);
            printf("\n");
        }
    }

    liberarArvore(raiz);
    return 0;
}