//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
#include <stdlib.h>
char* itoa(int value, char* str, int base);

int p_04(void) {
    int num1 = 14;
    long num2 = 512;
    char s[25];
    itoa(num1, s, 2);
    printf("정수:%d, 2진수문자열:%s\n", num1, s);
    itoa(num2, s, 16);
    printf("정수:%ld, 16진수 문자열:%s\n",num2, s);
    return 0;
}

char* itoa(int value, char* str, int base) {
    char *p = str;
    int sign = 0;

    if (value < 0 && base == 10) {
        sign = 1;
        value = -value;
    }

    int temp = value;
    do {
        int digit = temp % base;
        *p++ = (digit < 10) ? digit + '0' : digit - 10 + 'A';
        temp /= base;
    } while (temp);

    if (sign) *p++ = '-';
    *p = '\0';
    for (int i = 0, j = p - str - 1; i < j; i++, j--) {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }

    return str;
}



