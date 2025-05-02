#include <stdio.h>
long long fact(int n);
int main() {

    int n;
    printf("fac을 구하고 싶은 정수 n을 입력하시오: ");
    scanf("%d", &n);
    long long fac = fact(n);
    printf("%lld", fac);

    return 0;
}
long long fact(int n) {
    if (n!=1){
        return n*fact(n-1);
    }
    return 1;
}