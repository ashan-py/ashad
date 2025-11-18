#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *right(char st[],int n);
char *left(char st[],int n);
char *mid(char st[],int s, int n);
char *reverse_han(char st[]);
char *remove_blank(char st[]);
int p_12(void) {
    char st1[] = "program";
    char st2[] = "한글 띄어쓰기 포함";
    printf("st1 = %s\n",st1);
    printf("st1 right(st1,3) = %s\n",right(st1,3));
    printf("st1 left(st1,4) = %s\n",left(st1,4));
    printf("st1 mid(st1,2,3) = %s\n",mid(st1,2,3));

    printf("st1 = %s\n",st2);
    printf("st2 reverse_han(st2) = %s\n", reverse_han(st2));
    printf("st2 remove blank(st2) = %s\n", remove_blank(st2));




    free(right(st1,4));
    free(left(st1,4));
    free(mid(st1,2,3));
    free(reverse_han(st2));
    free(remove_blank(st2));
    return 0;
}

char *right(char st[],int n) {
    char *p;
    p = (char *) malloc(n + 1);
    for (int i = 0; i<n; i++) {
        p[i] = st[i];

    }
    p[n] = '\0';

    return  p;
}

char *left(char st[],int n) {
    char *p;
    p = (char *)malloc(n + 1);
    int len = (int)strlen(st);
    int j=0;
    //printf("%d\n",len);
    for (int i = len-n; i<len; i++) {
        p[j] = st[i];
        j++;
    }
    p[n] = '\0';

    return p;
}

char *mid(char st[],int s, int n) {
    char *p;
    p = (char *)malloc(n + 1);
    int j=0;
    for (int i = s; i<s+n; i++) {
        p[j] = st[i-1];
        j++;
    }
    p[n] = '\0';

    return p;
}

char *reverse_han(char st[]) {
    int len = (int)strlen(st);
    int j = 0;
    //printf("krlen : %d", krlen);
    char *p;
    p = malloc(len + 1);

    for (int i = len-1; i >= 0;) {
        if (st[i] == ' ') {
            strncpy(p + j, " ", 3);
            j++;
            i--;
        }else {
            strncpy(p + j, st + i-2, 3);
            i-=3;
            j+=3;
        }
        // 오른쪽에서부터 3바이트씩 복사
    }

    p[len] = '\0';
    return p;
}
char *remove_blank(char st[]) {
    int len = (int)strlen(st);
    int krlen = len / 3;
    int j=0;
    char *p;
    p = malloc(len + 1);
    for (int i = 0; i < len;) {
        if (st[i] == ' ') {
            i++;
        }else {
            strncpy(p + j, st + i,3);
            i+=3;
            j+=3;
        }
    }
    p[len] = '\0';

    return p;
}