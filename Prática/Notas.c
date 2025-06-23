#include <stdio.h>
#include <stdlib.h>

int main(){
	int qtdNotas, k;
	while(scanf("%d %d",&qtdNotas,&k) == 2){
		int notas[qtdNotas];

		for(int i = 0; i < qtdNotas; i++){
			scanf("%d",&notas[i]);
		}

		for(int i = 0; i < qtdNotas; i++){
			int maior = i;
			for(int j = i + 1; j < qtdNotas; j++){
				if(notas[j] > notas[maior]){
					maior = j;
				}
			}

			int aux = notas[i];
			notas[i] = notas[maior];
			notas[maior] = aux;
		}

		int resp = 0;
		for(int i = 0; i < k; i++){
			resp += notas[i];
		}

		printf("%d\n",resp);
	}
}