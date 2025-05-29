#include <stdio.h>
#include <stdlib.h>

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

void liberarArvore(No* raiz){
    if(raiz != NULL){
        liberarArvore(raiz->esq);
        liberarArvore(raiz->dir);
        free(raiz);
    }
}

int primeiro;

void prefixoRec(No* i){
    if(i != NULL){
        if (primeiro) {
            printf("%d", i->elemento);
            primeiro = 0;
        } else {
            printf(" %d", i->elemento);
        }
        prefixoRec(i->esq);
        prefixoRec(i->dir);
    }
}

void prefixo(No* raiz){
    prefixoRec(raiz);
}

void infixoRec(No* i){
    if(i != NULL){
        infixoRec(i->esq);
        if (primeiro) {
            printf("%d", i->elemento);
            primeiro = 0;
        } else {
            printf(" %d", i->elemento);
        }
        infixoRec(i->dir);
    }
}

void infixo(No* raiz){
    infixoRec(raiz);
}

void posfixoRec(No* i){
    if(i != NULL){
        posfixoRec(i->esq);
        posfixoRec(i->dir);
        if (primeiro) {
            printf("%d", i->elemento);
            primeiro = 0;
        } else {
            printf(" %d", i->elemento);
        }
    }
}

void posfixo(No* raiz){
    posfixoRec(raiz);
}

int main(){
    int testes;
    scanf("%d", &testes);

    for(int i = 0; i < testes; i++){
        No* raiz = NULL;
        int quantElementos;
        scanf("%d", &quantElementos);
        int elemento[quantElementos];

        for(int j = 0; j < quantElementos; j++){
            scanf("%d ", &elemento[j]);
            raiz = inserir(raiz, elemento[j]);
        }

        printf("Case %d:\n", i + 1);

        primeiro = 1;
        printf("Pre.: ");
        prefixo(raiz);
        printf("\n");

        primeiro = 1;
        printf("In..: ");
        infixo(raiz);
        printf("\n");

        primeiro = 1;
        printf("Post: ");
        posfixo(raiz);
        printf("\n\n");

        liberarArvore(raiz);
    }

    return 0;
}
