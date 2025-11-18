//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
union data
{
    char ch;
    int n;
};
int p_22(void)
{
    union data v;
    printf("%d\n", sizeof(union data));
    v.ch='A';
    printf("%d\n", sizeof(v.ch));
    v.n=25;
    printf("%d\n", sizeof(v.n));
    return 0;
}
