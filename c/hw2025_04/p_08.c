//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
#include <string.h>

void reverse_array(char m[]);

void p_08() {
    char chr[20];
    int length;

    printf("\n========== p_08() 연습문제 14.22 ==========\n");
    printf("영문 이름을 입력하고 Enter: ");
    gets(chr);
    printf("입력 문자열 = %s\n", chr);

    reverse_array( chr);
    printf("역순 문자열 = %s\n", chr);
}

void reverse_array(char m[]) {
    int i;
    int j;
    for (j=0; j<20; j++) {
        if (m[j] == '\0') {
            break;
        }
    }
    //printf("%d\n",j);
    char temp[j];

    for (i = 0; i <= j - 1; i++)
        temp[i] = m[i];

    for (i = 0; i <= j - 1; i++)
        m[i] = temp[j - 1 - i];
}