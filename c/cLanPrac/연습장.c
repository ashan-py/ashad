// // // // // // #include <stdio.h>
// // // // // // //
// // // // // // // Created by 강병진 on 25. 4. 20.
// // // // // // //
// // // // // // void count(void);
// // // // // // int i = 4;
// // // // // // int main(void) {
// // // // // //
// // // // // //     printf("i=      %d\n", i);
// // // // // //     for (int i = 1; i <= 3; i++) {
// // // // // //         count();
// // // // // //
// // // // // //     }
// // // // // //     return 0;
// // // // // // }
// // // // // // void count(void) {
// // // // // //     printf("i=%d\n", i);
// // // // // //     int acnt = 0;
// // // // // //     static int stcnt = 0;
// // // // // //     acnt += 1;
// // // // // //     stcnt += 1;
// // // // // //     printf("acnt %d\n", acnt);
// // // // // //     printf("stcnt %d\n", stcnt);
// // // // // // }
// // // // // // #include<stdio.h>
// // // // // // #include<math.h>
// // // // // // int main() {
// // // // // //     for (double i = -2; i<=2.0;i+=0.1) {
// // // // // //         printf("%f\n",i);
// // // // // //         printf("exp %f\n",exp(i));
// // // // // //         printf("exp1/2(e^-x/2) %f\n", exp(-i/2));
// // // // // //
// // // // // //     }
// // // // // //}
// // // // // // #include <stdio.h>
// // // // // //
// // // // // // void gotoxy(int x, int y) {
// // // // // //     printf("\033[%d;%dH", y, x);
// // // // // // }
// // // // // //
// // // // // // int main() {
// // // // // //     printf("시작\n");
// // // // // //     gotoxy(10, 20);  // (x=10, y=5) 위치로 이동
// // // // // //     printf("여기에 찍음\n");
// // // // // //     return 0;
// // // // // // }
// // // // // //
// // // // // // #include<stdio.h>
// // // // // // int main() {
// // // // // //     int score[] = {1,2,3};
// // // // // //     score[3] = 6;
// // // // // //     printf("%d",score[3]);
// // // // // //
// // // // // // }
// // // // // //
// // // // // // #include<stdio.h>
// // // // // // int main(){
// // // // // //     char ch[1];
// // // // // //     printf("이름 입력: ");
// // // // // //     scanf("%s",&ch);
// // // // // //     printf("%s\n",ch);
// // // // // //     printf("학번 입력: ");
// // // // // //     scanf("%s",&ch);
// // // // // //     printf("%s\n",ch);
// // // // // // }
// // // // // // #include<stdio.h>
// // // // // // int main() {
// // // // // //     char str[100][3];
// // // // // //     str[0][0] = "강병진";
// // // // // //     str[1][0] = "2024210812";
// // // // // //     puts(str);
// // // // // // }
// // // // // // #include<stdio.h>
// // // // // // void asdf (char contry);
// // // // // // int main() {
// // // // // //     char contry[4][100] = {};
// // // // // //
// // // // // //     // for (int i = 0; i<4;i++) {
// // // // // //     //     gets(contry[i]);
// // // // // //     // }
// // // // // //     //
// // // // // //     // for (int i = 3; i>=0;i--) {
// // // // // //     //     puts(contry[i]);
// // // // // //     // }
// // // // // //     asdf("aadsf");
// // // // // //
// // // // // //     return 0;
// // // // // // }
// // // // // // void asdf (char* contry) {
// // // // // //     printf("%s",contry);
// // // // // //#include <stdio.h>
// // // // //
// // // // // // void asdf(char *contry); // 수정! (char → char *)
// // // // // //
// // // // // // int main() {
// // // // // //     char contry[4][100] = {};
// // // // // //     asdf(contry);
// // // // // //     return 0;
// // // // // // }
// // // // // //
// // // // // // void asdf(char *contry) { // 수정! (char → char *)
// // // // // //     printf("%s", contry);
// // // // // // }
// // // // //
// // // // // #include<stdio.h>
// // // // // #include<string.h>
// // // // // int main() {
// // // // //     // char a[20] = "adfsd";
// // // // //     // printf("%d", strlen(a));
// // // // //     //
// // // // //     // return 0;
// // // // //     // int i = 1;
// // // // //     //
// // // // //     // for (;i<=10; i++) {
// // // // //     //     printf("%d\n", i);
// // // // //     // }
// // // // //     int a=0, sum=0;
// // // // //
// // // // //     while (1) {
// // // // //         a++;
// // // // //         if ( a>5) break;
// // // // //         if (!(a%2)) continue;
// // // // //         sum+=a;
// // // // //     }
// // // // //     printf("a=%d, sum=%d\n", a, sum);
// // // // // }
// // // //
// // // // #include <stdio.h>
// // // // int prime(int a);
// // // // int main(void) {
// // // //     unsigned short a=0x1F55, b=0xAAEE;
// // // //     printf("aandb = %4x\n", a & b);
// // // //     printf("aorb = %4x\n", a | b);
// // // //
// // // //     printf("a>>1 = %4x\n", a >> 1);
// // // // }
// // // #include <stdio.h>
// // // int func_1(int n);
// // // int main(void)
// // // { func_1(11);
// // //     return(0);
// // // }
// // // int func_1(int n)
// // // {
// // //     if( n < 1 ) return(n);
// // //     else {
// // //         func_1(n / 2);
// // //         printf("%d ", n%2);
// // //     }
// // // }
// //
// // #include<stdio.h>
// // double sum(int a, int b);
// //
// // int main() {
// //     int a, b, temp;
// //     printf("첫번째 정수 : ");
// //     scanf("%d",&a);
// //     printf("두번째 정수 : ");
// //     scanf("%d",&b);
// //
// //     if (a>b) {
// //         temp = a;
// //         a = b;
// //         b = temp;
// //     }
// //     sum(a, b);
// // }
// // double sum(int a, int b) {
// //     int i,s=0;
// //     for (i=a+1; i<b;i++) {
// //         s += i;
// //     }
// //     printf("%d",s);
// // // }
// // #include<stdio.h>
// // int main() {
// //
// //     for (int i=0; i<10;i++) {
// //         int s = 1;
// //         for (int j=0; j<i;j++) {
// //
// //             s*=2;
// //
// //         }
// //         printf(" %d ",s);
// //     }
// // }
//
//
// #define _CRT_SECURE_NO_WARNINGS
// #include <stdio.h>
// #include <stdlib.h>
//
// #define ITER 1000000
//
// int main()
// {
//     int i, freq[11] = { 0 };
//     int da, db;
//     double prob[6] = { 0.15, 0.16, 0.17, 0.17, 0.17, 0.18 };
//     double p, prob_c[5] = { 0 };
//
//     srand(10);
//
//     prob_c[0] = prob[0];
//     for (i = 1; i < 5; i++)
//         prob_c[i] = prob_c[i - 1] + prob[i];
//
//     for (i = 0; i < ITER; i++) {
//         da = rand() % 6 + 1;
//         p = rand() / 32767.;
//
//         if (p <= prob_c[0]) db = 1;
//         else if (p <= prob_c[1]) db = 2;
//         else if (p <= prob_c[2]) db = 3;
//         else if (p <= prob_c[3]) db = 4;
//         else if (p <= prob_c[4]) db = 5;
//         else db = 6;
//
//         freq[da+db - 2]++;
//     }
//
//     printf("\nUsing Cumulative Probability \n");
//     printf("num   freq   freq(%%)\n");
//     for (i = 2; i <= 12; i++) {
//         printf("%2d : %4d %9.6f\n", i, freq[i - 2], 100. * freq[i - 2] / ITER);
//     }
//     for (i = 2; i < 12; i++) {
//         freq[i - 2] = 0;
//     }
//
//     for (i = 0; i < ITER; i++) {
//         da = rand() % 6 + 1;
//         db = rand() % 6 + 1;
//         freq[da + db - 2]++;
//     }
//
//     printf("\nUsing Uniform Distribution for Comparison\n");
//     printf(" num   freq    freq(%%)\n");
//     for (i = 2; i <= 12; i++) {
//         printf("%2d : %4d  %9.6f\n", i, freq[i - 2], 100. * freq[i - 2] / ITER);
//     }
//     return 0;
// }

#include<stdio.h>
void db(n);
void gc(n);
int main() {
    int e;
    e = 10;
    db(e);
    gc(e);
}
void db(n) {
    for (int i=0; i<n;i++) {
        int s = 1;
        for (int j=0; j<i;j++) {

            s*=2;

        }
        printf(" %d ",s);
    }
}
void gc(n) {
    int s = 0;
    for (int i=0; i<n;i++) {
        i++;
        s+=i;

    }
    printf("\n %d",s);
}