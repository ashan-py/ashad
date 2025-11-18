//
// Created by 강병진 on 25. 6. 6.
//
#include <time.h>
#include <stdio.h>
int my_time(void);
int my_clock(void);

int p_12(void) {
    my_time();
    my_clock();
}
int my_time(void)
{
    time_t start, end;
    double i, pst, sum = 0;
    start = time(NULL);
    for (i = 0; i < 300000000; i++)
        sum += i;
    end = time(NULL);
    pst = difftime(end, start);
    printf("time: %f\n", pst);
    return 0;
}



int my_clock(void)
{
    clock_t start, end;
    double i, pst, sum = 0;
    start = clock();
    for (i = 0; i < 300000000; i++)
        sum += i;
    end = clock();
    pst = (double)(end - start) / CLOCKS_PER_SEC;
    printf("time: %f\n", pst);
    return 0;
}