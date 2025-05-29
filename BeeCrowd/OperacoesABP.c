#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct No {
    char elemento;
    struct No *esq, *dir;
} No;

No* novoNo(char elemento) {
    No* novo = (No*)malloc(sizeof(No));
    novo->elemento = elemento;
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}

No* inserir(No* i, char elemento) {
    if (i == NULL) {
        i = novoNo(elemento);
    } else if (elemento < i->elemento) {
        i->esq = inserir(i->esq, elemento);
    } else if (elemento > i->elemento) {
        i->dir = inserir(i->dir, elemento);
    }
    return i;
}

bool pesquisar(No* i, char elemento) {
    if (i == NULL) {
        return false;
    } else if (elemento == i->elemento) {
        return true;
    } else if (elemento < i->elemento) {
        return pesquisar(i->esq, elemento);
    } else {
        return pesquisar(i->dir, elemento);
    }
}

void infixo(No* i, bool* first) {
    if (i != NULL) {
        infixo(i->esq, first);
        if (*first) {
            printf("%c", i->elemento);
            *first = false;
        } else {
            printf(" %c", i->elemento);
        }
        infixo(i->dir, first);
    }
}

void prefixo(No* i, bool* first) {
    if (i != NULL) {
        if (*first) {
            printf("%c", i->elemento);
            *first = false;
        } else {
            printf(" %c", i->elemento);
        }
        prefixo(i->esq, first);
        prefixo(i->dir, first);
    }
}

void posfixo(No* i, bool* first) {
    if (i != NULL) {
        posfixo(i->esq, first);
        posfixo(i->dir, first);
        if (*first) {
            printf("%c", i->elemento);
            *first = false;
        } else {
            printf(" %c", i->elemento);
        }
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
    No* raiz = NULL;
    char comando[10];
    
    while (scanf("%s", comando) != EOF) {
        if (comando[0] == 'I' && comando[1] == '\0') {
            char letra;
            scanf(" %c", &letra);
            raiz = inserir(raiz, letra);
        } else if (strcmp(comando, "INFIXA") == 0) {
            bool first = true;
            infixo(raiz, &first);
            printf("\n");
        } else if (strcmp(comando, "PREFIXA") == 0) {
            bool first = true;
            prefixo(raiz, &first);
            printf("\n");
        } else if (strcmp(comando, "POSFIXA") == 0) {
            bool first = true;
            posfixo(raiz, &first);
            printf("\n");
        } else if (comando[0] == 'P' && comando[1] == '\0') {
            char letra;
            scanf(" %c", &letra);
            if (pesquisar(raiz, letra)) {
                printf("%c existe\n", letra);
            } else {
                printf("%c nao existe\n", letra);
            }
        }
    }

    liberarArvore(raiz);
    return 0;
}