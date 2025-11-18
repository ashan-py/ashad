#include <stdio.h>
#include <stdlib.h>
char* itoa(int value, char *str, int base);
int p_09(void)
{
    int a = 7, b = 12;
    char bina[33], binb[33], btmp[33];

    itoa(a, bina, 2);
    printf(" a의 2진수:%32s\n", bina);
    itoa(~a, binb,  2);
    printf("~a의 2진수:%32s\n", binb);

    itoa(b, binb, 2);
    printf(" b의 2진수:%32s\n", binb);

    itoa(a & b, btmp, 2);
    printf(" a & b     :%32s\n", btmp);

    itoa(a | b, btmp, 2);
    printf(" a | b     :%32s\n", btmp);

    itoa(a ^ b, btmp, 2);
    printf(" a ^ b     :%32s\n", btmp);

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
