//
// Created by 강병진 on 25. 5. 12.
//
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int my_strlen(const char *s);
void my_strcpy(char *s1, const char *s2);
void my_strcat(char *s1, const char *s2);

int main(int argc, char *argv[])
{
    int i;
    char s1[40], s2[40];

    printf("===== arg test =====\n\n");

    printf("Test program : int main(int argc, char *argv[]) \n");
    printf("Usage : argtest program text  Enter>\n");

    printf("argc=%d\n", argc);
    for (i = 0; i < argc; i++) {
        printf("argv[%d] : %s, length = %d \n", i, argv[i], my_strlen(argv[i]));
    }

    my_strcpy(s1, argv[1]);
    printf("s1 : %s, length = %d \n", s1, my_strlen(s1));

    my_strcpy(s2, argv[2]);
    printf("s2 : %s, length = %d \n", s2, my_strlen(s2));

    my_strcat(s1, s2);
    printf("s1 : %s, length = %d \n", s1, my_strlen(s1));

    return(0);
}

void my_strcat(char *s1, const char *s2)
{
    int i = 0, j = 0;

    while (s1[i] != '\0') i++;

    while (s2[j] != '\0') {
        s1[i++] = s2[j++];
    }

    s1[i] = '\0';
}

void my_strcpy(char* s1, const char* s2)
{
    int i = 0, j = 0;

    while (s2[i] != '\0') {
        s1[j++] = s2[i++];
    }

    s1[j] = '\0';
}

int my_strlen(const char *s)
{
    int sum = 0;

    while (s[sum] != '\0')	sum++;

    return(sum);
}
