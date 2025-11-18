//
// Created by 강병진 on 25. 9. 12.
//
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int fib(int n);
int iter(int n);

int main() {
    clock_t start, stop;
    double duration;
    double fi, it;

    //-------------------------------------------
    start = clock();

    fi = fib(45);


    stop = clock();

    printf("fi's value:%f\n",fi);

    duration = (double) (stop - start) / CLOCKS_PER_SEC;
    printf("fi's time: %f\n", duration);
    //-------------------------------------------

    start = clock();

    it = iter(45);

    stop = clock();

    printf("it's value: %f\n",it);

    duration = (double) (stop - start) / CLOCKS_PER_SEC;

    printf("it's time: %f\n", duration);
    //-------------------------------------------

}

int fib(int n) {
    if (n==0) return 0;
    if (n==1) return 1;
    return (fib(n-1)+fib(n-2));

}

int iter(int n) {
    if (n<2) return n;
    else {
        int i,tmp,current=1, last=0;
        for (i=2;i <= n; i++) {
            tmp = current;
            current += last;
            last = tmp;
        }
        return current;
    }

}