#include <stdio.h>
#include <stdlib.h>

typedef struct No {
    int elemento;
    int altura;
    struct No* esq;
    struct No* dir;
} No;

// Função auxiliar para obter a altura de um nó
int altura(No* no) {
    if (no == NULL) return -1;
    return no->altura;
}

// Atualiza a altura de um nó
void atualizarAltura(No* no) {
    int altEsq = altura(no->esq);
    int altDir = altura(no->dir);
    no->altura = (altEsq > altDir ? altEsq : altDir) + 1;
}

// Calcula o fator de balanceamento
int fatorBalanceamento(No* no) {
    return (no == NULL) ? 0 : altura(no->dir) - altura(no->esq);
}

// Rotação à esquerda
No* rotacionarEsq(No* no) {
    No* noDir = no->dir;
    no->dir = noDir->esq;
    noDir->esq = no;
    atualizarAltura(no);
    atualizarAltura(noDir);
    return noDir;
}

// Rotação à direita
No* rotacionarDir(No* no) {
    No* noEsq = no->esq;
    no->esq = noEsq->dir;
    noEsq->dir = no;
    atualizarAltura(no);
    atualizarAltura(noEsq);
    return noEsq;
}

// Balanceamento do nó
No* balancear(No* no) {
    if (no == NULL) return NULL;

    atualizarAltura(no);
    int fator = fatorBalanceamento(no);

    if (fator == 2) {
        if (fatorBalanceamento(no->dir) < 0) {
            no->dir = rotacionarDir(no->dir);
        }
        return rotacionarEsq(no);
    }

    if (fator == -2) {
        if (fatorBalanceamento(no->esq) > 0) {
            no->esq = rotacionarEsq(no->esq);
        }
        return rotacionarDir(no);
    }

    return no;
}

// Inserção
No* inserir(int x, No* i) {
    if (i == NULL) {
        i = (No*)malloc(sizeof(No));
        i->elemento = x;
        i->altura = 0;
        i->esq = i->dir = NULL;
    } else if (x < i->elemento) {
        i->esq = inserir(x, i->esq);
    } else if (x > i->elemento) {
        i->dir = inserir(x, i->dir);
    }
    return balancear(i);
}

// Remoção
No* remover(int x, No* i) {
    if (i == NULL) return NULL;

    if (x < i->elemento) {
        i->esq = remover(x, i->esq);
    } else if (x > i->elemento) {
        i->dir = remover(x, i->dir);
    } else {
        if (i->esq == NULL || i->dir == NULL) {
            No* temp = (i->esq != NULL) ? i->esq : i->dir;
            free(i);
            return temp;
        } else {
            No* temp = i->esq;
            while (temp->dir != NULL)
                temp = temp->dir;
            i->elemento = temp->elemento;
            i->esq = remover(temp->elemento, i->esq);
        }
    }
    return balancear(i);
}

int main() {
    No* raiz = NULL;
    
    printf("=== TESTE ARVORE AVL ===\n");
    
    // Caso de teste 1: Inserções básicas
    printf("\nInserindo valores: 10, 20, 30, 40, 50, 25\n");
    raiz = inserir(10, raiz);
    raiz = inserir(20, raiz);
    raiz = inserir(30, raiz);
    raiz = inserir(40, raiz);
    raiz = inserir(50, raiz);
    raiz = inserir(25, raiz);
    
    printf("Altura da arvore apos insercoes: %d\n", altura(raiz));
    printf("Fator de balanceamento da raiz: %d\n", fatorBalanceamento(raiz));
    
    // Caso de teste 2: Remoções
    printf("\nRemovendo valores: 10, 40\n");
    raiz = remover(10, raiz);
    raiz = remover(40, raiz);
    
    printf("Altura da arvore apos remocoes: %d\n", altura(raiz));
    printf("Fator de balanceamento da raiz: %d\n", fatorBalanceamento(raiz));
    
    // Caso de teste 3: Inserção após remoção
    printf("\nInserindo novos valores: 5, 35\n");
    raiz = inserir(5, raiz);
    raiz = inserir(35, raiz);
    
    printf("Altura da arvore apos novas insercoes: %d\n", altura(raiz));
    printf("Fator de balanceamento da raiz: %d\n", fatorBalanceamento(raiz));
    
    // Caso de teste 4: Tentativa de remover elemento não existente
    printf("\nTentando remover valor 99 (nao existente)\n");
    raiz = remover(99, raiz);
    
    printf("Altura da arvore: %d\n", altura(raiz));
    
    // Caso de teste 5: Remoção da raiz
    if (raiz != NULL) {
        printf("\nRemovendo a raiz atual (%d)\n", raiz->elemento);
        raiz = remover(raiz->elemento, raiz);
        
        printf("Nova raiz: %d\n", raiz != NULL ? raiz->elemento : -1);
        printf("Altura da arvore: %d\n", altura(raiz));
    }
    
    return 0;
}