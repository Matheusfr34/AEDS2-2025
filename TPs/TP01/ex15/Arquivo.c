#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void remover(char *str) {
    int len = strlen(str);
    while (len > 0 && str[len - 1] == '0') {
        str[--len] = '\0';
    }
    if (len > 0 && str[len - 1] == '.') {
        str[--len] = '\0';
    }
}

int main() {
    int n;
    scanf("%d", &n);

    const char *filePath = "numeros.dat";

    FILE *file = fopen(filePath, "wb");
   
    for (int i = 0; i < n; i++) {
        double value;
        scanf("%lf", &value);
        fwrite(&value, sizeof(double), 1, file);
    }
    fclose(file);

    file = fopen(filePath, "rb");
  

    fseek(file, 0, SEEK_END);
    long fileSize = ftell(file);
    fseek(file, 0, SEEK_SET);

    for (int j = 0; j < n; j++) {
        fseek(file, fileSize - (j + 1) * sizeof(double), SEEK_SET);
        double value;
        fread(&value, sizeof(double), 1, file);

        char buffer[50];
        snprintf(buffer, sizeof(buffer), "%.10lf", value);

        remover(buffer);

        if (strchr(buffer, '.') == NULL) {
            printf("%d\n", (int)value);
        } else {
            printf("%s\n", buffer);
        }
    }

    fclose(file);

    return 0;
}
