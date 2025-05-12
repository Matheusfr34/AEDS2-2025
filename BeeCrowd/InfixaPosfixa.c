#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct pilha{
    char* array;
    int topo;
    int tam;
} Pilha;

//Método para inicializar a pilha
void inicializarPilha(Pilha *p, int tamanho){
    p->array = (char*)malloc(tamanho * sizeof(char));
    p->topo = -1;
    p->tam = tamanho;
}

//Método para destruir a pilha e liberar memória
void destruirPilha(Pilha *p){
    free(p->array);
    p->topo = -1;
    p->tam = 0;
}

//Método para inserir na pilha 
void empilhar(char caracter, Pilha *p){
    if(p->topo >= p->tam - 1){
         printf("Erro. Pilha cheia.");
         return;
    }

    p->array[++p->topo] = caracter;
}

char mostrarTopo(Pilha *p){
    if(p->topo == -1){
        return '\0';
    }

    return p->array[p->topo];
}

//Método para remover na pilha 
char desempilhar(Pilha *p){
    if(p->topo == -1){
        printf("Erro. Pilha vazia.");
        return '\0';
    }

    return p->array[p->topo--];
}

//Método para verificar a ordem de precedência do caracter
int precedencia(char caracter){
    if(caracter == '^'){
        return 1;
    } else if(caracter == '*' || caracter == '/'){
        return 2;
    } else if(caracter == '+' || caracter == '-'){
        return 3;
    } else {
        return 4;
    }
}

void posfixar(char infixa[], Pilha *p){
    char saida[300];
    int contador = 0;

    for(int i = 0; i < strlen(infixa); i++){
        char caracterAtual = infixa[i];

        // Primeiro caso: o caracter é alfanúmerico, ele deve ser adicionado a saída
        if(caracterAtual >= 'A' && caracterAtual <= 'Z' ||
         caracterAtual >= 'a' && caracterAtual <= 'z' ||
         caracterAtual >= '0' && caracterAtual <= '9'){
            saida[contador++] = caracterAtual;
        }

        //Segundo caso: verificar se o caracter é "("
        if(caracterAtual == '('){
            empilhar(caracterAtual, p);
        } 

        //Terceiro caso: verificar se o caracter é ")". Caso verdadeiro, desempilhar tudo da pilha 
        else if(caracterAtual == ')'){
            while(p->topo != -1 && mostrarTopo(p) != '('){ //Desempilhar até encontrar (
                saida[contador++] = desempilhar(p); 
            }
            if(mostrarTopo(p) == '('){
                desempilhar(p);
            }
        }

        //Quarto caso: verificar os operadores e a ordem de precedência
        else if(caracterAtual == '^' || caracterAtual == '*' || caracterAtual == '/' || caracterAtual == '+' || caracterAtual == '-'){
            while(p->topo != -1 && mostrarTopo(p) != '(' && precedencia(mostrarTopo(p)) <= precedencia(caracterAtual)){
                saida[contador++] = desempilhar(p);
            }
            empilhar(caracterAtual, p);
        }

    }

    //Por fim, imprimir os caracteres restantes
    while(p->topo != -1){
        saida[contador++] = desempilhar(p);
    }

    saida[contador] = '\0';
    printf("%s\n", saida);

}

int main(){
    int quantidade;
    scanf("%d", &quantidade);
    getchar();

    Pilha p;
    inicializarPilha(&p, 300);

    for(int i = 0; i < quantidade; i++){
        char entrada[300];
        fgets(entrada, sizeof(entrada), stdin);

        posfixar(entrada, &p);
    }
    
    destruirPilha(&p);

    return 0;
}