#include <stdio.h>

typedef struct{
   int array;
   int n;
} PilhaLinear;

//Método que aloca dinamicamente uma pilha que armazena, no máximo, max elementos
PilhaLinear* newPilhaLinear(int max){
    // Aloca memória para a estrutura PilhaLinear
    PilhaLinear* pilha = (PilhaLinear*) malloc (max * sizeof(PilhaLinear));
    if (pilha == NULL) {
        printf("Erro na alocação da pilha!\n");
        return NULL;
    }

    // Aloca memória para o array de elementos
    pilha->array = (int* ) malloc (max * sizeof(int));
    if (pilha->array == NULL) {
        printf("Erro na alocação do array!\n");
        free(pilha); // Libera a memória alocada para a estrutura
        return NULL;
    }

    //Inicializar os valores da Pilha "Construtor"
    pilha->n = 0;

    return pilha; 
}

void delPilhaLinear(PilhaLinear* pilha){

    //Desalocar a pilha
    free(pilha);
}

void empilhar(PilhaLinear* pilha, int elemento){
    
}

int desempilhar(PilhaLinear* pilha){

}

void mostrar(PilhaLinear* pilha){

}

int pesquisar(PilhaLinear* pilha, int elemento){

}

int main(){

    return 0;
}


