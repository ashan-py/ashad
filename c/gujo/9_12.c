//
// Created by 강병진 on 25. 9. 12.
//
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
double slow_power(double x, int n);
double fast_power(double x, int n);
double power(double x, int n);

int main() {
    clock_t start, stop;
    double duration;
    double sp, fp, p;

    //-------------------------------------------
    start = clock();

    for (int i = 1; i <= 5000000; i++) {
        sp = slow_power(2,500);
    }

    stop = clock();

    printf("sp's value:%f\n",sp);

    duration = (double) (stop - start) / CLOCKS_PER_SEC;
    printf("sp's time: %f\n", duration);
    //-------------------------------------------

    start = clock();
    for (int i = 1; i <= 5000000; i++) {
        p = power(2,500);
    }
    stop = clock();

    printf("p's value: %f\n",p);

    duration = (double) (stop - start) / CLOCKS_PER_SEC;

    printf("p's time: %f\n", duration);
    //-------------------------------------------

    start = clock();
    for (int i = 1; i <= 5000000; i++) {
        fp = fast_power(2,500);
    }
    stop = clock();

    printf("fp's value:%f\n",fp);

    duration = (double) (stop - start) / CLOCKS_PER_SEC;
    printf("fp's time: %f\n", duration);
}

double slow_power(double x, int n) {
    if (n==0) {
        return 1;
    }
    return x*slow_power(x,n-1);
}

double fast_power(double x, int n) {
    if (n==0){
        return 1;
    }
    if ((n%2)==0) {
        return fast_power(x*x,n/2);

    }
    return x*fast_power(x*x,(n-1)/2);

}
double power(double x, int n) {
    int i;
    double r = 1.0;
    for (i = 1; i <= n; i++) {
        r *= x;
    }
    return r;
}
