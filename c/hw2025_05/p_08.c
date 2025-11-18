#include <stdio.h>
int dectobin(int n);
int p_08(void) {
    int n;
    printf("Please enter a number: ");
    scanf("%d", &n);
    dectobin(n);
    printf("\n");
    return 0;
}
int dectobin(int n) {
    if (n<1)
        return n;
    else {
        dectobin(n/2);
        printf("%d",n%2);
    }
}