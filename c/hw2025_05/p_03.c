#include <stdio.h>

int p_03(void) {
    char str[100];
    FILE *fp1, *fp2;
    // fp1 = fopen("a1.txt", "w");
    // fp2 = fopen("a2.txt", "w");
    // fputs("25 74\n48 80", fp1);
    // fputs("65 53\n78 77", fp2);
    fp1 = fopen("a1.txt", "r");
    fp2 = fopen("a2.txt", "r");
    if (fp1==NULL) {
        printf("Error in opening a1.txt file\n");
    }
    if (fp2==NULL) {
        printf("Error in opening a2.txt file\n");
    }
    fseek(fp1, -1, SEEK_END);  // 마지막 문자로 이동
    int last_char = fgetc(fp1);
    fclose(fp1);
    fp1 = fopen("a1.txt", "a");
    if (last_char != '\n') {
        fputs("\n", fp1);  // 개행 없으면 추가
    }
    while ((fgets(str, sizeof(str), fp2)) != NULL) {
        fputs(str, fp1);
    }
    fclose(fp1);
    fclose(fp2);
    return 0;
}
