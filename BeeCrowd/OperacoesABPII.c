#include <stdio.h>
#include <stdlib.h> 
#include <string.h>

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

void remover(No* raiz, int x){
    raiz = removerRec(raiz, x);
}

No* removerRec(No* i, int x){
    if(i == NULL){
        return 0;
    } else if(x < i->elemento){
        i->esq = removerRec(i->esq, x);
    } else if(x > i->elemento){
        i->dir = removerRec(i->dir, x);
    } else if(i->esq == NULL){
        i = i->dir;
    } else if(i->dir == NULL){
        i = i->esq;
    } else {
        i->esq = maiorEsq(i, i->esq);
    }
    return i;
}

No* maiorEsq(No* i, No* j){
    if(j->dir == NULL){
        i->elemento = j->elemento;
        j = j->esq;
    } else {
        j->dir = maiorEsq(i, j->dir);
    }
}

void liberarArvore(No* raiz){
    liberarArvore(raiz->esq);
    liberarArvore(raiz->dir);
    free(raiz);
}

int main(){
    int linha[7];
    No* raiz = NULL;

    while(scanf("%s", linha) != EOF){
        if(linha[0] == 'I' && linha[1] == '\0'){
            int x;
            scanf("%d", &x);
            raiz = inserir(raiz, x);
        }
    }
    return 0;
}