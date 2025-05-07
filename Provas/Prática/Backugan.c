#include <stdio.h> 
#include <stdbool.h> 

int main(){
    int rodada;
    scanf("%d", &rodada);

    while(rodada != 0){
        int pontosMark = 0;
        int pontosLi = 0;
        int monstrosMark[rodada], monstrosLi[rodada];

        for(int i = 0; i < rodada; i++){
            scanf("%d", &monstrosMark[i]);
            pontosMark += monstrosMark[i];
        }

        for(int j = 0; j < rodada; j++){
            scanf("%d", &monstrosLi[j]);
            pontosLi += monstrosLi[j];
        }

        bool unicoMark = false;
        bool unicoLi = false;
        int contadorMark = 0, contadorLi = 0;

        for(int j = 0; j < rodada; j++){
            if(monstrosMark[j] == monstrosMark[j + 1]){
                contadorMark++;
            }
            if(monstrosLi[j] == monstrosLi[j + 1]){
                contadorLi++;
            }
        }

        if(contadorMark >= 3){
            pontosMark = pontosMark + 30;
            unicoMark = true;
        }

        if(contadorLi >= 3 && contadorMark == false){
            pontosLi = pontosLi + 30;
            unicoLi = true;
        }

        if(pontosMark > pontosLi){
            printf("M\n");
        } else if(pontosMark < pontosLi){
            printf("L\n");
        } else {
            printf("T\n");
        }

        scanf("%d", &rodada);
    }

    return 0;
}
