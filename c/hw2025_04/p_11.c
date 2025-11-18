#include <stdio.h>
int my_strcmp(const char *s1, const char *s2);
char *my_strcpy(char *dest, const char *src);

int p_11(void) {
    char str2[100];
    printf("%d\n",my_strcmp("Welcome to C Programming !", "Welcome to C world !"));
    my_strcpy(str2, "Welcome to C Programming !");
    printf("%s", str2);

    return 0;
}
int my_strcmp(const char *s1, const char *s2) {
    while (*s1 && *s2) {
        if (*s1 != *s2) {
            return *s1 - *s2;
        }
        s1++;
        s2++;
    }
    return *s1 - *s2;
}
char *my_strcpy(char *dest, const char *src) {
    char *original = dest;
    while (*src) {
        *dest = *src;
        dest++;
        src++;

    }
    *dest = '\0';
    return original;
}
