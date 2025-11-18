//
// Created by 강병진 on 25. 5. 12.
//
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include <string.h>
int p_06(void)
{
    char s[15] = "program";
    const char* str1 = "compile";
    printf("original s : %s\n", s);
    printf("length of s: %d\n", strlen(s));
    strncpy(s, str1, 4);
    printf("\ns after strncpy : %s\n", s);
    printf("length of s: %d\n", strlen(s));
    s[4] = '\0';
    printf("\ns after NULL : %s\n", s);
    printf("length of s: %d\n", strlen(s));
    return 0;
}
