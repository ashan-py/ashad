//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
enum week {sun, mon, tue, wed, thu, fri, sat};
int p_23(void)
{
    enum week day1;
    day1=fri;
    printf("day1 : %d\n", day1);
    printf("fri : %d\n", fri);
    day1=mon;
    printf("day1 : %d\n", day1);
    printf("mon : %d\n", mon);
    return 0;
}