#include<stdio.h>
#define SQUARE(x) ((x)*(x))
int p_05(void)
{
    double x=2, y=5;
    printf("SQUARE(x+1)=%f\n", SQUARE(x+1));
    printf("SQUARE(x+1)/SQUARE(y+1)=%f\n",SQUARE(x+1)/SQUARE(y+1));
    return 0;
}
