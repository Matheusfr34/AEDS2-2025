#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

#define MAX_SHOWS 2000
#define MAX_LINE 1024

typedef struct {
    int mes;
    int dia;
    int ano;
} Date;

typedef struct {
    char* show_id;
    char* type;
    char* title;
    char* director;
    char** cast;
    int cast_count;
    char* country;
    Date date_added;
    bool has_date;
    char* raw_date; // <- Adicionado para armazenar a data original do CSV
    int release_year;
    char* rating;
    char* duration;
    char** listed_in;
    int listed_in_count;
} Show;

Show shows[MAX_SHOWS];
int total_shows = 0;

// ================== Funções auxiliares ===================

char* allocString(const char* src) {
    char* s = (char*)malloc(strlen(src) + 1);
    strcpy(s, src);
    return s;
}

// Remove espaços no início e fim da string
char* trim(char* str) {
    while (isspace((unsigned char)*str)) str++;

    if (*str == 0) return str;

    char* end = str + strlen(str) - 1;
    while (end > str && isspace((unsigned char)*end)) end--;

    end[1] = '\0';
    return str;
}

void insertionSort(char** array, int length) {
    for (int i = 1; i < length; i++) {
        char* tmp = array[i];
        int j = i - 1;
        while (j >= 0 && strcmp(array[j], tmp) > 0) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = tmp;
    }
}

// Divide a linha do CSV corretamente mesmo com campos vazios
int parseCSVLine(char* linha, char** campos, int max_campos) {
    int i = 0;
    bool dentroDeAspas = false;
    char* inicio = linha;
    char* atual = linha;

    while (*atual && i < max_campos) {
        if (*atual == '"') {
            dentroDeAspas = !dentroDeAspas;
        } else if (*atual == ',' && !dentroDeAspas) {
            *atual = '\0';

            // Remover aspas externas, se houver
            char* valor = inicio;
            if (valor[0] == '"' && valor[strlen(valor) - 1] == '"') {
                valor[strlen(valor) - 1] = '\0';
                valor++;
            }

            campos[i++] = allocString(valor);
            inicio = atual + 1;
        }
        atual++;
    }

    if (i < max_campos) {
        // Último campo
        char* valor = inicio;
        if (valor[0] == '"' && valor[strlen(valor) - 1] == '"') {
            valor[strlen(valor) - 1] = '\0';
            valor++;
        }

        campos[i++] = allocString(valor);
    }

    return i;
}

char** splitString(char* str, int* count) {
    char* temp = allocString(str);
    char* token = strtok(temp, ",");
    char** result = (char**)malloc(20 * sizeof(char*));
    int idx = 0;

    while (token != NULL) {
        char* limpo = trim(token);
        if (strlen(limpo) > 0) {
            result[idx++] = allocString(limpo);
        }
        token = strtok(NULL, ",");
    }

    *count = idx;
    free(temp);
    return result;
}

int mesToInt(char* mes_str) {
    if (strcmp(mes_str, "January") == 0) return 1;
    if (strcmp(mes_str, "February") == 0) return 2;
    if (strcmp(mes_str, "March") == 0) return 3;
    if (strcmp(mes_str, "April") == 0) return 4;
    if (strcmp(mes_str, "May") == 0) return 5;
    if (strcmp(mes_str, "June") == 0) return 6;
    if (strcmp(mes_str, "July") == 0) return 7;
    if (strcmp(mes_str, "August") == 0) return 8;
    if (strcmp(mes_str, "September") == 0) return 9;
    if (strcmp(mes_str, "October") == 0) return 10;
    if (strcmp(mes_str, "November") == 0) return 11;
    if (strcmp(mes_str, "December") == 0) return 12;
    return 0;
}

void preencherShows() {
    FILE* file = fopen("disneyplus.csv", "r");
    if (file == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return;
    }

    char linha[MAX_LINE];
    fgets(linha, MAX_LINE, file); // cabeçalho

    while (fgets(linha, MAX_LINE, file)) {
        linha[strcspn(linha, "\n")] = '\0';

        char* campos[11];
        int qtd = parseCSVLine(linha, campos, 11);
        if (qtd < 11) continue;

        Show s;
        s.show_id = campos[0];
        s.type = campos[1];
        s.title = campos[2];
        s.director = campos[3];

        s.cast_count = 0;
        s.cast = splitString(campos[4], &s.cast_count);
        insertionSort(s.cast, s.cast_count);

        s.country = campos[5];

        s.has_date = false;
        s.raw_date = allocString(campos[6]); // <- armazenar valor original
        if (strlen(campos[6]) > 0) {
            char mes_str[20];
            int dia, ano;
            if (sscanf(campos[6], "%s %d, %d", mes_str, &dia, &ano) == 3) {
                s.date_added.dia = dia;
                s.date_added.mes = mesToInt(mes_str);
                s.date_added.ano = ano;
                s.has_date = true;
            }
        }

        s.release_year = atoi(campos[7]);
        s.rating = campos[8];
        s.duration = campos[9];
        s.listed_in = splitString(campos[10], &s.listed_in_count);

        shows[total_shows++] = s;
    }

    fclose(file);
}

void imprimirShow(Show s) {
    printf("=> %s ## %s ## %s ## %s ## [", s.show_id, s.title, s.type, strlen(s.director) > 0 ? s.director : "NaN");

    if (s.cast_count == 0) {
        printf("NaN");
    } else {
        for (int i = 0; i < s.cast_count; i++) {
            printf("%s", s.cast[i]);
            if (i < s.cast_count - 1) printf(", ");
        }
    }

    printf("] ## %s ## ", strlen(s.country) > 0 ? s.country : "NaN");

    if (s.has_date)
        printf("%s ## ", s.raw_date); // <- imprimir data original sem aspas
    else
        printf("NaN ## ");

    printf("%d ## %s ## %s ## [", s.release_year, s.rating, s.duration);

    if (s.listed_in_count == 0) {
        printf("NaN");
    } else {
        for (int i = 0; i < s.listed_in_count; i++) {
            printf("%s", s.listed_in[i]);
            if (i < s.listed_in_count - 1) printf(", ");
        }
    }

    printf("] ##\n");
}

bool isFim(char* str) {
    return strcmp(str, "FIM") == 0;
}

int main() {
    preencherShows();

    char str[20];
    while (true) {
        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        if (isFim(str)) break;

        for (int i = 0; i < total_shows; i++) {
            if (strcmp(shows[i].show_id, str) == 0) {
                imprimirShow(shows[i]);
                break;
            }
        }
    }

    // Liberação de memória
    for (int i = 0; i < total_shows; i++) {
        free(shows[i].show_id);
        free(shows[i].type);
        free(shows[i].title);
        free(shows[i].director);
        for (int j = 0; j < shows[i].cast_count; j++) {
            free(shows[i].cast[j]);
        }
        free(shows[i].cast);
        free(shows[i].country);
        free(shows[i].raw_date); // <- liberar memória da data original
        free(shows[i].rating);
        free(shows[i].duration);
        for (int j = 0; j < shows[i].listed_in_count; j++) {
            free(shows[i].listed_in[j]);
        }
        free(shows[i].listed_in);
    }

    return 0;
}
