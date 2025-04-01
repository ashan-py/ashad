//
//  projec.c
//  firstCppLanTestFile
//
//  Created by 강병진 on 3/18/25.
//

#include <stdio.h>
int main(void)
{
    int x;
    
    printf("int 변수 x의 크기 : %d\n\n", sizeof(x));
    
    printf("char형의 크기 : %d\n", sizeof(char));
    printf("short형의 크기 : %d\n", sizeof(short));
    printf("int형의 크기 : %d\n", sizeof(int));
    printf("long형의 크기 : \n\n", sizeof(long long));
    
    printf("float형의 크기 : %d\n", sizeof(float));
    printf("double형의 크기 : %d\n\n", sizeof(double));
    
}
