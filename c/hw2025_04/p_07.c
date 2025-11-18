#include <stdio.h>
int p_07(void)
{
    char str1[5]="copy";
    char str2[5]="text";
    char *ptr;
    str1[0]='a';
    ptr=str1;
    *ptr='b';   //←오류발생
    str2[0]='c'; //←오류발생
    ptr=str2;
    *ptr='d';  //←오류발생
    printf("%s\n",str1);
    printf("%s\n",str2);
    return 0;
}
