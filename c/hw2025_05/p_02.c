#include <stdio.h>
#include <stdlib.h>
// 대문자 알파벳 -65하면 배열에 순서대로 저장가능
int p_02(void) {
    int alpha[26] = {0};
    char c;
    FILE *fp;
    // fp = fopen("alphabet.txt", "w");
    // for (int i = 0; i < 1000; i++) {
    //     fprintf(fp, "%s\n", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    // }
    fp = fopen("alphabet.txt", "r");
    if (fp == NULL) {
        printf("Error in opening file\n");
        exit(1);
    }
    while ((c = fgetc(fp)) != EOF) {
        if (c <'A'|| c>'z') continue;

        if (c <= 'Z') {
            alpha[c - 'A'] += 1;
        }
        else if (c >= 'a' ) {
            alpha[c - 'a'] += 1;
        }

    }
    for (int i = 0; i < 26; i++) {
        printf("%d\n", alpha[i]);
    }
    fclose(fp);


    }
}

